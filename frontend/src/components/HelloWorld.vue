<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div class="star">
      <div>
        <span>Choose your Pattern : </span>
        <select v-model="selected" @change="reset">
          <option v-for="(p, i) in patterns" :key="i">{{ p }}</option>
        </select>
        <p></p>
        <span>How many line? (1..100) : </span>
        <input type="number" @keyup.enter="getStars" placeholder="입력 후 Enter">
        <p>{{ message }}</p>
      </div>
      <div :class="{patternA: selected == patterns[0], patternB: selected == patterns[1], patternC: selected == patterns[2]}"> 
        <p v-for="(row, index) in Number(lines)" :key="index">
          {{ stars[index] }}
        </p>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'HelloWorld',
  props: {
    msg: String,
  },
  data() {
    return{
      lines: 0,
      message: '',
      selected: '',
      patterns: ['Triangle','Inverted Triangle','Diamond'],
      stars: [''],
    }
  },
  methods : {
    getStars(event:any) {
      this.lines = Number(event.target.value);
      if(this.lines < 1 || this.lines > 100 ) {
        this.message = "1~100 숫자를 입력하시오";
        this.lines = 0;
      }
      else {
        this.message = '';
        if(this.selected == this.patterns[2]){
          if(this.lines % 2 == 0){
            this.reset();
            this.message = "Diamond Pattern은 홀수를 입력하시오."
            return;
          }
          this.getDiamond();
        }
        else{
          this.getTriangle();
        }
        
      }
    },

    getTriangle(){
      this.stars[0] = '*';
        for(let i = 1; i < this.lines; i++){
          this.stars[i] = this.stars[i-1].concat('*');
        }
    },

    getDiamond(){
      this.stars[0] = '*';
      this.stars[this.lines-1]='*';
      let diaLines = this.lines/2;

      for(let i = 1; i < diaLines; i++){
        this.stars[i] = this.stars[i-1].concat('*');
        this.stars[this.lines -1 - i] = this.stars[i];
      }
    },

    reset() {
      this.stars= [''];
      this.message='';
    },
  },
});

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
a {
  color: #42b983;
}
p {
  font-size: 20px;
}
.patternA {
  text-align: left;
}
.patternB {
  text-align: right;
}
.patternC {
  text-align: center;
}
.star {
  /* text-align: left; */
  padding: 1% 30% 1% 30%;
}
</style>
