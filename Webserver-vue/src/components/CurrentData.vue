<template>
  <div class="section">
    <div class="card-head article">
      <h2>Sensor Status</h2>
    </div>
    <div class="mini-card-row section">
      <div class="mini-card article">
        <h3>Temperature</h3>
        <p>{{ this.sensorData.temperature }}</p>
      </div>
      <div class="mini-card article">
        <h3>Light density</h3>
        <p>{{ this.sensorData.sundensity }}</p>
      </div>
      <div class="mini-card article">
        <h3>Humidity</h3>
        <p>{{ this.sensorData.humidity }}</p>
      </div>
      <div class="mini-card article">
        <h3>Pressure</h3>
        <p>{{ this.sensorData.pressure }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
import {getSensorData} from "../store/utils/getterTypes";
export default {
  name: "CurrentData",
  computed: {
    ...mapGetters({
      sensorData: getSensorData
    })
  }
}
</script>

<style scoped>

</style>