<template>
    <div class="castleDetail">
        <div class="big-image" :style="{ backgroundImage: 'url(' + castle.castleBannerPhoto + ')' }">
            <div class="overlay">
                <h1 class="title">{{ castle.castleName }}</h1>
            </div>
        </div>
        <div class="content">
            <div class="text-section">
                <p class="address">Address: {{ castle.address }}</p>
                <p class="body">{{ castle.longDesc }}</p>
            </div>
            <div class="google-map">
                <iframe :src="castle.mapLocation" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
        </div>
        <div class="img-container">
            <div class="img" v-if="images && images.length">
                <img v-for="(image, index) in images" :key="index" :src="image" alt="Castle Image">
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        castle: {
            type: Object,
            required: true
        },
        images: Array
    },
    data() {
        return {}
    },
    computed: {
        castles() {
            return this.$store.state.castle;
        }
    },
    created() {
        this.$store.dispatch('getCastleDetails');
    },
}
</script>

<style scoped>
.castleDetail {
    max-width: 100vw; 
    margin: 0 auto;
    padding: 20px;
    display: flex; 
    flex-wrap: wrap;
}

.big-image {
    height: 30vh; 
    width: 100%; 
    position: relative;
    background-size: cover;
    background-position: center;
}

.overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.63); 
    display: flex;
    justify-content: center;
    align-items: center;
    color: white;
    text-align: center;
    font-size: 2.5em;
    font-style: italic;
}

.content {
    width: 50%; 
    padding-left: 20px; 
    box-sizing: border-box;
}

.address {
    font-size: large;
}

.body {
    font-size: 35px;
}

.google-map {
    margin-top: 20px;
    width: 75%; 
    box-sizing: border-box;
}

.google-map iframe {
    width: 100%;
    height: 35vh; 
}

.img-container {
    width: 100%; 
    margin-top: 20px;
}

.img {
    display: flex; 
    flex-wrap: wrap; 
}

.img img {
    width: 50rem;
    box-sizing: border-box; 
    padding: 5px; 
}
</style>