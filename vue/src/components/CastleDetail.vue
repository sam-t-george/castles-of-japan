<template>
    <div class="castleDetail">
        <h3>{{ castle.castleName }}</h3>
        <p>{{ castle.longDesc }}</p>
        <img id=" bannerPhoto" :src = "castle.castleBannerPhoto" alt = "bannerPhoto">
        <p>{{ castle.address }}</p>
        <p>{{ castle.shortDesc }}</p>
       
    </div>
</template>


<script>
import Castle from './Castle.vue';
</script>