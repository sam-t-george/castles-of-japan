<template>
    <div class="mapWhole">
        <div class="mapApi">
            <GoogleMap ref="mapRef" class="map" api-key="AIzaSyC4m-CO1YR4pNWx67QuQG6FsNqgjMIPR-s"
                style="width:90%;height:80%" :center="center" :zoom="5.5">
                <Marker :options="{ position: { lat: 38.154626, lng: 139.159865 }, visible: true, }"/>
            </GoogleMap>
        </div>
    </div>
</template>

<script>
import { ref, onMounted } from 'vue';
import { defineComponent } from 'vue';
import { GoogleMap, Marker } from "vue3-google-map";

export default defineComponent({
    components: { GoogleMap, Marker },
    setup() {
        const mapRef = ref(null);
        const center = { lat: 38.5, lng: 139.159865 }; 
        
        return {center}
    }
});

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
    height: 86vh;
    width: 100vw;
    background-position: 25%;
    background-image: url('../assets/mapBackground.jpg');
}
.mapApi {
    display: flex;
    height: 100%;
    width: 100vw;
    justify-content: center;
    align-items: center;
    display: flex;
    background: #334e49ce;
}
.map {
    box-shadow: 2px 0px 15px 17px rgba(0, 0, 0, 0.35);
    border: 2px solid white;
}
</style>