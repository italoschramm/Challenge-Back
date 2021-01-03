<template>
    <div class="menu">
    <b-nav tabs align="center">    
            <b-nav-item v-if="!user.authenticated"><router-link to="/Home">Home</router-link></b-nav-item>
            <b-nav-item v-if="!user.authenticated"><router-link to="/Login">Login</router-link></b-nav-item>
            <b-nav-item v-if="user.authenticated && user.authorizations.includes('ROLE_PRODUCTION')"><router-link to="/RegisterVoting">Register Voting</router-link></b-nav-item>
            <b-nav-item v-if="user.authenticated" @click="logout()"><router-link to="/Login">Logout</router-link></b-nav-item>
    </b-nav>
    </div>
</template>

<script>
import auth from '../../../api/auth';

export default {
   data(){
       return{
            user: auth.user
       }
   },

   methods: {
      logout() {
          auth.logout()
      }
   }
}
</script>

<style scoped>

    .menu{
         margin-top: 50px;
         margin-bottom: 50px;
         margin-right: 50px;
         margin-left: 50px;
    }

</style>