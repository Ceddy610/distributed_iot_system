import Vue from 'vue';
import App from './App.vue';
import store from './store'

//Vue.component('chart', require('./components/Chart.vue').default)
//Vue.component('current-data', require('./components/CurrentData.vue').default)
//Vue.component('packet-info', require('./components/PacketInfo').default)

new Vue({
    el: '#app',
    store: store,
    render(h) {
        return h(App,store)
    }
})