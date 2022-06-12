<template>

  <div class="left">  
    <h1>{{ msg }}</h1>
    <div class="star">
      <div class="info">
        <p>
          <span>Choose your Pattern : </span>
          <select v-model="selected" @change="reset">
            <option disabled>Select your Pattern</option>
            <option v-for="(p, i) in patterns" :key="i" v-bind:value="i">{{ p }}</option>
          </select>
        </p>
        <p>
          <span>History Count : </span>
          <select v-model="histCnt" @change="resetHist">
              <option v-for="(p, i) in 10" :key="i" v-bind:value="p">{{ p }}</option>
          </select>
        </p>
        <p>
          <span>How many line? (1..100) : </span>
          <input type="number" @keyup.enter="getStars" placeholder="입력 후 Enter" @change="reset">
        </p>
        <p>{{ message }}</p>
      </div>
      <div v-bind:class="{short: openTF == false, full: openTF == true}">
        <Pattern v-bind:patternStyle="selected" v-bind:pattern="stars" v-bind:row="lines" />
      </div>
      <a href="#" class="btn_open" @click="openDetail">{{openMsg}}</a>
    </div>
  </div>
  <div class="right">
    <h1>Pattern History</h1>
    <button v-on:click="openHstDetail">{{openHstMsg}}</button>
    <div v-bind:class="{hide: openHstTF == false, show: openHstTF == true}">
      <div class="star" v-for="(d, i) in Number((end-front+max)%max)" :key="i">
        <p class="info">Pattern #{{d}}</p>
        <Pattern v-bind:patternStyle="histSelected[(max+end-d)%max]" v-bind:pattern="histStars[(max+end-d)%max]" v-bind:row="histLines[(max+end-d)%max]" />
      </div>
    </div>
    
  </div>
  
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import axios, { AxiosError } from 'axios';
// import PatternHistory from './PatternHistory.vue';
import Pattern from './Pattern.vue';


export default defineComponent({
  name: 'HelloWorld',
  components: {
    // PatternHistory,
    Pattern,
  },
  props: {
    msg: String,
  },
  data() {
    return{
      lines: 0,
      message: '',
      selected: -1,
      patterns: ['Triangle','Repeat Triangle','Three Star','Inverted','Inverted Triangle','Diamond'],
      stars: [''],
      histCnt: 1,
      histSelected: [0],
      histStars: [['']],
      histLines: [0],
      front: 0,
      end: 0,
      max: 10,
      openTF: false,
      openMsg: "더보기",
      openHstTF: false,
      openHstMsg: "Show History Pattern",
    }
  },
  watch : {
    patternAlign() {
      
    }
  },
  methods : {
    getStars(event:any) {
      this.lines = Number(event.target.value);
      if(this.lines < 1 || this.lines > 100 || this.lines % 1 != 0) {
        this.message = "1~100 정수를 입력하시오";
        this.lines = 0;
      }
      else {
        this.message = '';
        if(this.selected == 4 && this.lines % 2 == 0){
          this.reset();
          this.message = "Diamond Pattern은 홀수를 입력하시오."
          return;
        }
        else if(this.selected == -1){
          this.message = "Pattern을 먼저 선택하시오."
          return;
        }
        this.loadData();
      }
    },

    loadData(){
      axios.get('/api/star', {params: {pattern: this.selected, row: this.lines}}).then(response => {
        this.stars = response.data;
        if(this.selected == 1) this.lines = this.lines*(this.lines+1)/2;
  
        this.histStars[this.end] = this.stars;
        this.histSelected[this.end] = this.selected;
        this.histLines[this.end] = this.lines;
        this.end = (this.end+1)%this.max;
        // console.log(this.end);
        if((this.end - this.front + this.max) % this.max > this.histCnt) {
          this.front = (this.front+1)%this.max;
        }
      }).catch((e: AxiosError) =>{
        this.message = e.message;
      })
    },

    openDetail(){
      if(this.openTF == false){
        this.openTF = true;
        this.openMsg = "감추기";
      }
      else{
        this.openTF = false;
        this.openMsg = "더보기";
      }
    },

    openHstDetail(){
      if(this.openHstTF == false){
        this.openHstTF = true;
        this.openHstMsg = "Hide History Pattern";
      }
      else{
        this.openHstTF = false;
        this.openHstMsg = "Show History Pattern";
      }
    },

    getMinHistCnt(){
      return (this.end - this.front + this.max) % this.max;
    },

    reset() {
      this.stars= [''];
      this.message='';
      this.openTF = false;
    },

    resetHist() {
      this.front = 0;
      this.end = 0;
      this.histSelected= [0];
      this.histStars= [['']];
    }
  },
});

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
h3 {
  margin: 40px 0 0;
}
a {
  color: #42b983;
}
p {
  font-size: 20px;
}
.star {
  /* text-align: left; */
  padding: 1% 2% 1% 2%;
}

.left {
  overflow: scroll;
  width: 70%;
  height: 90%;
  float: left;
  box-sizing: content-box;
}

.right {
  overflow: scroll;
  width: 30%;
  padding-bottom: 75%;
  height: 90%;
  float: right;
  box-sizing: content-box;
  background: #d7f5e8;
}

.short {
  max-height: 600px;
  overflow: hidden;
}

.full {
  overflow: scroll;
}

.hide{
  display: none;
}

.show{
  display: block;
}
</style>
