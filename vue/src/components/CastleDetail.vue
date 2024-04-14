<template>
    <div class="castleDetailPage">
        <div class="big-image" :style="{ backgroundImage: 'url(' + castle.castleBannerPhoto + ')' }">
            <div class="overlay">
                <h1 class="title">{{ castle.castleName }}</h1>
            </div>
        </div>
        <div class="information">
            <!-- <div class="castleaddress">
                <p class="address">Address: {{ castle.address }}</p>
            </div> -->
            <div class="description">
                <p class="body">{{ castle.longDesc }}</p>
            </div>
            <div class="google-map">
                <iframe :src="castle.mapLocation" width="600" height="450" style="border:0;" allowfullscreen=""
                    loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>

            <!-- <div class="img-container">
                <div class="img" v-if="images && images.length">
                    <img v-for="(image, index) in images" :key="index" :src="image" alt="Castle Image">
                </div>
            </div> -->
            <!---->
            <div id="carouselExampleIndicators" class="carousel" data-interval="false" ref="carousel">
                <div class="thumbnail">
                    <div v-for="(image, index) in images" :key="'item' + index" class="carousel-item"
                        :class="{ active: index === 0 }">
                        <img :src="image" class="d-block w-100" alt="Slide Image">
                    </div>
                </div>
                <div class="carousel-indicators">
                    <button v-for="(image, index) in images" :key="'indicator-' + index" type="button"
                        data-bs-target="#carouselExampleIndicators" :data-bs-slide-to="index"
                        :class="{ 'active': index === 0 }" aria-label="'Slide ' + (index + 1)">
                        <img :src="image" class="d-block w-100" alt="Thumbnail Image">
                    </button>
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
.carousel-item {
    transition: none !important;
}
#carousel-indicators{
    margin-left: 0px;
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

.big-image {
    height: 25vh;
    width: 100vw;
    position: relative;
    background-size: cover;
    background-position: center;
}

.information {
    display: grid;
    grid-template-columns: 2.5fr 2fr;
    grid-template-rows: 3fr 2.5fr;
    gap: 20px;
    padding: 20px;
}

.img-container {
    grid-area: 1 / 1 / 3 / 2;
    display: flex;
    flex-wrap: wrap;
    align-content: flex-start;
}

.google-map {
    grid-area: 1 / 2 / 2 / 3;
    width: 100%;
    margin: 0;
}

.description {
    grid-area: 2 / 2 / 3 / 3;
    width: 100%;
    height: auto;
    font-size: 2.3em;
    align-content: start;
}

.google-map iframe {
    width: 100%;
    height: 100%;
}

.img img {
    width: 100%;
    padding: 2px;
}
</style>