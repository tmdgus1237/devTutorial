<template>
    <div v-bind:class="{short: showDetail == false, full: showDetail == true}">
        <a href="#" v-if="showDetail==false" @click="openDetail" v-bind:class="{hide: row < defaultShowLines, show: row == defaultShowLines}">더보기</a>
        <a href="#" v-else @click="openDetail" class=show>감추기</a>

        <div v-bind:class="{patternA: patternStyle < 4, patternB: patternStyle == 4, patternC: patternStyle == 5}"> 
            <p v-for="(r, index) in Number(showLines)" :key="index">
                {{ pattern[index] }}
            </p>
        </div>
    </div>

</template>

<script lang="ts">
import { defineComponent } from 'vue'

export default defineComponent({
    props: {
        patternStyle: Number,
        pattern: Array,
        num: Number,
        row: {
            type: Number,
            default: 0
            },
    },
    watch: {
        num() {
            this.showDetail = false;
            this.showLines = (this.row <= this.defaultShowLines) ? this.row : this.defaultShowLines;
        }
    },
    data() {
        return{
            histCnt: 1,

            // 더보기
            showDetail: false,
            showLines: 20,
            defaultShowLines: 20,
        }
    },
    methods: {
        openDetail(){
            if(this.showDetail == false){
                this.showDetail = true;
                this.showLines = this.row;
            } else{
                this.showDetail = false;
                this.showLines = this.defaultShowLines;
            }
        },
    }
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

.short {
  max-height: 600px;
  overflow: hidden;
}
.full {
  overflow: scroll;
}
</style>