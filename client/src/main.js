import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VueCookie from 'vue-cookie'

import './plugins/element.js'

Vue.config.productionTip = false
Vue.use(VueCookie) 

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')