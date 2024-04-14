<template>
    <div id="header">
        <router-link to="/"><img src="../assets/logo.png" alt="logo"  width="125" height="125" class="pic"></router-link>
        <h1>Castles Of Japan | 日本の城 </h1>
        
        <nav id= "nav" class="d-flex">
            <router-link v-bind:to="{ name: 'home' }" class="nav-link">Home</router-link>
            <span class="bars"> &nbsp;|&nbsp;</span>
            <router-link v-bind:to="{ name: 'castles' }" class="nav-link">Explore Castles</router-link> <!--@click="location.reload()"-->
            <span class="bars"> &nbsp;|&nbsp;</span>
            <router-link v-bind:to="{ name: 'dashboard' }" class="nav-link">My Dashboard</router-link>
            <span class="bars"> &nbsp;|&nbsp;</span>
            <router-link v-bind:to="{ name: 'map' }" class="nav-link">Map</router-link>
            <span class="bars"> &nbsp;|&nbsp;</span>
            <router-link v-bind:to="{ name: 'login' }" v-if="!user || !admin" class="nav-link">Sign In &nbsp; </router-link> <!--" v-if="$store.state.token = ''"-->
            <router-link v-bind:to="{ name: 'logout' }" v-if="user || admin" class="nav-link">Sign Out &nbsp; </router-link> <!--" v-if="$store.state.token != ''"-->
        </nav>
    </div>
</template>



<script>
import { mapActions } from 'vuex';

export default {
    methods: {}
}

  
</script>



<style scoped>
    #pic {
        overflow: hidden;
    }
    #header {
        width: 100vw;
        display: flex;
        align-items: center;
        color: #193144;
        border-bottom: 2px solid #8BBAB1;
    }
    #nav {
        margin-left: auto;
    }
    .nav-link {
        text-decoration: none;
        color: inherit;
        margin: .8vw;
        font-size: 1.4em;
    }
    .nav-link:hover {
        font-size: 1.5em;
        font-weight: 300;
        /* color: #8BBAB1; */
        font-style: italic;
    }
    .bars {
        display: flex;
        align-items: center;
        font-size: 1.5em;
        color: inherit;
    }
</style>