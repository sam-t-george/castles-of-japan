<template>
  <div class="main-container">
    <div class="calendar-container">
      <Calendar v-model="visitDate" inline class="Calendar" > </Calendar>
      
    </div>

     <div>
      
      
      <div class="visitList">
        <VisitList />
      </div>

      <!-- <div class="visit">
        <Visit />
      </div> -->

      
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
          castleId: '',
          visitId: '',
          username: '',
          visitDate: '',
          castleName: '',
          castleBannerPhoto: '',
          shortDesc: ''

        },
  
      }
    },
    methods: {
    createItinerary(){
      this.visit.castleId = this.currentVisit.castleId;



      this.$store.dispatch('createItinerary', this.visit); 
    },
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
  flex: 1;
  height: fit-content;
  padding: 20px;
}

.event-cards {
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: start;
  align-items: center;
  padding: 20px;
  height: 100vh;
}
</style>
