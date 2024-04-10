<template>
    <div id="castleSearch" class="search-container">
        <input type="text" placeholder="Search by castle name" v-model.trim="search.name" @keyup="submitSearch"
            class="search-input">
    </div>
    <input type="button" value="Hokkaido" v-bind="filter.region" @click="hokkaido">
    <input type="button" value="Tohoku" v-bind="filter.region" @click="tohoku">
    <input type="button" value="Kanto" v-bind="filter.region" @click="kanto">
    <input type="button" value="Chubu" v-bind="filter.region" @click="chubu">
    <input type="button" value="Kansai" v-bind="filter.region" @click="kansai">
    <input type="button" value="Chugoku" v-bind="filter.region" @click="chugoku">
    <input type="button" value="Shikoku" v-bind="filter.region" @click="shikoku">
    <input type="button" value="Kyushu" v-bind="filter.region" @click="kyushu">
    <input type="button" value="Okinawa" v-bind="filter.region" @click="okinawa">





    <!-- <button class="region">Tohoku</button>
        <button class="region"></button>
        <button class="region"></button>
        <button class="region"></button>
        <button class="region">Chugoku</button>
        <button class="region"></button>
        <button class="region"></button>
        <button class="region"></button>     -->
</template>
<script>
export default {
    data() {
        return {
            search: {
                name: ''
            },
            filter: {
                region: ''
            }
        }
    },

    methods: {
        submitSearch() {
            this.$store.dispatch('searchForCastle', this.search);
        },
        hokkaido() {
            this.filter.region = 'hokkaido';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        tohoku() {
            this.filter.region = 'tohoku';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        kanto() {
            this.filter.region = 'kanto';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        chubu() {
            this.filter.region = 'chubu';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        kansai() {
            this.filter.region = 'kansai';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        chugoku() {
            this.filter.region = 'chugoku';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        shikoku() {
            this.filter.region = 'shikoku';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        kyushu() {
            this.filter.region = 'kyushu';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        okinawa() {
            this.filter.region = 'okinawa';
            this.$store.dispatch('filterByRegion', this.filter);
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