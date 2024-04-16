<template>
  <div>
    <div class="cardplus">
      <div class="card mb-3" style="max-width: 540px;">
        <div class="row g-0">
          <div class="col-md-4">
            <img class="visit-image" :src="visit.castleBannerPhoto" alt="bannerPhoto">
          </div>
          <div class="col-md-8">
            <div class="card-body">
              <h5 class="visit-title">{{ visit.castleName }}</h5>
              <p class="visit-text">{{ visit.shortDesc }}</p>
              <p class="visit-region"><small class="text-muted">{{ visit.region }}</small></p>
              <i class="pi pi-trash" @click="deleteVisit"></i>
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

const date = ref();
export default {
  props: ['visit'],

  setup() {
    const showMenu = ref(false);
    const toggleCalendar = () => {
      showMenu.value = !showMenu.value;
    }
    return { showMenu, toggleCalendar };
  },

  methods: {
    deleteVisit() {
      this.$store.dispatch('deleteVisitsById', this.visit.visitId);

  }
}
}
</script>
  
<style scoped>
.visit-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
  overflow: hidden;
  border-radius: 10px;
  border-right: solid 1.5px black;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
}

.castle-content {
  flex: 1;
  width: 100%;
  padding-top: 1.2rem;
}

.visit-title,
.visit-text,
.visit-region {
  font-style: italic;
  color: white;
  

}

.castle-desc {
  font-size: .8em;
  text-shadow: 1px 1px 2px black;
  /* Text shadow */
}

.castle-name {
  font-size: 1.5rem;
  text-shadow: 1px 1px 2px black;
  /* Text shadow */
}

.castle-region small {
  color: #555b61;
  font-size: .8em;
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
}



.cardplus {
  margin: 1.2rem;

}

.card {
  display: flex;
  justify-content: center;
  border: 1.5px solid #193144;
  border-radius: 10px;
  height: auto;
  border: 1.5px solid #193144;
  background-color: #8BBAB1;
  box-shadow: 7px 10px 15px rgba(0, 0, 0, 0.4);
}
.card:hover {
  transform: scale(1.015);
  
}

</style>
