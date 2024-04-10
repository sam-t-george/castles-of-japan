<template>
    <div class="castleDetailPage">
        <div class="big-image" :style="{ backgroundImage: 'url(' + castle.castleBannerPhoto + ')' }">
            <div class="overlay">
                <h1 class="title">{{ castle.castleName }}</h1>
            </div>
        </div>
        <div class="information">
            <div class="text-section">
                <p class="address">Address: {{ castle.address }}</p>
                <p class="body">{{ castle.longDesc }}</p>
            </div>
            <div class="google-map">
                <iframe :src="castle.mapLocation" width="600" height="450" style="border:0;" allowfullscreen=""
                    loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>

            <div class="img-container">
                <div class="img" v-if="images && images.length">
                    <img v-for="(image, index) in images" :key="index" :src="image" alt="Castle Image">
                </div>
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
.castleDetailPage {
    max-width: 100vw;
    margin-top: 10px;

    display: flex;
    flex-wrap: wrap;
}

.big-image {
    height: 25vh;
    width: 100vw;
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
    
    padding-left: 5px;
    box-sizing: border-box;
}

.address {
    font-size: 20px;
}

.body {
    font-size: 25px;
    width: 50%;
}

.google-map {
    margin: 20px;
    width: 50%;
    height: 35vh;
    
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