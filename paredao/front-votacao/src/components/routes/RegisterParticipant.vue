<template>
<div>
<div class="row justify-content-md-center h-100">
  <div class="card-wrapper">
    <div>
      <b-form-select 
        v-model="selectedId" 
        :options="participants" 
        :select-size="4"
        value-field="id"
        text-field="name"
        v-on:change="disparaAcao"
        :disabled="disableSelect"
        ></b-form-select>
    </div>
    <br>
    <div class="div-buttons"> 
        <b-button @click="newParticipant" :disabled="disableNew" variant="primary">Novo</b-button>
        <b-button @click="editParticipant" :disabled="disableEdit" variant="primary">Editar</b-button>
  </div>

    <div class="card-wrapper">
    <b-form @submit.stop.prevent="onSubmit" v-if="show">
      <b-form-group
        id="input-name"
        label="Nome:"
        label-for="name"
        description="Nome do participante."
        >
          <b-form-input :state="validateState('name')" :disabled="disableInput" id="name" v-model="$v.participant.name.$model" class="mb-2" locale="pt"></b-form-input>
          <b-form-invalid-feedback id="name-error">Este campo é obrigatório</b-form-invalid-feedback>
      </b-form-group>

      <b-form-group
        id="input-age"
        label="Idade:"
        label-for="age"
        description="Idade do participante."
        >
          <b-form-input :state="validateState('age')" id="age" :disabled="disableInput" v-model="$v.participant.age.$model" class="mb-2" locale="pt"></b-form-input>
          <b-form-invalid-feedback id="age-error">Este campo é obrigatório</b-form-invalid-feedback>
      </b-form-group>

      <b-form-group
        id="select-state"
        label="Estado:"
        label-for="state"
        description="Estado do participante."
        >
          <b-form-select :options="optionsStates" :state="validateState('state')" :disabled="disableInput" id="state" v-model="$v.participant.state.$model" class="mb-2" locale="pt"></b-form-select>
          <b-form-invalid-feedback id="state-error">Este campo é obrigatório</b-form-invalid-feedback>
      </b-form-group>

      <b-button type="submit" :disabled="disableSave" variant="primary">Salvar</b-button>
      <b-button @click="cancel" :disabled="disableCancel" variant="danger">Cancelar</b-button>
    </b-form>
  </div>
  </div>
</div>
</div>
</template>

<script>
  import { HotTable } from '@handsontable/vue';
  import url from '../../api/back-api';
  import router from '../../routes';
  import { required, between } from 'vuelidate/lib/validators';

   export default {
    data() {
      return {
        participant: {
          name: '',
          age: 0,
          state: '',
          id: 0,
          active: false
        },
        participants: [],
        show: true,
        errors: false,
        empty: true,
        new: false,
        selectedId: 0,
        disableNew: false,
        disableEdit: true,
        disableInput: true,
        disableSave: true,
        disableSelect: false,
        disableCancel: true,
        optionsStates: [
          { value: null, text: 'Selecione uma opção'},
          { value: 'AC', text: 'Acre'},
          { value: 'AL', text: 'Alagoas'},
          { value: 'AP', text: 'Amapá'},
          { value: 'AM', text: 'Amazonas'},
          { value: 'BA', text: 'Bahia'},
          { value: 'CE', text: 'Ceará'},
          { value: 'DF', text: 'Distrito Federal'},
          { value: 'ES', text: 'Espírito Santo'},
          { value: 'MA', text: 'Maranhão'},
          { value: 'MT', text: 'Mato Grosso'},
          { value: 'MS', text: 'Mato Grosso do Sul'},
          { value: 'MG', text: 'Minas Gerais'},
          { value: 'PA', text: 'Pará'},
          { value: 'PB', text: 'Paraíba'},
          { value: 'PR', text: 'Paraná'},
          { value: 'PE', text: 'Pernambuco'},
          { value: 'PI', text: 'Piauí'},
          { value: 'RJ', text: 'Rio de Janeiro'},
          { value: 'RN', text: 'Rio Grande do Norte'},
          { value: 'RS', text: 'Rio Grande do Sul'},
          { value: 'RO', text: 'Rondônia'},
          { value: 'RR', text: 'Roraima'},
          { value: 'SC', text: 'Santa Catarina'},
          { value: 'SP', text: 'São Paulo'},
          { value: 'SE', text: 'Sergipe'},
          { value: 'TO', text: 'Tocantins'}
        ]
      }
    },

    validations: {
      participant: {
         name: {
            required,
            type: String,
        },
        age: {
            required,
            between: between(1, 199)
        },
        state: {
          required,
          type: String
        }
      } 
    },

    methods: {
      validateState(name) {
        const { $dirty, $error } = this.$v.participant[name];
        return $dirty ? !$error : null;
      },
      disparaAcao(){
        this.participant = this.participants.find(x => x.id === this.selectedId)
        this.disableEdit = false
      },
      editParticipant(){
        this.new = false
        this.enableEdits()
      },
      cancel(){
        this.cleanParticipant()
        this.disableEdits()
      },
      newParticipant(){
        this.new = true
        this.cleanParticipant()
        this.enableEdits()
        this.selectedId = 0
      },
      disableEdits(){
        this.disableInput = true
        this.disableNew = false
        this.disableSave = true
        this.disableSelect = false
        this.disableCancel = true
      },
      enableEdits(){
        this.disableInput = false
        this.disableNew = true
        this.disableSave = false
        this.disableSelect = true
        this.disableCancel = false
      },
      cleanParticipant(){
        this.participant = {
          name: '',
          age: 0,
          state: '',
          id: 0,
          active: false}
      },

      onSubmit(event) {  
        this.$v.participant.$touch();
        if (!this.$v.participant.$anyError){
          event.preventDefault()
          console.log(JSON.stringify(this.participant))
          this.participant.active = true
          if(this.new){
            url.registerParticipant(this.participant).then(response => {
              alert('Salvo com sucesso!')
              router.push('/Home')     
            }).catch ((error)=> console.log(error));
            this.uiState = "form submitted";
          }
          else{
            url.updateParticipant(this.participant).then(response => {
              alert('Salvo com sucesso!')
              router.push('/Home')     
            }).catch ((error)=> console.log(error));
            this.uiState = "form submitted";
          }
        }
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

.div-buttons{
    width: 200px;
    margin: auto;
}

</style>