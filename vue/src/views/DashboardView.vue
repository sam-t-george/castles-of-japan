<template>
  <div class="main-container">
    <div class="calendar-container">
      <div class="calendar">
        <Calendar v-model="visit.visitDate" inline class="Calendar" @click="getItinerary()" style="width: 40rem; ">
        </Calendar>
      </div>
    </div>
    <div class="list-cont">
      <VisitList />
    </div>
  </div>
</template>
       


<script>
import Visit from '../components/Visit.vue';
import VisitList from '../components/VisitList.vue';
import CastleService from '../services/CastleService';



export default {
  components: {
    // Visit,
    VisitList,
  },
  data() {
    return {
      visit: {
        visitDate: '',
      },
    }
  },
  methods: {
    getItinerary() {
      const aDate = new Date(this.visit.visitDate);
      this.visit.visitDate = aDate.toISOString().split('T')[0];
      this.$store.dispatch('getVisitsByDate', this.visit.visitDate);
    },
    printPage() {
      window.print(); // This triggers the browser's print functionality
    }
  },
  async created() {  //EDITED TO CALL FOR IMAGES
    if (this.visitId) {
      try {
        const visitResponse = await CastleService.getCastleById(this.visitId);
        this.visit = visitResponse.data;
        this.$store.dispatch('getAllVisits', this.visit);
      } catch (error) {
        console.error(error);
      } //add better error message later
    }
  },
  props: ['castle']
}
</script>

<style scoped>
.main-container {
  display: flex;
  width: 100vw;
}
#calendar-container {
  width: 50vw;
}
.list-cont {
  width: 50vw;
}

.calendar {
  display: flex;
  height: 23rem;
  margin: 40px;
}

.visitList {
  width: 50vw;
  margin-top: 20px;
  justify-content: center;
}

.bi-printer {
  position: fixed;
  top: 7vw;
  right: 0;
  height: 50px;
  width: 5vw;
  display: flex;
  justify-content: flex-end;
}
</style>
