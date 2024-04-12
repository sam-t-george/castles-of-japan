
<script setup>
import { ref } from "vue";


const date = ref();
console.log(date)
</script>

<template>
    <div class="card flex justify-content-center">
         <Calendar v-model="date" inline showWeek class="Calendar"> </Calendar> 
        
    </div>
</template>



<style scoped>
.Calendar {
 
}

</style>

