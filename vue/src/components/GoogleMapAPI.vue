<template>
    <div class="mapApi">
        <GoogleMap api-key="AIzaSyC4m-CO1YR4pNWx67QuQG6FsNqgjMIPR-s" style="width:100%;height:800px"
            :center="{ lat: 39.154626, lng: 139.159865 }" :zoom="6" :styles="[
                {
                    featureType: 'poi',
                    elementType: 'labels.icon',
                    stylers: [
                        {
                            visibility: 'off',
                        },
                    ],
                },
            ]">
        </GoogleMap>
    </div>
</template>



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
.mapApi {
    display: flex;
    height: 100vh;
    width: 100vw;
}
</style>