<template>
<router-link :to="{ name: 'castleDetail', params: { castleId: castle.castleId } }" class="card" style="max-width: 540px;"> <!--adding castleId as param-->
  <div class="row-no-gutters">
    <div class="image-container">
        <img id="bannerPhoto" :src = "castle.castleBannerPhoto" alt = "bannerPhoto">
    </div>
      <div class="card-body">
        <h5 class="castle-name">{{ castle.castleName }}</h5>
        <p class="castle-desc">{{ castle.shortDesc }}</p>
        <p class="castle-address"><small class="text-muted">{{ castle.address }}</small></p>
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

div.image-container img {
    aspect-ratio: 1/1;
    object-fit: cover;
    width: 100%;
    height: 100%;
    overflow: hidden;
}
</style>