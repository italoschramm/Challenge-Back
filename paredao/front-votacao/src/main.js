import Vue from 'vue';
import App from './App.vue';
import VueResource from 'vue-resource';
import VueRouter from 'vue-router';
import router from './routes';
import auth from './api/auth';
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BootstrapVue, IconsPlugin  } from 'bootstrap-vue';

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(VueResource);
Vue.use(VueRouter);

auth.checkAuth()

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
