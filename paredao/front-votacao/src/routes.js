import Vue from "vue";
import VueRouter from 'vue-router';
import Login from './components/routes/Login.vue';
import Home from './components/routes/home.vue';
import RegisterVoting from './components/routes/RegisterVoting.vue';
import auth  from './api/auth';

Vue.use(VueRouter)

const routes = [
    { 
        path: '/Login', 
        component: Login, 
        titulo: 'Login',
        meta: { guest: true },
    },
    { 
        path: '/Home', 
        component: Home, 
        titulo: 'Home'
    },
    { 
        path: '/', 
        component: Home, 
        titulo: 'Home'
    },
    { 
        path: '/RegisterVoting', 
        component: RegisterVoting, 
        titulo: 'Register Voting',
        meta: {requiresAuth: true},
    },
    { 
        path: '*', 
        redirect: '/'
    }
];

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
  });

  router.beforeEach((to, from, next) => {
    if(to.matched.some(record => record.meta.requiresAuth)) {
      if (auth.user.authenticated) {
        next()
        return
      }
      next('/login') 
    } else {
      next() 
    }
  })

  export default router;