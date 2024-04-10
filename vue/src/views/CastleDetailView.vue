<template>
    <CastleDetail :castle="castle" :images="images"/>
    <!-- <div class="google-map">
        <iframe :src="castle.mapLocation" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </div> -->
</template>
  
<script>
import CastleDetail from '../components/CastleDetail.vue';
import CastleService from '../services/CastleService';


export default {
    components: {
    CastleDetail
},
props: ['castleId'],
data() {
    return {
        images: {},
        castle: {},  // could be [] or {} also probably maybe we have no idea
        
    };
},
async created() {  //EDITED TO CALL FOR IMAGES
    if (this.castleId) {
        try {
            const castleResponse = await CastleService.getCastleById(this.castleId);
            this.castle = castleResponse.data;
            const imagesResponse = await CastleService.getImagesByCastleId(this.castleId);
            this.images = imagesResponse.data.map(image => image.imgPath);
            this.$store.dispatch('getCastlePictures', this.castleId);
        } catch (error) {
            console.error(error);
        } //add better error message later
    }
},
}


</script>

<style scoped>
.google-map {
     padding-bottom: 50%;
     position: relative;
}

.google-map iframe {
     height: 100%;
     width: 100%;
     left: 0;
     top: 0;
     position: absolute;
}

</style>