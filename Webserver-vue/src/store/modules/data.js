import * as getterTypes from '../utils/getterTypes'
import * as actionTypes from '../utils/actionTypes'
import * as mutationTypes from '../utils/mutationTypes'

const state = {
    data: {
        sensorData: {
            humidity: "",
            sundensity: "",
            temperature: "",
            pressure: ""
        },
        packetInf: {
            chartDataRttUDP: {
                labels: [],
                datasets: [
                    {
                        label: 'RTT UDP (milli)',
                        backgroundColor: '#FF630F',
                        borderColor: '#EB7C48',
                        data: []
                    }
                ]
            },
            chartDataRttTCP: {
                labels: [],
                datasets: [
                    {
                        label: 'RTT TCP (milli)',
                        backgroundColor: '#1FF6FA',
                        borderColor: '#2EE0E6',
                        data: []
                    }
                ]
            },
            chartDataRttRPC: {
                labels: [],
                datasets: [
                    {
                        label: 'RTT RPC (milli)',
                        backgroundColor: '#00FA5E',
                        borderColor: '#12E667',
                        data: []
                    }
                ]
            },
            currentData: {
                activeSensors:"",
                frequencyTcp:"",
                frequencyUdp:"",
                packageLossUdp:"",
                packageLossTcp: "",
                rttTCP:"",
                rttUdp:"",
                rttUdpAverage:"",
                rttRPC:"",
                mqttMessages:"",
                sentPackagesUdp:"",
                sentPackagesTcp:""

            }
        }
    }
}

const getters = {
    [getterTypes.getSensorData]: state => state.data.sensorData,
    [getterTypes.getPacketInfCurrentData]: state => state.data.packetInf.currentData,
    [getterTypes.getChartDataRttUDP]: state => state.data.packetInf.chartDataRttUDP,
    [getterTypes.getChartDataRttTCP]: state => state.data.packetInf.chartDataRttTCP,
    [getterTypes.getChartDataRttMQTT]: state => state.data.packetInf.chartDataRttMQTT,
    [getterTypes.getChartDataRttRPC]: state => state.data.packetInf.chartDataRttRPC
}

const actions = {
    [actionTypes.setSensorData]: ({ commit }) => {
        let SensorDataRequest = new XMLHttpRequest();
        SensorDataRequest.open("GET", "http://localhost:8051/sensorData-db"); // URL für HTTP-GET
                SensorDataRequest.onreadystatechange = function() {
                    if(SensorDataRequest.readyState === 4) { // Uebertragung = DONE
                        if (SensorDataRequest.status === 200) {   // HTTP-Status = OK
                            if(SensorDataRequest.response != null) {
                                let resp = JSON.parse(SensorDataRequest.response)
                                commit(mutationTypes.setSensorData, resp)
                            }
                            else console.error ("Dokument ist leer");
                        }
                        else console.error ("Uebertragung fehlgeschlagen");
                    }
                }; //Callback-Handler zuordnen
        SensorDataRequest.send(null);
    },
    [actionTypes.setPacketInf]: ({ commit }) => {
        let RTTDataRequest = new XMLHttpRequest();
        RTTDataRequest.open("GET", "http://localhost:8051/rtt"); // URL für HTTP-GET
        RTTDataRequest.onreadystatechange = function() {
                    if(RTTDataRequest.readyState === 4) { // Uebertragung = DONE
                     if (RTTDataRequest.status === 200) {   // HTTP-Status = OK
                            if(RTTDataRequest.response !== null) {
                                let resp = JSON.parse(RTTDataRequest.response)
                                commit(mutationTypes.setPacketInf, resp)
                            }
                            else console.error ("Dokument ist leer");
                        }
                        else console.error ("Uebertragung fehlgeschlagen");
                }
                }; //Callback-Handler zuordnen
        RTTDataRequest.send(null); // Request abschicken
    }
}

const mutations = {
    [mutationTypes.setSensorData]: (state, sensorData) => {
        state.data.sensorData = sensorData
    },
    [mutationTypes.setPacketInf]: (state, data) => {
        //console.log(data)
        let keyLast = (Object.keys(data)[0]).toString()
        if(!state.data.packetInf.chartDataRttUDP.labels.includes(keyLast)) {
            state.data.packetInf.currentData = data[keyLast]

            // Chart RttUDP
            state.data.packetInf.chartDataRttUDP.labels.push(keyLast)
            state.data.packetInf.chartDataRttUDP.datasets[0].data.push(data[keyLast]["rttUdp"])

            // Chart RttTCP
            state.data.packetInf.chartDataRttTCP.labels.push(keyLast)
            state.data.packetInf.chartDataRttTCP.datasets[0].data.push(data[keyLast]["rttTCP"])

            // Chart RttRPC
            state.data.packetInf.chartDataRttRPC.labels.push(keyLast)
            state.data.packetInf.chartDataRttRPC.datasets[0].data.push(data[keyLast]["rttRPC"])
        }
    }
}

export default {
    state,
    getters,
    actions,
    mutations
}