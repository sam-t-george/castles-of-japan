<template>
    <!-- <GoogleMapAPI /> -->
    <MapBox />
</template>



<script>
import GoogleMapAPI from '../components/GoogleMapAPI.vue';
import MapBox from '../components/MapBox.vue';
export default {
    components: {
        // GoogleMapAPI
        MapBox
    },
    data: () => ({
    location: {
      lng: -71.224518,
      lat: 42.213995,
      bearing: 0,
      pitch: 0,
      zoom: 9,
    },
  }),
}
</script>

<style scoped>

</style>
