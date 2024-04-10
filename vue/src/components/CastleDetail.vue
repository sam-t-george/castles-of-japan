<template>
    <div class="castleDetail">
        <h3>{{ castle.castleName }}</h3>
        <p>{{ castle.longDesc }}</p>
        <img id="bannerPhoto" :src = "castle.castleBannerPhoto" alt = "bannerPhoto"> <!--can be deleted pending stove's input-->
        <p>{{ castle.address }}</p> <!--these are placeholders til we decide what goes in here--> <!--we will be calling alt images from img table with our castle_id that we also need to connect to here from castle on list that they select-->
        <div v-if="images && images.length"> <!--if they exist bc truthy language-->
            <img v-for="(image, index) in images" :key="index" :src="image" alt="Castle Image">
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