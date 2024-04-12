
<script setup>
import { ref } from "vue";


const date = ref();

</script>

<template>
    <div class="card flex justify-content-center" >
         <Calendar v-model="date" inline showWeek class="Calendar">  </Calendar> 
        
    </div>
</template>



<style scoped>
.card {
    display: flex;
    justify-content: center;
    padding: 1rem;
    height: auto;
}
.Calendar {
    height: fit-content;
}
</style>

