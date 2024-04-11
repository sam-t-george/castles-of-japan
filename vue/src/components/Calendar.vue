
<template>
    <div class="card flex justify-content-center">
  
        <Calendar v-model="date" inline showWeek />
    </div>
</template>

<script setup>
import Calendar from 'primevue/calendar';
import { ref } from "vue";


const date = ref();
</script>
