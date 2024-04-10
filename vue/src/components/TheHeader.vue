<template>
    <div id="header">
        <router-link to="/"><img src="../assets/logo.png" alt="logo"  width="150" height="150"></router-link>
        <h1>Castles Of Japan / 日本の城 </h1>
        
        <nav id= "nav">
            <router-link v-bind:to="{ name: 'home' }" class="nav-link">Home</router-link>
            <router-link v-bind:to="{ name: 'castles' }" class="nav-link">Castle List</router-link>
            <router-link v-bind:to="{ name: 'dashboard' }" class="nav-link">Dashboard</router-link>
            <router-link v-bind:to="{ name: 'map' }" class="nav-link">Map</router-link>
           
        </nav>
    </div>
</template>

<script>


  
</script>

<style scoped> 
    #header {
        display: flex;
        align-items: center;
        color: #193144;
    }
    #nav {
        margin-left: auto;
        
    }
 
    .nav-link {
        text-decoration: none;
        color: inherit;
        margin-right: 20px;
    
    }
    #nav-link:hover {
    font-size: 1.02em;
    }

</style>