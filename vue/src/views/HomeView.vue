<template>
  <div class="home">

    <div class="overlay">
      <h1>Unlock the Majesty: Explore Japan's Castles</h1>
      <router-link v-bind:to="{ name: 'castles' }">
        <button class="explore"> EXPLORE </button>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
};
</script>

<style scoped>
h1 {
  font-size: 4em;
  font-style: italic;
  color: #FFFDF1;
}

.home {
  height: 100vh;
  width: 100vw;
  position: relative;
  background-size: cover;
  background-position: 50%;
  background-image: url('https://i.pinimg.com/originals/bb/b6/75/bbb6757f33883aa8703215437c054e96.jpg');
}

.explore {
  font-size: 1.6em;
  background-color: #fffdf1b9;
  border-radius: 10px;
  width: 10vw;
  height: 3vw;
  color: #193144;

}

.explore:hover {
  font-weight: 500;
  font-style: italic;
  color: #000;
  background-color: #fffdf1de;
  transform: scale(1.05);
}

.overlay {
  position: absolute;
  height: 100vh;
  width: 100vw;
  background: rgba(0, 0, 0, 0.429);
  color: white;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}</style>