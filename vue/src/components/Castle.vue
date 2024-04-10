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
  border-radius: 20px; /* Rounded corners */
  overflow: hidden; /* Ensures the content fits within the border */
  text-decoration: none; /* Removes underline from link */
  color: inherit; /* Inherits text color */
  transition: transform 0.2s; /* Smooth transformation on hover */
  margin-top: 5rem;
}
.castle-card:hover {
  transform: scale(1.02); /* Slight zoom on hover */
}
.castle-card-body {
  display: flex;
  flex-direction: column;
  align-items: center; /* Aligns items vertically center */
}
.castle-image {
  aspect-ratio: 1/1;
  width: 100%; /* Fixed width, adjust as needed */
  height: 100%; /* Fixed height, adjust as needed */
  object-fit: cover;
  overflow: hidden; /* Ensures the image covers the area */
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