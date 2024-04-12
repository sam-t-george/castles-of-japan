
<script setup>
import { ref } from "vue";

const date = ref();

</script>



<template>
    <div class="card flex justify-content-center">
         <Calendar v-model="date" inline showWeek class="Calendar" >  </Calendar> 
         
<template>
    <div class="card flex justify-content-center">
        <Calendar v-model="date" inline showWeek class="Calendar" v-bind="visit" @dblclick="createVisit"> </Calendar>

    </div>




</template>


<script>
import { ref } from "vue";

export default {

    data() {
        return {
            visit: {
                date: '',
                userId: 2,       // might want to change this hard codeing later
                castleId: 22       // might want to change this hard codeing later
            }   

        }
    },

    methods: {
        createVisit() {
            // this.visit.castleId = 1;
            // this.visit.userId = 1;
            // this.visit.date = '2024-04-13';
            this.$store.dispatch('createVisit', this.visit);
        }
    }
}
</script>

<style scoped>

.card {
    display: flex;
    justify-content: center;
    padding: 1rem;
    height: auto;
    border: none;
    background-color: #FFFDF1;
}
</style>

