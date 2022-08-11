const { createVuePlugin } = require('vite-plugin-vue2');
const { chartJS } = require('chart.js')

module.exports = {
  plugins: [createVuePlugin(),chartJS],
};