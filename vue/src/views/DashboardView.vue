<template>
    <div class="main-container">
        <div class="calendar-container">
            <CalenderContainer />
        </div>
        <div class="event-cards">
            <h2>Event Cards </h2>
            <div class="card2 card mb-3" style="max-width: 540px;">
  <div class="row g-0 align-items-center">
    <div class="col-sm-4 col-5">
      <img src="https://codingyaar.com/wp-content/uploads/bootstrap-4-card-image-left-demo-image.jpg" class="img-fluid rounded-start" alt="...">
    </div>
    <div class="col-sm-8 col-7">
      <div class="card-body">
        <h5 class="card-title"></h5>
        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
        <p class="card-text d-none d-sm-block"><small class="text-muted">Last updated 3 mins ago</small></p>
      </div>
    </div>
  </div>
</div>

    </div>
  </div>
</template>
       

    <div class="event-cards">

      <body id="body">
        <section id="castleList">
          <Castle v-for="currentCastle in castles" v-bind:key="currentCastle.castleId" v-bind:castle="currentCastle" />
        </section>
      </body>


      <!-- Convert vertical bootstrap card to horizontal -->
      <div class="card1 card align-items-center" style="max-width: 540px;">
        <img src="https://codingyaar.com/wp-content/uploads/bootstrap-4-card-image-left-demo-image.jpg" alt="...">
        <div class="card-body">
          <h5 class="card-title">Card title</h5>
          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
            content.</p>
          <a href="#" class="btn btn-primary">Learn More</a>
        </div>
      </div>

  


    </div>

  </div>
</template>

<script>
import Castle from '../components/Castle.vue';
export default {
    components: {
        CalenderContainer
    },
    props:['castle']
}
</script>

<style scoped>
.main-container {
  display: flex;
  justify-content: space-between;
}

.calendar-container {
  flex: 1;
  height: fit-content;
  padding: 20px;
}

.event-cards {
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: start;
  align-items: center;
  padding: 20px;
  height: 100vh;
}

@media screen and (max-width: 567px) {
  .card-text {
    margin-bottom: 0.5em;
  }
}

.card {
  margin: 5%;
  flex-direction: row;
}

.card-body {
  padding: 0.5em 1em;
}

.card1.card img {
  max-width: 12em;
  height: 100%;
  border-bottom-left-radius: calc(0.25rem - 1px);
  border-top-left-radius: calc(0.25rem - 1px);
}</style>
