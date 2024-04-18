<template>
    <div class="mapview">
        <div class="mapColorBackground">
            <div id="mapContainer" ref="mapContainer" class="map-container"></div>
        </div>
    </div>
</template>
import mapboxgl from "mapbox-gl";
<script>
mapboxgl.accessToken = "pk.eyJ1IjoiamtuYWhheSIsImEiOiJjbHY0OWNucXcwNmZiMndtc29ld2FwcDV2In0.bJ_p63ehT0V3LBk7v3Fc1Q"
export default {
    components: {

    },
    mounted() {
        const mapDoc = document.getElementById("mapContainer")
        const map = new mapboxgl.Map({
            container: mapDoc,
            style: "mapbox://styles/mapbox/streets-v12",
            center: [138.391614, 38.031578],
            zoom: 4.8,
        });
        // map.on('load', () => {
        //     map.resize();
        // }),
        //     map.on('click', (e) => {
        //         const marker = new mapboxgl.Marker();
        //         marker.setLngLat(e.lngLat).addTo(map);
        //     });
    },
    // unmounted() {
    //     this.map.remove();
    //     this.map = null;
    // }
}
</script>
<style>
.map-container {
    width: 90vw;
    height: 70vh;
    box-shadow: 2px 0px 15px 17px rgba(0, 0, 0, 0.35);
    border: 2px solid white;
}

.mapview {
    height: 86vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background-position: 25%;
    background-image: url('../assets/mapBackground.jpg');
}

.mapboxgl-ctrl-bottom-right,
.mapboxgl-ctrl-bottom-left {
    opacity: 0;
}
.mapColorBackground {
    display: flex;
    height: 100%;
    width: 100vw;
    justify-content: center;
    align-items: center;
    display: flex;
    background: #334e49ce;
}
</style>