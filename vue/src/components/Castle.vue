<template>
  <div>
    <div class="cardplus">
      <router-link :to="{ name: 'castleDetail', params: { castleId: castle.castleId } }" class="castle-card">
        <div class="castle-card-body">
          <img class="castle-image" :src="castle.castleBannerPhoto" alt="bannerPhoto">
          <div class="castle-content">
            <h5 class="castle-name">{{ castle.castleName }}</h5>
            <p class="castle-desc">{{ castle.shortDesc }}</p>
            <p class="castle-region"><small>{{ castle.region }}</small></p>
          </div>
        </div>
      </router-link>
      <i class="pi pi-plus-circle" @click="toggleCalendar"></i>
      <div v-show="showMenu" class="calendar-container">
        <div class="card flex justify-content-center">
          <Calendar v-model="visit.date" inline class="Calendar" @click="createVisit()"> </Calendar>
          <p> date: {{ visit.date }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';
const date = ref();
export default {
  props: ['castle'],
  setup() {
    const showMenu = ref(false);
    const toggleCalendar = () => {
      showMenu.value = !showMenu.value;
    }
    return { showMenu, toggleCalendar, };
  },
  data() {
    return {
      visit: {
        date: '',
        castleId: '',      // might want to change this hard coding later
        userId: '1'      // might want to change this hard coding later
      },

    }
  },
  methods: {
    createVisit() {
      // castle ID
      this.visit.castleId = this.castle.castleId;

      //date attempts :(
      const aDate = new Date(this.visit.date);
      this.visit.date = aDate.toISOString(); //.split('T')[0]);

      console.log(this.visit);
      this.$store.dispatch('createVisit', this.visit);  
    },
    
  }
}
</script>

<style scoped>
.castle-card {
  display: block;
  max-width: 20rem;
  /* max scalable width */
  height: 30rem;
  /* new card height */
  background-color: #8bbab187;
  border: 1.5px solid #000000;
  border-radius: 20px;
  overflow: hidden;
  text-decoration: none;
  font-size: 1.4rem;
  color: inherit;
  transition: transform 0.15s;
  /* I think this is useless */
  box-shadow: 7px 10px 15px rgba(0, 0, 0, 0.4);
}

.castle-card:hover {
  transform: scale(1.015);
  /* dropped and raised again due to card size shrink */
}

.castle-card-body {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.castle-image {
  aspect-ratio: 1/1.1;
  width: 100%;
  height: 100%;
  object-fit: cover;
  overflow: hidden;
  border-radius: 10px;
  margin-bottom: 0px;
  border-bottom: solid 1.5px black;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
}

.castle-content {
  flex: 1;
  width: 100%;
  padding-top: 1.2rem;
}

.castle-name,
.castle-desc,
.castle-region {
  margin: 0rem;
  text-align: center;
  color: white;
  /* Changed font to white, will change back. We also need to pick a new font for stuff */

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
  color: #6C757D;
  font-size: .8em;
}

.pi-plus-circle {
  margin-top: .5rem;
  font-size: 2rem;
  display: flex;
  justify-content: end;
  padding: 10px;
  opacity: 75%;
}

.pi-plus-circle:hover {
  opacity: 100%;
}

.calendar-container {
  position: relative;
  left: 0;
  background-color: #FFFDF1;
  border-radius: 30px;
  padding: 10px;
  margin-bottom: 20px;
}

.cardplus {
  margin-bottom: 1.2rem;
  /* this changes margin on bottom of cards */
}

.card {
  display: flex;
  justify-content: center;
  padding: 1rem;
  height: auto;
  border: none;
  background-color: #FFFDF1;
}</style>
