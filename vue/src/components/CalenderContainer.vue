
<script setup>
import { ref } from "vue";


const date = ref();
console.log(date)
</script>

<template>
    <div class="card-flex-justify-content-center" >
        <Calendar v-model="date" inline showWeek class="Calendar" > </Calendar> 
    </div>
</template>



<style scoped>
.card {
    width: 95%;
    display: flex;
    justify-content: center;
}
.Calendar{
    display: flex;
    width: 100%;
    height: auto;
}
.card-flex-justify-content-center {
    padding-left: 20px;
    padding-right: 20px;
    width: 100%;
    height: 100%;
}
</style>

