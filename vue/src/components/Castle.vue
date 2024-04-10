<template>
  <router-link :to="{ name: 'castleDetail', params: { castleId: castle.castleId } }" class="castle-card">
    <div class="castle-card-body">
      <img class="castle-image" :src="castle.castleBannerPhoto" alt="bannerPhoto">
      <div class="castle-content">
        <h5 class="castle-name">{{ castle.castleName }}</h5>
        <p class="castle-desc">{{ castle.shortDesc }}</p>
        <p class="castle-address"><small>{{ castle.address }}</small></p>
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
  max-width: 33rem;
  border: 1.5px solid #000000; 
  border-radius: 20px;
  overflow: hidden; 
  text-decoration: none; 
  color: inherit; 
  transition: transform 0.2s; 
  margin-top: 5rem;
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
  aspect-ratio: 1/1;
  width: 100%; 
  height: 100%; 
  object-fit: cover;
  overflow: hidden; 
  border-radius: 10px;
}
.castle-content {
  flex: 1; 
}
.castle-name, .castle-desc, .castle-address {
  margin: 7px 0; 
  text-align: center;
}
.castle-address small {
  color: #6C757D; 
}
</style>