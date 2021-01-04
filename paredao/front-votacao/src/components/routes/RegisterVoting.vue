<template>
<div class="row justify-content-md-center h-100">
 <div class="card-wrapper">
    <b-form @submit.stop.prevent="onSubmit" v-if="show">
      <b-form-group
        id="input-dateStart"
        label="Data Inicial:"
        label-for="dateStart"
        description="Data de inicio da votação."
        >
          <b-form-datepicker :state="validateState('dateStart')" calendar-width="460px" id="dateStart" v-model="$v.voting.dateStart.$model" class="mb-2" locale="pt"></b-form-datepicker>
          <b-form-invalid-feedback id="dataStart-error">Este campo é obrigatório</b-form-invalid-feedback>
      </b-form-group>

      <b-form-group 
        id="input-dateEnd" 
        label="Data final:" 
        label-for="dateEnd"
        description="Data final da votação."
        >

        <b-form-datepicker :state="validateState('dateEnd')" calendar-width="460px" id="dataEnd" v-model="$v.voting.dateEnd.$model" class="mb-2" locale="pt"></b-form-datepicker>
        <b-form-invalid-feedback id="dataEnd-error">Este campo é obrigatório</b-form-invalid-feedback>
      </b-form-group>

      <b-form-group 
        id="input-partipants" 
        label="Participantes:" 
        label-for="participants"
        description="Selecione os participantes da votação."
        aria-describedby="participants-feedback"
        >
            <multiselect id="participants" v-model="$v.voting.participants.$model" tag-placeholder="Add this as new tag" placeholder="Pesquise ou digite o nome" label="name" track-by="id" :options="participants" :multiple="true" :taggable="true" @tag="addTag" class="mb-2"></multiselect>
            <b-form-invalid-feedback  :state="validateState('participants')" id="participants-feedback">Este campo é obrigatório, necessário o mínimo de 2 participantes;</b-form-invalid-feedback>
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
  import { required, minLength } from 'vuelidate/lib/validators';

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
        participants: [],
        uiState: "submit not clicked",
        errors: false,
        empty: true,
      }
    },

    validations: {
      voting: {
         dateStart: {
            required,
            type: Date
        },
        dateEnd: {
            required,
            type: Date
        },
        participants: {
          required,
          type: Array,
          minLength: minLength(2)
        }
      } 
    },

    methods: {

      validateState(name) {
        console.log(name + ': ' + this.$v.voting.participants.$anyError)
        const { $dirty, $error } = this.$v.voting[name];
        return $dirty ? !$error : null;
      },


      onSubmit(event) {

        this.$v.voting.$touch();
      if (!this.$v.voting.$anyError){
          event.preventDefault()
          this.voting.participants = this.participants
          console.log(JSON.stringify(this.voting))
          url.registerVoting(this.voting).then(response => {
          alert('Salvo com sucesso!')
          router.push('/Home')     
          }).catch ((error)=> console.log(error));
          this.uiState = "form submitted";
        }
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
    },
  }
</script>

<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>
<style scoped>

.card-wrapper {
	width: 400px;
}

.error {
  color: red; 
  font-size: 12px;
  position: absolute;
  text-transform: uppercase;
}

</style>