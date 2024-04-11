<template>
  <div id="capstone-app">
    <the-header/>
    <!-- <div id="nav"> -->
        <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
    <!-- </div> -->
    <router-view />
    <the-footer/>
  </div>
</template>


<script>

import TheHeader from './components/TheHeader.vue';
import TheFooter from './components/TheFooter.vue';



export default {

  components: {
  TheHeader,
  TheFooter,
  }
};

</script> 

<style>
#capstone-app{
  background-color: #FFFDF1;
}
body {
  margin: 0 !important; 
  overflow-x: hidden;
}
</style>