<template>
    <div id="castleSearch" class="search-container">
        <input type="text" placeholder="Search by castle name" v-model.trim="search.name" @keyup="submitSearch"
            class="search-input">
    </div>

    <div class="container">
        <div class="button-container">
            <input type="button" class="hokkaido" value="Hokkaido" v-bind="filter.region" @click="hokkaido">
            <input type="button" class="Tohoku" value="Tohoku" v-bind="filter.region" @click="tohoku">
            <input type="button" class="Kanto" value="Kanto" v-bind="filter.region" @click="kanto">
            <input type="button" class="Chubu" value="Chubu" v-bind="filter.region" @click="chubu">
            <input type="button" class="Kansai" value="Kansai" v-bind="filter.region" @click="kansai">
            <input type="button" class="Chugoku" value="Chugoku" v-bind="filter.region" @click="chugoku">
            <input type="button" class="Shikoku" value="Shikoku" v-bind="filter.region" @click="shikoku">
            <input type="button" class="Kyushu" value="Kyushu" v-bind="filter.region" @click="kyushu">
            <input type="button" class="Okinawa" value="Okinawa" v-bind="filter.region" @click="okinawa">
            <input type="button" class="ResetFilter" value="Reset Filters"  @click="submitSearch">
        </div>
    </div>

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
    margin-top: 4rem;
    padding-bottom: 1rem;
}
.container {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-bottom: 3rem;
}

.button-container {
        display: flex;
        justify-content: space-between;
        width: 40%; 
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

.hokkaido {
    background-color:lightgreen;
    color: black;
    border:none;
    border-radius:10px;
    
}
.hokkaido:hover {
    background-color:mediumseagreen;
    box-shadow: 0px 0px 2px 2px lightgreen;
    color: white;
}

.Tohoku {
    background-color:pink;
    color: black;
    border:none;
    border-radius:10px;
    
}
.Tohoku:hover {
    background-color:lightcoral;
    box-shadow: 0px 0px 2px 2px pink;
    color: white;
}

.Kanto {
    background-color:lightsalmon;
    color: black;
    border:none;
    border-radius:10px;
    
}
.Kanto:hover {
    background-color:rgb(184, 78, 145);
    box-shadow: 0px 0px 2px 2px lightsalmon;
    color: white;
}

.Chubu {
    background-color:lightblue;
    color: black;
    border:none;
    border-radius:10px;
    
}
.Chubu:hover {
    background-color:darkcyan;
    box-shadow: 0px 0px 2px 2px lightblue;
    color: white;
}

.Kansai {
    background-color:plum;
    color: black;
    border:none;
    border-radius:10px;
    
}
.Kansai:hover {
    background-color:rgb(168, 82, 168);
    box-shadow: 0px 0px 2px 2px plum;
    color: white;
}

.Chugoku {
    background-color:salmon;
    color: black;
    border:none;
    border-radius:10px;
    
}
.Chugoku:hover {
    background-color:rgb(219, 121, 121);
    box-shadow: 0px 0px 2px 2px salmon;
    color: white;
}

.Shikoku {
    background-color:mediumaquamarine;
    color: black;
    border:none;
    border-radius:10px;
    
}
.Shikoku:hover {
    background-color:mediumseagreen;
    box-shadow: 0px 0px 2px 2px mediumaquamarine;
    color: white;
}

.Kyushu {
    background-color:lightsteelblue;
    color: black;
    border:none;
    border-radius:10px;
    
}
.Kyushu:hover {
    background-color:steelblue;
    box-shadow: 0px 0px 2px 2px lightsteelblue;
    color: white;
}

.Okinawa {
    background-color:tan;
    color: black;
    border:none;
    border-radius:10px;
    
}
.Okinawa:hover {
    background-color:rgb(196, 117, 15);
    box-shadow: 0px 0px 2px 2px tan;
    color: white;
}

.ResetFilter {
    background-color:lightgray;
    color: black;
    border:none;
    border-radius:10px;
    
}
.ResetFilter:hover {
    background-color:lightgray;
    box-shadow: 0px 0px 2px 2px lightgray;
    color: black;
}
</style>