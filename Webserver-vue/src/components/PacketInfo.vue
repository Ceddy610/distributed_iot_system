<template>
  <div class="section">
    <div class="card-head article">
      <h2>Metadata:</h2>
    </div>
    <div class="mini-card-row sub section">
      <div class="mini-card sub article">
        <h3>RTT UDP</h3>
        <i>(milli)</i>
        <p>{{ this.currentData.rttUdp }}</p>
      </div>
      <div class="mini-card sub article">
        <h3>RTT TCP</h3>
        <i>(milli)</i>
        <p>{{ this.currentData.rttTCP }}</p>
      </div>
      <div class="mini-card sub article">
        <h3>RTT RPC</h3>
        <i>(milli)</i>
        <p>{{ this.currentData.rttRPC }}</p>
      </div>
      <div class="mini-card sub article">
        <h3>Mqtt Messages</h3>
        <i>(M pro min)</i>
        <p>{{ this.currentData.mqttMessages }}</p>
      </div>
      <div class="mini-card article">
        <h3>Sent Packet Udp</h3>
        <p>{{ this.currentData.sentPackagesUdp }}</p>
      </div>
      <div class="mini-card article">
        <h3>Packet loss Udp</h3>
        <p>{{ this.currentData.packageLossUdp }}</p>
      </div>
      <div class="mini-card sub article">
        <h3>Frequency UDP</h3>
        <i>(milli)</i>
        <p>{{ this.currentData.frequencyUdp }}</p>
      </div>
      <div class="mini-card sub article">
        <h3>Frequency TCP</h3>
      <i>(milli)</i>
        <p>{{ this.currentData.frequencyTcp }}</p>
      </div>
      <div class="mini-card article">
        <h3>Active Sensors udp</h3>
        <p>{{ this.currentData.activeSensors }}</p>
      </div>
    </div>
    <!--<div class="align-right section">
      <div class="article">
        <div id="save-rtt" class="beautify-button">
          <p>SAVE</p>
        </div>
      </div>
    </div>-->
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
import {getPacketInfCurrentData} from "../store/utils/getterTypes";
export default {
  name: "PacketInfo",
  computed: {
    ...mapGetters({
      currentData: getPacketInfCurrentData
    })
  }
}
</script>

<style scoped>

</style>
