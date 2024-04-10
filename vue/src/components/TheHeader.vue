<template>
    <div id="header">
        <router-link to="/"><img src="../assets/logo.png" alt="logo"  width="150" height="150"></router-link>
        <h1>Castles Of Japan / 日本の城 </h1>
        
        <nav id= "nav">
            <router-link v-bind:to="{ name: 'home' }" class="nav-link">Home &nbsp; |</router-link>
            <router-link v-bind:to="{ name: 'castles' }" class="nav-link">Castle List &nbsp; |</router-link>
            <router-link v-bind:to="{ name: 'dashboard' }" class="nav-link">Dashboard &nbsp; |</router-link>
            <router-link v-bind:to="{ name: 'map' }" class="nav-link">Map</router-link>
        </nav>
    </div>
</template>

<script>


  
</script>

<style scoped> 
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
        margin-right: 20px;
        font-size: 1.5em;
    }
    .nav-link:hover {
        font-size: 1.75em;
    }

</style>