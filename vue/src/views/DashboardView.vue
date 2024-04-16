<template>
  <div class="main-container">
    <div class="calendar-container">
      <div class="calendar">
        <Calendar v-model="visit.visitDate" inline class="Calendar" @click="getItinerary()" style="width: 600px; ">
        </Calendar>
      </div>
    </div>
    <div>
      <div class="visitList">
        <VisitList />
      </div>

      <div class="visit">
        <Visit />
      </div>
      <svg type="button" @click="printPage" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-printer"
        viewBox="0 0 16 16">
        <path d="M2.5 8a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1" />
        <path
          d="M5 1a2 2 0 0 0-2 2v2H2a2 2 0 0 0-2 2v3a2 2 0 0 0 2 2h1v1a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2v-1h1a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-1V3a2 2 0 0 0-2-2zM4 3a1 1 0 0 1 1-1h6a1 1 0 0 1 1 1v2H4zm1 5a2 2 0 0 0-2 2v1H2a1 1 0 0 1-1-1V7a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-1v-1a2 2 0 0 0-2-2zm7 2v3a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1v-3a1 1 0 0 1 1-1h6a1 1 0 0 1 1 1" />
      </svg>
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
  justify-content: space-between;
}

.calendar-container {
  width: 50%;
  height: 90vh;
  padding: 20px;
}


.calendar {
  size-adjust: 7rem;
  height: 100%;
  padding: 20px;
}

.visitList {
  width: 50vw;
  margin-bottom: 5rem;
}

.bi-printer {
  position: fixed;
  top: 7vw;
  right: 0;
  height: 50px;
  width: 5vw;
  display: flex;
  justify-content: flex-end;
  height: 50px;
  width: 5vw;
  display: flex;
  justify-content: flex-end;
}
</style>
