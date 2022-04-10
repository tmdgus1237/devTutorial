<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div class="star">
      <p v-for="(row,i) in 5" :key="i">
        <span v-for="(star,j) in i" :key="j">*</span>
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
    star: String,
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
  font-size: 30px;
}
.star {
  text-align: left;
  padding: 1% 40% 1% 40%;
}
</style>
