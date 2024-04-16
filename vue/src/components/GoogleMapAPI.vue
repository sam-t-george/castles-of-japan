<template>
    <div class="mapWhole">
        <div class="mapApi">
            <GoogleMap class="map" api-key="AIzaSyC4m-CO1YR4pNWx67QuQG6FsNqgjMIPR-s" style="width:90%;height:80%"
                :center="{ lat: 39.154626, lng: 139.159865 }" :zoom="6">
            </GoogleMap>
        </div>
    </div>
</template>

<!-- :styles="[
                    {
                        featureType: 'poi',
                        elementType: 'labels.icon',
                        stylers: [
                            {
                                visibility: 'off',
                            },
                        ],
                    },
                ]" -->


<script>
import { ref, onMounted } from 'vue';
import { defineComponent } from 'vue';
import { GoogleMap } from "vue3-google-map";

export default defineComponent({
    components: { GoogleMap }
})

const map = ref(null);

// onMounted(()=> {
//     new window.google.maps.Map(map.value, {
//         center: {lat:37.154626, lng:139.159865},
//         zoom:10
//     });
// });


// import { GoogleMap } from "vue3-google-map";
// export default {
//     components: {
//         GoogleMap,
//     },
//     data() {
//         return {
//             apiKey:"AIzaSyC4m-CO1YR4pNWx67QuQG6FsNqgjMIPR-s",
//         }
//     }
// }
</script>

<style scoped>
.mapWhole {
  display: flex;
  justify-content: center;
  height: 85vh;
  width: 100vw;
  position: relative;
  background-size: hidden;
  background-position: 25%;
  background-image: url('../assets/mapBackground.jpg')
}
.mapApi {
    display: flex;
    height: 100%;
    width: 100vw;
    justify-content: center;
    align-items: center;
    display: flex;
    background-size: hidden;
    background-position: 25%;
    background: #334e49ce;
}
.map {
    box-shadow:  10px 0px 8px 12px rgba(0, 0, 0, 0.3);
    border: 2px solid white;
}
</style>