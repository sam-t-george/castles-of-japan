<template>
    <div class="main-container">
        <div class="calendar-container">
            <CalenderContainer />
        </div>
        <div class="event-cards">
            event cards 
        </div>
    </div>
</template>

<script>
import CalenderContainer from '../components/CalenderContainer.vue';



export default {
    components: {
        CalenderContainer
    }
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
