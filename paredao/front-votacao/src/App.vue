<template>
<div>
  <header-page></header-page>
  <meu-menu :rotas="router" :allowed="true"/>
  <div>
    <router-view></router-view>
  </div>
</div>
</template>

<script>
import router from './routes';
import Menu from './components/shared/menu/Menu.vue';
import HeaderPage from './components/shared/header/HeaderPage.vue';

export default {

  components: {
    'meu-menu' : Menu,
    'header-page' : HeaderPage
  },

  data() {
    return {
      router
    }
  }
}
</script>

<style>

</style>
