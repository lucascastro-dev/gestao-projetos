<template>
  <div>
    <v-btn @click="openModalEditProject" color="primary">
      Editar Projeto
    </v-btn>
    <v-dialog v-model="modalOpenEditProject" max-width="600">
      <v-card>
        <v-card-title>Editar projeto</v-card-title>
        <v-card-text>
          <form @submit.prevent="submit">
            <v-select
              v-model="projectValue"
              :error-messages="projectErrors"
              :items="listProjects"
              label="Projeto"
            ></v-select>

            <v-text-field
              v-model="nameValue"
              :error-messages="nameErrors"
              label="Nome do projeto"
            ></v-text-field>

            <v-text-field
              v-model="descriptionValue"
              :error-messages="descriptionErrors"
              label="Descrição"
            ></v-text-field>

            <v-text-field
              v-model="startDateValue"
              :error-messages="startDateErrors"
              label="Data início"
              type="date"
            ></v-text-field>

            <v-text-field
              v-model="endDateValue"
              :error-messages="endDateErrors"
              label="Data fim"
              type="date"
            ></v-text-field>

            <v-select
              v-model="clientValue"
              :error-messages="clientErrors"
              :items="items"
              label="Cliente"
            ></v-select>

            <v-checkbox
              v-model="checkboxValue"
              label="Ativar projeto"
              type="checkbox"
              value="1"
            ></v-checkbox>

            <v-btn type="submit" color="primary">
              Salvar projeto
            </v-btn>
            <v-btn type="button" @click="resetForm" color="secondary">
              Limpar
            </v-btn>
          </form>
        </v-card-text>
        <v-card-actions>
          <v-btn @click="closeModal" color="secondary">
            Cancelar
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useField, useForm } from 'vee-validate'
import * as yup from 'yup'

const modalOpenEditProject = ref(false)

const validationSchema = yup.object({
  project: yup.string().required('Seleção de projeto obrigatória'),
  name: yup.string().required('Nome obrigatório'),
  description: yup.string(),
  startDate: yup.date().required('Data de início obrigatória'),
  endDate: yup.date().required('Data de fim obrigatória'),
  client: yup.string().required('Seleção de cliente obrigatória'),
})

const { handleSubmit, resetForm } = useForm({
  validationSchema,
})

const { value: projectValue, errorMessage: projectErrors } = useField('project')
const { value: nameValue, errorMessage: nameErrors } = useField('name')
const { value: descriptionValue, errorMessage: descriptionErrors } = useField('description')
const { value: startDateValue, errorMessage: startDateErrors } = useField('startDate')
const { value: endDateValue, errorMessage: endDateErrors } = useField('endDate')
const { value: clientValue, errorMessage: clientErrors } = useField('client')
const { value: checkboxValue } = useField('checkbox')

const items = ref([
  'Cliente 1',
  'Cliente 2',
  'Cliente 3',
  'Cliente 4',
])

const listProjects = ref([
  'Projeto 1',
  'Projeto 2',
  'Projeto 3',
  'Projeto 4',
])

const openModalEditProject = () => {
  modalOpenEditProject.value = true
}

const closeModal = () => {
  modalOpenEditProject.value = false
  resetForm()
}

const submit = handleSubmit(values => {
  alert(JSON.stringify(values, null, 2))
})
</script>
