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
       

<script>
import CalenderContainer from '../components/CalenderContainer.vue';



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

</style>
