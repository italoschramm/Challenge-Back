<template>
<div class="row justify-content-md-center h-100">
 <div class="card-wrapper">
    <b-form @submit="onSubmit" v-if="show">
      <b-form-group
        id="input-dateStart"
        label="Data Inicial:"
        label-for="dateStart"
        description="Data de inicio da votação."
        >

          <b-form-datepicker calendar-width="400px" id="dateStart" v-model="voting.dateStart.value" class="mb-2" locale="pt"></b-form-datepicker>
      
          <b-form-invalid-feedback id="input-dateStart-feedback">
            Campo requirido. Necessário uma data válida.
          </b-form-invalid-feedback>
      
      </b-form-group>

      <b-form-group 
        id="input-dateEnd" 
        label="Data final:" 
        label-for="dateFEnd"
        description="Data final da votação."
        >

        <b-form-datepicker calendar-width="400px" id="dataEnd" v-model="voting.dateEnd" class="mb-2" locale="pt"></b-form-datepicker>
      
        <b-form-invalid-feedback id="input-dateEnd-feedback">
            Campo requirido. Necessário uma data válida.
        </b-form-invalid-feedback>

      </b-form-group>

      <b-form-group id="input-partipants" label="Participantes:" label-for="participants">
        <div>
          <multiselect v-model="selectedValue" tag-placeholder="Add this as new tag" placeholder="Pesquise ou digite o nome" label="name" track-by="id" :options="participants" :multiple="true" :taggable="true" @tag="addTag"></multiselect>
        </div>

        <b-form-invalid-feedback id="input-dateEnd-feedback">
            Campo requirido. Necessário selecionar no mínimo 2 participantes.
        </b-form-invalid-feedback>
      </b-form-group>

      <b-button type="submit" variant="primary">Salvar</b-button>
    </b-form>
  </div>
</div>
</template>

<script>
  import Multiselect from 'vue-multiselect';
  import url from '../../api/back-api';
  import router from '../../routes';

  export default {

    components: { Multiselect },

    data() {
      return {
        voting: {
          dateStart: '',
          dateEnd: '',
          active: 'true',
          participants: []
        },
        selectedValue : [],
        show: true,
        dateValue: '',
        participants: []
      }
    },
    methods: {
      onSubmit(event) {
        event.preventDefault()
        this.voting.participants = this.participants
        console.log(JSON.stringify(this.voting))
        url.registerVoting(this.voting).then(response => {
          alert('Salvo com sucesso!')
          router.push('/Home')     
      }).catch ((error)=> console.log(error));
      },

      addTag (newTag) {
        const tag = {
          name: newTag,
          code: newTag.substring(0, 2) + Math.floor((Math.random() * 10000000))
        }
        this.selectedValue.push(tag)
      }
    },
    created: function(){
      url.getListActiveParticipants()
      .then((response) => { this.participants = response.data});
    }
  }
</script>

<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>
<style scoped>

.card-wrapper {
	width: 400px;
}

</style>