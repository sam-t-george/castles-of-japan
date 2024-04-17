<template>
  <div>
    <div class="cardplus">
      <div class="card mb-3" style="max-width: 28vw;  ">
        <div class="row g-0">
          <div class="col-md-4"> 
            <router-link :to="{ name: 'castleDetail', params: { castleId: visit.castleId } }">
              <img class="visit-image" :src="visit.castleBannerPhoto" alt="bannerPhoto" >
            </router-link>
          </div>
          <div class="col-md-8">
            <div class="card-body">
              <h5 class="visit-title">{{ visit.castleName }}</h5>
              <p class="visit-text">{{ visit.shortDesc }}</p>
              <p class="visit-region"><small class="text-muted">{{ visit.region }}</small></p>
              <i type = "button" class="pi pi-trash" @click="deleteVisit"></i>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';
import CastleService from '../services/CastleService';
import authService from "../services/AuthService";

export default {
  props: ['visit'],

  setup() {
    const showMenu = ref(false);
    const toggleCalendar = () => {
      showMenu.value = !showMenu.value;
    };
    const deleteVisit = () => {
      // Assuming you have access to this.$store here
      this.$store.dispatch('deleteVisitsById', this.visit.visitId);
    };
    
    return { showMenu, toggleCalendar, deleteVisit };
  },
}
</script>

<style scoped>
.visit-image {
  width: 100%;
  height: 100%;
  aspect-ratio: 1/1;
  object-fit: cover;
  overflow: hidden;
  border-radius: 10px;
  border-right: solid 1.5px black;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
}
.visit-title,
.visit-text,
.visit-region {
  font-style: italic;
  color: white;
}
.pi-trash {
  margin-top: .5rem;
  display: flex;
  width: 1rem;
  opacity: 75%;
}
.pi-trash:hover {
  opacity: 100%;
  color: rgb(184, 0, 0);
  transform: scale(1.015);
}
.cardplus {
  margin-bottom: 1.9rem;
}
.card {
  display: flex;
  justify-content: center;
  border: 1.5px solid #193144;
  border-radius: 10px;
  background-color: #8BBAB1;
  box-shadow: 7px 10px 15px rgba(0, 0, 0, 0.4);
}
.card:hover {
  transform: scale(1.015);
}
</style>