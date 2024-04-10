<template>
    <CastleDetail :castle="castle"/>
    <div class="google-map">
        <iframe :src="castle.mapLocation" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </div>
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
async created() {
    if (this.castleId) {
        try {
            const response = await CastleService.getCastleById(this.castleId);
            this.castle = response.data;
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