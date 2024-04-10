<template>
    <div class="page">
    <h1> Castles </h1>
    <CastleSearch />
    <CastleList />
</div>
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
