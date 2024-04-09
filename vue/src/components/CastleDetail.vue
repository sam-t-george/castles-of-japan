<template>
    <p>CASTLEDETAIL</p>
    <div class="castleDetail">
        <h3>{{ castle.castleName }}</h3>
        <p>{{ castle.longDesc }}</p>
        <img id="bannerPhoto" :src = "castle.castleBannerPhoto" alt = "bannerPhoto">
        <p>{{ castle.address }}</p>
        <p>{{ castle.shortDesc }}</p> <!--these are placeholders til we decide what goes in here--> <!--we will be calling alt images from img table with our castle_id that we also need to connect to here from castle on list that they select-->
        
    </div>
</template>


<script>
export default {
    props: {
        castle: {
            type: Object,
            required: true
        }
    },
    
}
// export default {  //alternate one that does the same thing idk why
//     props: ['castle']
// }
</script>