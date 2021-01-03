import router from '../routes';
import url from './back-api';

export default {

  user: {
    authenticated: false,
    authorizations : []
  },

  login(context, creds, redirect) {

    url.login(creds).then(response => {
      localStorage.setItem('id_token', response.data.token);
      localStorage.setItem('authorizations', response.data.authorizations);
      this.user.authenticated = true  
      this.user.authorizations = response.data.authorizations;
      if(redirect) {
        router.push('/Home')     
      }
    }).catch ((error)=> console.log(error));
  },

  logout() {
    localStorage.removeItem('id_token')
    localStorage.removeItem('authorizations')
    this.user.authenticated = false
    router.push('/Login')
  },

  checkAuth() {
    var jwt = localStorage.getItem('id_token')
    if(jwt) {
      this.user.authenticated = true
      this.user.authorizations = localStorage.getItem('authorizations')
    }
    else {
      this.user.authenticated = false      
    }
  },


  getAuthHeader() {
    return {
      'Authorization': 'Bearer ' + localStorage.getItem('id_token')
    }
  }
}
