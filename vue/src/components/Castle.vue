<template>
    <div class="castle">
        <h3>{{ castle.castleName }}</h3>
        <img id=" bannerPhoto" :src = "castle.castleBannerPhoto" alt = "bannerPhoto">
        <p>{{ castle.address }}</p>
        <p>{{ castle.shortDesc }}</p>
       
    </div>
</template>

<script>
export default {
    props: ['castle']

}
</script>

<style scoped>
div.castle {
    border: 2px solid rgb(50, 134, 24);
    margin: 10px;
    width: 300px;
    min-width: 300px;
    height: 250px;
    text-align: center;
    border-radius: 5px;
}
</style>