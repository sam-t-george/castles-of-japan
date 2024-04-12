<template>
    <div class="card flex justify-content-center">
        <Calendar v-model="visit.date" inline showWeek class="Calendar" @click="createVisit(castle)"> </Calendar>
        <p> date: {{ visit.date }}</p>
    </div>


</template>


<script>
import { ref } from "vue";
const date = ref();
export default {
    props: ['castle'],
    data() {
        return {
            visit: {
                date: '',
                userId: '',
                castleId: ''
            }
        }
    },
    methods: {
        createVisit(castleId, userId) {
            this.visit.castleId = castleId;
            this.visit.userId = userId;
            this.$store.dispatch('createVisit', this.visit);
        },
        dateChange() {
            console.log(this.visit);
        },
    },
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

