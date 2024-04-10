<template>
    <div id="castleSearch" class="search-container">
        <input type="text" placeholder="Search by castle name" v-model.trim="search.name" @keyup="submitSearch" class="search-input">
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
<style scoped>
.search-container {
    display: flex;
    justify-content: center;
    align-items: center;
}
.search-input {
width: 50vw;
height: 3vh;
box-shadow: 0 2px 4px rgba(0,0,0,0.1);
font-size: 1em;
padding: 6px;
border: 1px solid #193144;
border-radius: 14px;
}
</style>