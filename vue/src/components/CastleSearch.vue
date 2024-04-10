<template>
    <div id="castleSearch">
        <input type="text" placeholder="Search Castle" v-model.trim="search.name" @keyup="castleSearch">
    </div>

    <label for="region">Kansai</label>
    <input type="checkbox" id="region" v-model.trim="search.region" @click="castleSearch">

    <label for="region">Chubu</label>
    <input type="checkbox" id="region" v-model.trim="search.region" @click="castleSearch">
     
    <label for="region">Shikoku</label>
    <input type="checkbox" id="region" v-model.trim="search.region" @click="castleSearch">

    <label for="region">Chugoku</label>
    <input type="checkbox" id="region" v-model.trim="search.region" @click="castleSearch">

    <label for="region">Kyushu</label>
    <input type="checkbox" id="region" v-model.trim="search.region" @click="castleSearch">

 
</template>


<script>

export default {
   
    data() {
        return {
            search: {
                name: ''
            } 
        }
    },
    methods: {
        castleSearch() {
            this.$store.dispatch('searchForCastle', this.search);
        }
    }

}
</script>