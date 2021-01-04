<template>
<div class="row justify-content-md-center h-100">
  <div class="card-wrapper">
    <div>
      <b-form-select 
        v-model="selected" 
        :options="participants" 
        :select-size="4"
        value-field="id"
        text-field="name"
        ></b-form-select>
      <div class="mt-3">Selected: <strong>{{ selected.name }}</strong></div>
    </div>
  </div>
</div>
</template>

<script>
  import { HotTable } from '@handsontable/vue';
  import url from '../../api/back-api';

   export default {
    data() {
      return {
        selected: {
          name: '',
          age: 0,
          state: '',
          id: 0,
          active: false
        },
        participants: []
      }
    },

    created: function(){
      url.getListActiveParticipants()
      .then((response) => { this.participants = response.data
      console.log(this.participants)});
      
    }
  }
</script>

<style src="../../../node_modules/handsontable/dist/handsontable.full.css"></style>
<style scoped>

.card-wrapper {
	width: 600px;
}

</style>