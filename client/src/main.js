import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import VueCookie from 'vue-cookie'
import VueAxios from 'vue-axios'

import './plugins/element.js'

Vue.config.productionTip = false
Vue.use(VueCookie) 
Vue.use(VueAxios, axios)

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')