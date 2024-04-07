<template>
  
    <h1> Castles </h1>
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