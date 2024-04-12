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
  justify-content: space-between; /* Adjusts the spacing between the columns */
}

.calendar-container {
  flex: 1; /* Allows the container to grow and take up half the space */
  height: fit-content;
}

.event-cards {
  flex: 1; /* Similarly, allows this container to grow and take up the remaining space */
  display: flex;
  flex-direction: column; /* Aligns the event cards in a column */
  justify-content: start;
  align-items: center;
  padding: 20px; /* Optional padding for styling */
  height: 100vh;
}
.calendar-container {
    display: flex;
    justify-content: center;
    margin-top: 20px;
    margin-bottom: 20px;
}
</style>
