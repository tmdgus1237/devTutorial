<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div class="star">
      <span>How many line? (1..100) </span>
      <input type="text" @keyup.enter="getLines" placeholder="입력 후 Enter">
      <p>{{ message }}</p>
      <p v-for="(row, i) in Number(lines)" :key="i">
        <span v-for="(star,j) in row" :key="j">*</span>
      </p>
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
    }
  },
  methods : {
    getLines(event:any) {
      this.lines = Number(event.target.value); //.replace(/[^0-9]/g,'')
      if(this.lines < 1 || this.lines > 100 ) {
        this.message = "1~100 숫자를 입력하시오";
        this.lines = 0;
      }
      else {
        this.message = '';
      }
      console.log(this.lines);
    },
  },
});

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
p {
  font-size: 20px;
}
.star {
  text-align: left;
  padding: 1% 40% 1% 40%;
}
</style>
