<template>
    <CastleSearch />
    <CastleList />
    <!-- <div>
        <b-badge href="#" variant="dark">Dark</b-badge>
    </div> --> <!--cant figure out bootstrap-->
</template>

<script>
import CastleList from '../components/CastleList.vue';
import CastleSearch from '../components/CastleSearch.vue';

export default {
    components: {
        CastleList,
        CastleSearch
    }
}
</script>

<style scoped>
h1 {
    display: flex;
    justify-content:  center;
}
</style>
