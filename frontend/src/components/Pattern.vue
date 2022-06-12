<template>   
    <div v-bind:class="{patternA: patternStyle < 4, patternB: patternStyle == 4, patternC: patternStyle == 5}"> 
        <p v-for="(row, index) in Number(row)" :key="index">
            {{ pattern[index] }}
        </p>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'

export default defineComponent({
    props: {
        patternStyle: Number,
        pattern: Array,
        row: Number,
    },
    data() {
        return{
            histCnt: 1,
        }
    },
})


</script>

<style scoped>
p {
    line-height: 0.5px;
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
</style>