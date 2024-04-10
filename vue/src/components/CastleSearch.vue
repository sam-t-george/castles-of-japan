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
    margin: 4rem;
}
.search-input {
width: 50vw;
height: 3vh;
box-shadow: 4px 4px 15px rgba(0,0,0,0.4);
font-size: 1em;
padding: 8px;
border: 1.5px solid #193144;
border-radius: 14px;
}
</style>