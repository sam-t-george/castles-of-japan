<template>
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
</template>

<script>
export default {
  props: ['castle']
}
</script>



<style scoped>

.castle-card {
  display: block;
  max-width: 30rem;
  
  border: 1.5px solid #000000; 
  border-radius: 20px;
  overflow: hidden; 
  text-decoration: none; 
  font-size: 1.4rem;
  color: inherit; 
  transition: transform 0.2s; 
  margin-bottom: 5rem;
  box-shadow: 7px 10px 15px rgba(0,0,0,0.4);
}
.castle-card:hover {
  transform: scale(1.02); 
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
  margin-bottom: 5px;
  border-bottom: solid 1.5px black;
  box-shadow: 0 2px 4px rgba(0,0,0,0.3);
}
.castle-content {
  flex: 1; 
}
.castle-name, .castle-desc, .castle-region {
  margin: .4rem; 
  text-align: center;
}
.castle-region small {
  color: #6C757D; 
  font-size: .8em;
}

</style>