<template>
    <CastleSearch />
    <CastleList />

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
