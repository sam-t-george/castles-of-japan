<template>
    <div class="castleDetail">
        <div class="big-image">
            <div class="overlay">
        <h1 class="title">{{ castle.castleName }}</h1>
    </div>
  </div>
        <p>{{ castle.longDesc }}</p>
        <img id="bannerPhoto" :src = "castle.castleBannerPhoto" alt = "bannerPhoto"> <!--can be deleted pending steve's input-->
        <p>{{ castle.address }}</p> <!--these are placeholders til we decide what goes in here--> <!--we will be calling alt images from img table with our castle_id that we also need to connect to here from castle on list that they select-->
        <div v-if="images && images.length"> <!--if they exist bc truthy language-->
            <img v-for="(image, index) in images" :key="index" :src="image" alt="Castle Image">
        </div>
        <div class="google-map">
        <iframe :src="castle.mapLocation" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
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
        return {
           
        }
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
// export default {  //alternate one that does the same thing idk why
//     props: ['castle']
// }
</script>

<style scoped>
#castleDetail {
    /* Add your styles for the castle detail container here */
    /* Example styles: */
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #000000;
}
#bannerPhoto {
    max-width: 100rem;
}
</style>