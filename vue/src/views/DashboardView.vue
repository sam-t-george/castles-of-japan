<template>
    <div class="container" >
    <CalenderContainer />
    </div>
</template>

<script>
import CalenderContainer from '../components/CalenderContainer.vue';



export default {
    components: {
   CalenderContainer
}
}
</script>

<style scoped>


.container {
    display: flex;
    justify-content:  flex-start;
    margin-top: 20px;
    margin-bottom: 20px;

}
</style>
