<template>
    <div class="castleDetailPage">
        <div class="big-image" :style="{ backgroundImage: 'url(' + castle.castleBannerPhoto + ')' }">
            <div class="overlay">
                <h1 class="title">{{ castle.castleName }}</h1>
            </div>
        </div>
        <div class="information">
            <div class="description">
                <p class="body">{{ castle.longDesc }}</p>
            </div>
            <div class="google-map">
                <iframe :src="castle.mapLocation" width="600" height="450" style="border:0;" allowfullscreen=""
                    loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
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
    height: 18vh;
    width: 100vw;
    position: relative;
    background-size: cover;
    background-position: center;
}
.carousel-item {
    transition: none !important;
    height: 50vh;
}
.carousel {
    height: 60vh;
    object-fit: contain; 
}

.carousel-item img {
    object-fit: cover; 
    height: 100%;
}

.carousel-indicators {
    bottom: 2rem;
}
.information {
    display: grid;
    grid-template-columns: 2fr 2fr; 
    column-gap: 4rem;
    padding-left: 7rem;
    padding-right: 7rem;
    padding-top: 2rem;
    margin-bottom: 2rem;
}

.img-container {
    grid-area: 1 / 1;
    display: flex;
}

.google-map {
    grid-area: 1 / 2 ;
    width: 100%;
    margin: 0;
    height: 50vh;
}

.description {
    grid-area: 2 /1 ;
    width: 100%;
    height: auto;
    font-size: 1.2rem;
    align-content: start;
    font-style: italic;
}

.google-map iframe {
    width: 100%;
    height: 100%;
}
</style>
