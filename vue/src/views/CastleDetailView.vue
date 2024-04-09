<template>
    <CastleDetail :castle="castle"/>
    <div class="google-map">
        <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d13070.828175646166!2d135.7484258!3d35.0140379!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x600107d40a2b9b0b%3A0x106b8759906a2f2f!2sNij%C5%8D%20Castle!5e0!3m2!1sen!2sus!4v1712615526641!5m2!1sen!2sus" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
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