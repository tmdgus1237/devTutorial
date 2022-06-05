<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <h1> Hello World</h1>
  <div class="contents">
    <HelloWorld msg="Pointing star"/>
    
  </div>
  
  
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import HelloWorld from './components/HelloWorld.vue';


export default defineComponent({
  name: 'App',
  components: {
    HelloWorld
  }
});
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 30px;
}

.contents {
  width: 100%;
  height: 100%;
  
}

.info {
  text-align: left;
}

</style>
