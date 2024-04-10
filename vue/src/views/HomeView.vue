<template>
  <div class="home">

    <div class="overlay">
    <h1>Unlock the Majesty: Explore Japan's Castles</h1>
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
    background-position: 50% 50%;
    background-image: url('https://i.pinimg.com/originals/bb/b6/75/bbb6757f33883aa8703215437c054e96.jpg');

  }
  .overlay {
    position: absolute;
    height: 100vh;
    width: 100%;
    top: 0;
    left: 0;
    background: rgba(0, 0, 0, 0.401);
    color: white;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
  }
  </style>