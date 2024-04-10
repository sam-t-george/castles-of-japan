<template>
    <div id="castleSearch">

        <input type="text" placeholder="Search" v-model.trim="search.name">
        <!-- <input type="text" id="name" v-model.trim="search.name">
        <label for="region">Region </label>
        <input type="text" id="region" v-model.trim="search.region">
        <label for="address">Address </label>
        <input type="text" id="address" v-model.trim="search.address"> -->
        <!-- <input type="button" value="Search" @click="submitSearch()"> -->
    </div>
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
        submitSearch() {
            this.$store.dispatch('searchForCastle', this.search);
        }
    }

}
</script>