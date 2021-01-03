<template>
<div>
  <meu-menu :rotas="router" :allowed="true"/>
  <div>
    <router-view></router-view>
  </div>
</div>
</template>

<script>
import router from './routes';
import Menu from './components/shared/menu/Menu.vue';

export default {

  components: {
    'meu-menu' : Menu
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
