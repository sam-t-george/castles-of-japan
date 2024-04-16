<template>
  <div class="main-container">
    <div class="calendar-container">
    <div class="calendar">
      <Calendar v-model="visit.visitDate" inline class="Calendar" @click="getItinerary()" style="width: 600px; "></Calendar>

    </div>
  </div>
     <div>
      
       
      <div class="visitList">
        <VisitList />
      </div>

      <div class="visit">
        <Visit />
      </div>

      
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
    getItinerary(){ 
      const aDate = new Date(this.visit.visitDate);
      this.visit.visitDate = aDate.toISOString().split('T')[0];
      

      this.$store.dispatch('getVisitsByDate', this.visit.visitDate); 
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
  width: 50%;
  height: 90vh;
  padding: 20px;
}


.calendar {
  size-adjust: 7rem;
  height: 100%;
  padding: 20px;
}

.visitList{
  width: 50vw;
  margin-bottom: 5rem;
}

</style>
