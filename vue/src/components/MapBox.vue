<template>
    <div class="mapview">
        <div class="mapColorBackground">
            <div id="mapContainer" ref="mapContainer" class="map-container"></div>
        </div>
    </div>
</template>

<script>
import mapboxgl from "mapbox-gl";

// Define your GeoJSON data here if it's not imported
const geojsonData = {
  "features": [
    {
      "type": "Feature",
      "properties": {
        "title": "Nijo Castle",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [-87.637596, 41.940403],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Himeji Castle",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [-86.637596, 41.940403],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Hirosaki Castle",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [-87.637596, 41.940403],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Osaka Castle",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [-86.637596, 41.940403],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Matsumoto-jo Castle",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [-87.637596, 41.940403],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Nagoya Castle",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [-86.637596, 41.940403],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Matsuyama-jo Castle",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [-87.637596, 41.940403],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Matsue-jo Castle",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [-86.637596, 41.940403],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Matsumae Castle",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [-87.637596, 41.940403],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Inuyama Castle",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [-86.637596, 41.940403],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Hiroshima Castle",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [-87.637596, 41.940403],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Edo Castle Ruins",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [35.6870, 139.7556],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Shimabara Castle",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [32.7892, 130.3673],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Hikone Castle",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [35.2765, 136.2518],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Maruoka Castle",
        "description": "A northside park that is home to the Lincoln Park Zoo"
      },
      "geometry": {
        "coordinates": [36.1519, 136.27046],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Gifu Castle",
        "description": "Mountainous Stronghold"
      },
      "geometry": {
        "coordinates": [136.780955, 35.434049],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Marugame Castle",
        "description": "The Fan-shaped Fortress"
      },
      "geometry": {
        "coordinates": [133.799613, 34.286113],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Kiyosu Castle",
        "description": "the Unifiers Assembly Hall"
      },
      "geometry": {
        "coordinates": [136.842723, 35.215084],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Kanazawa Castle",
        "description": "Historic Maeda Clan Fortress"
      },
      "geometry": {
        "coordinates": [136.657880, 36.56544],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Iwamura Castle",
        "description": "Ancient Mountain Fortress"
      },
      "geometry": {
        "coordinates": [137.451786, 35.360812],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Uwajima Castle",
        "description": "Original Hilltop Castle"
      },
      "geometry": {
        "coordinates": [132.564898, 33.218973],
        "type": "Point"
      }
    },
    {
      "type": "Feature",
      "properties": {
        "title": "Zakimi Castle Ruins",
        "description": "Historical Fortress Ruins in Okinawa"
      },
      "geometry": {
        "coordinates": [127.741224, 26.405427],
        "type": "Point"
      }
    },
    
    // Add other features here
  ],
  "type": "FeatureCollection"
};

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
        map.on('load', () => {
            map.resize();
            // Load the GeoJSON data onto the map
            geojsonData.features.forEach((feature) => {
                const marker = new mapboxgl.Marker()
                    .setLngLat(feature.geometry.coordinates)
                    .setPopup(new mapboxgl.Popup({ offset: 25 }) // add popups
                        .setHTML(`<h3>${feature.properties.title}</h3><p>${feature.properties.description}</p>`))
                    .addTo(map);
            });
        });
        this.map = map;
    },
    unmounted() {
        if (this.map) {
            this.map.remove();
        }
    }
    
}
</script>

<style>
.map-container {
    width: 90vw;
    height: 70vh;
    box-shadow: 2px 0px 15px 17px rgba(0, 0, 0, 0.35);
    border: 2px solid white;
}
/* Other styles remain unchanged */
</style>


<!-- 
<template>
    <div class="mapview">
        <div class="mapColorBackground">
            <div id="mapContainer" ref="mapContainer" class="map-container"></div>
        </div>
    </div>
</template>

<script>
import mapboxgl from "mapbox-gl";
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
        map.on('load', () => {
            map.resize();
        }),
            map.on('click', (e) => {
                const marker = new mapboxgl.Marker();
                marker.setLngLat(e.lngLat).addTo(map);
            });
    },
    unmounted() {
        this.map.remove();
        this.map = null;
    }
    
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
</style> -->