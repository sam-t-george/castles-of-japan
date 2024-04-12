
<script>
import { ref } from "vue";


const date = ref();

export default {
    
}
</script>

<template>
    <div class="card flex justify-content-center" >
         <Calendar v-model="date" inline showWeek class="Calendar">  </Calendar> 
        
    </div>
</template>



<style scoped>


</style>

