<template>
  <div class="container h-100">
    <div class="row justify-content-md-center h-100">
      <div class="card-wrapper">
        
        <div class="brand">
						<b-img center class="logoImage" src="../../../../src/images/image.png" alt="logo"/>
				</div>

        <div class="card fat">
						<div class="card-body">
              <div class="div-title">
                  <h4 class="title">Login</h4>
              </div>
              <div class="form-group">
                <b-form-input v-model="credentials.username" placeholder="Enter your username"></b-form-input>
              </div>
              <div class="form-group">
                <b-form-input type="password" v-model="credentials.password" placeholder="Enter your password"></b-form-input>
              </div>
              <div class="form-group" style="text-align:center;">
                <button class="btn btn-primary" @click="submit()">Access</button>
            </div>
            </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import auth from '../../api/auth';

export default {
    data() {
    return {
      credentials: {
        username: '',
        password: ''
      },
      error: ''
    }
  },

  methods: {

    submit() {

      var credentials = {
        username: this.credentials.username,
        password: this.credentials.password
      }

      auth.login(this, credentials, 'RegisterVoting')

    }
  }
}
</script>

<style scoped>

.panelLogin1{
    margin: 0 auto;
    width: 50%;
    border: 1px solid black;
  }

   .brand{
     margin: 0px 0px 50px 0px;
   }

  .logoImage{
    width: 50px;
    height: 50px;
  }
   
.my-login-page .card-wrapper {
	width: 400px;
}

  .card {
	border-color: transparent;
	box-shadow: 0 4px 8px rgba(0,0,0,.05);
}

  .card.fat {
	padding: 10px;
}

  .title {
   position:absolute;
   margin: auto;
   top: 0; left: 0; bottom: 0; right: 0;
}

.div-title{
  	 margin-bottom: 50px;
     position:relative;
     align-items :center;
     text-align:center;
}


</style>