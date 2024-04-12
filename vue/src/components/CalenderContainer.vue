
<script setup>
import { ref } from "vue";

const date = ref();

</script>



<template>
    <div class="card flex justify-content-center">
         <Calendar v-model="date" inline showWeek class="Calendar" >  </Calendar> 
         
    </div>




</template>



<style scoped>
.card {
    width: 100%;
    display: flex;
    justify-content: center;
    padding: 1rem;
    height: auto;
    border: none;
    background-color: #FFFDF1;
}

</style>

