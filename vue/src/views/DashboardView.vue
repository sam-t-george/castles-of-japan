<template>
  <div class="main-container">
    <body @onload="loadToday()"></body>
    <div class="calendar-container">
      <div class="calendar">
        <Calendar v-model="visit.visitDate" inline class="Calendar" @click="getItinerary()"
          style="width: 600px; ">
          
        </Calendar>
      </div>




    </div>
    
    <div class="list-cont">
      <h2 class="visit-title">{{ visit.visitDate }}</h2>
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
      localStorage.visitDate= this.visit.visitDate;

    },
    printPage() {
      window.print(); // This triggers the browser's print functionality
    },
    loadToday() {
      console.log('is this working?');
      let loadedDate = new Date();  
      this.visit.visitDate = loadedDate.toISOString().split('T')[0];
      this.$store.dispatch('getVisitsByDate', this.visit.visitDate);
    }
  
  },

  
  created() {  //EDITED TO CALL FOR IMAGES
    if (this.visitId) {
      try {
        const visitResponse = CastleService.getCastleById(this.visitId);
        this.visit = visitResponse.data;
        this.$store.dispatch('getVisitsByDate', this.visit);
      } catch (error) {
        console.error(error);
      } //add better error message later
    
    }
    let loadedDate = new Date();  
    this.visit.visitDate = loadedDate.toISOString().split('T')[0];
    this.$store.dispatch('getVisitsByDate', localStorage.visitDate);
  },
  

  props: ['castle']
}
</script>

<style scoped>
.main-container {
  display: flex;
  width: 100%;
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
  padding: 20px;
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
  height: 50px;
  width: 5vw;
  display: flex;
}
h2 {
  /* position:relative; */
  display: flex;
  justify-content: center;
}
</style>
