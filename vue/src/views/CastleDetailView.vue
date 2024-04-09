<template>

    <h1> DETAILVIEW </h1>
    <!-- <CastleDetail :castle="castle"/> -->
    <CastleList />
    <div class="google-map">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3250.8428659514193!2d136.77949637622285!3d35.433922343519065!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6003a9798f2e0eab%3A0x2871c3655542c94a!2sGifu%20Castle!5e0!3m2!1sen!2sus!4v1712526771452!5m2!1sen!2sus" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </div>
</template>
  
<script>
import CastleDetail from '../components/CastleDetail.vue';
import Castle from '../components/Castle.vue';
import CastleList from '../components/CastleList.vue';

export default {
    components: {
    CastleDetail,
    CastleList
},
props: ['castleId'],
data() {
    return {
        castle: null,  // could be [] or {} also probably maybe we have no idea
    };
},

 // fetch castle details here in created

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