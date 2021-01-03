import axios from 'axios'

const AXIOS = axios.create({
  baseURL: 'http://localhost:8090/api-votacao',
  timeout: 5000
});

var headersPost = {
    headers : {
        'Content-Type': 'application/json',
        'Authorization': localStorage.getItem('id_token')
    }
}

var headersGet = {
    headers : {
        'Authorization': localStorage.getItem('id_token')
    }
}

export default {
    login(login){
        return AXIOS.post('/login', login);
    },
    hello() {
        return AXIOS.get(`/hello`);
    },
    getUser(userId) {
        return AXIOS.get(`/user/` + userId);
    },
    createUser(firstName, lastName) {
        return AXIOS.post(`/user/` + firstName + '/' + lastName);
    },
    getListActiveParticipants(){
        return AXIOS.get('/participant/listActiveParticipants', headersGet);
    },
    registerVoting(voting){
        return AXIOS.post('/voting/register', voting, headersPost);
    },
    getSecured(user, password) {
        return AXIOS.get(`/secured/`,{
            auth: {
                username: user,
                password: password
            }});
    }
}