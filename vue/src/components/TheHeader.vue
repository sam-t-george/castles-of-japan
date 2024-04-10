<template>
    <div id="header">
        <h1>Castles Of Japan / 日本の城 </h1>
        <router-link to="/"><img src="../assets/logo.png" alt="logo"  width="200" height="200"></router-link>

        <nav>
            <router-link v-bind:to="{ name: 'home' }">Home</router-link>
            <router-link v-bind:to="{ name: 'castles' }">Castle List</router-link>
            <router-link v-bind:to="{ name: 'dashboard' }">Dashboard</router-link>
            <router-link v-bind:to="{ name: 'map' }">Map</router-link>
           
        </nav>
    </div>
</template>

<script>


  
</script>