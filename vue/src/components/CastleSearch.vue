<template>
    <div id="castleSearch">
        <input type="text" placeholder="Search" v-model.trim="search.name" @keyup="submitSearch">
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