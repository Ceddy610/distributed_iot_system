<template>
  <div id="app">
    <vue-html2pdf
        :show-layout="false"
        :float-layout="true"
        :enable-download="true"
        :preview-modal="false"
        :paginate-elements-by-height="1000"
        :filename=time()
        :pdf-quality="2"
        :manual-pagination="false"
        pdf-format="a4"
        :pdf-margin="10"
        pdf-orientation="portrait"
        pdf-content-width="800px"
        @progress="onProgress($event)"
        ref="html2Pdf"
    >
      <section slot="pdf-content">
        <PacketInfo />
        <CurrentData />
        <ChartRttUDP />
        <ChartRttTCP />
        <ChartRttRPC />
      </section>
    </vue-html2pdf>
    <div>
      <nav>
        <h1>HTTP Server</h1>
        <div class="nav">
          <div v-on:click="generatePDF()" class="beautify-button btn-nav">Generate PDF</div>
        </div>
      </nav>
      <main>
        <PacketInfo />
        <CurrentData />
        <ChartRttUDP />
        <ChartRttTCP />
        <ChartRttRPC />
      </main>
    </div>
  </div>
</template>

<script>
import PacketInfo from "./components/PacketInfo.vue"
import CurrentData from "./components/CurrentData.vue";
import ChartRttUDP from "./components/ChartRttUDP.vue";
import ChartRttTCP from "./components/ChartRttTCP.vue";
import ChartRttRPC from "./components/ChartRttRPC.vue";
import VueHtml2pdf from 'vue-html2pdf';
import {setPacketInf, setSensorData} from "./store/utils/actionTypes";

export default {
  name: 'app',
  components: {ChartRttRPC, ChartRttTCP, ChartRttUDP, CurrentData, PacketInfo, VueHtml2pdf},
  mounted() {
    this.requestData()
    window.setInterval(this.requestData, 1000)
  },
  methods: {
    requestData: function() {
      this.$store.dispatch(setSensorData)
      this.$store.dispatch(setPacketInf)
    },
    hasGenerated() {
       alert("PDF generated successfully!");
    },
    generatePDF() {
      this.$refs.html2Pdf.generatePdf();
    },
    time() {
      let current = new Date();
      return (current.getHours() + "H-" + current.getMinutes() + "M-" + current.getSeconds()).toString() + "S_Di2y-A"
    }
  }
};
</script>

<style>
@import "/src/assets/main.css";
@import "/src/assets/card.css";
@import "/src/assets/button.css";
</style>