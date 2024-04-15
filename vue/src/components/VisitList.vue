<template>
    <body id="body">
        <section id="visitList">
            <Visit v-for="currentVisit in visits" 
            v-bind:key="currentVisit.visitId" v-bind:visit="currentVisit" />
        </section>
    </body>
</template>
<script>

import Visit from '../components/Visit.vue';
export default {
    components: {
        Visit
    },
    data() {
        
    },
    computed: {
        visits() {
            return this.$store.state.visitList;
        }
    },
    
    created() {
        this.$store.dispatch('getAllVisits');
    }
}
</script>
<style scoped>
section#visitList {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
    background-color: #FFFDF1;
    padding-top: 4px;
}
</style>