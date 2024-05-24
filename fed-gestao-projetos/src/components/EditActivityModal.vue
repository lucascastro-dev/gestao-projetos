<template>
  <div>
    <v-btn @click="openModalEditActivity" color="primary">
      Editar Atividade
    </v-btn>
    <v-dialog v-model="modalOpenEditActivity" max-width="600">
      <v-card>
        <v-card-title>Cadastro de Atividade</v-card-title>
        <v-card-text>
          <form @submit.prevent="submit">
            <v-select
              v-model="activityValue"
              :error-messages="activityError"
              :items="activityList"
              label="Atividade"
            ></v-select>

            <v-text-field
              v-model="nameValue"
              :error-messages="nameErrors"
              label="Nome da atividade"
            ></v-text-field>

            <v-text-field
              v-model="descriptionValue"
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
              v-model="projectValue"
              :error-messages="projectErrors"
              :items="items"
              label="Projeto"
            ></v-select>

            <v-checkbox
              v-model="checkboxValue"
              label="Ativar atividade"
              type="checkbox"
              value="1"
            ></v-checkbox>

            <v-btn type="submit" color="primary">
              Criar Atividade
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

const modalOpenEditActivity = ref(false)

const validationSchema = yup.object({
  name: yup.string().required('Nome obrigatório'),
  startDate: yup.date().required('Data de início obrigatória'),
  endDate: yup.date().required('Data de fim obrigatória'),
  project: yup.string().required('Seleção de projeto obrigatória'),
  activity: yup.string().required('Seleção de atividade obrigatória'),
})

const { handleSubmit, resetForm } = useForm({
  validationSchema,
})

const { value: nameValue, errorMessage: nameErrors } = useField('name')
const { value: descriptionValue } = useField('description')
const { value: startDateValue, errorMessage: startDateErrors } = useField('startDate')
const { value: endDateValue, errorMessage: endDateErrors } = useField('endDate')
const { value: projectValue, errorMessage: projectErrors } = useField('project')
const { value: activityValue, errorMessage: activityError } = useField('activity')
const { value: checkboxValue } = useField('checkbox')

const activityList = ref([
  'Atividade 1',
  'Atividade 2',
  'Atividade 3',
  'Atividade 4',
])

const items = ref([
  'Projeto 1',
  'Projeto 2',
  'Projeto 3',
  'Projeto 4',
])

const openModalEditActivity = () => {
  modalOpenEditActivity.value = true
}

const closeModal = () => {
  modalOpenEditActivity.value = false
  resetForm()
}

const submit = handleSubmit(values => {
  alert(JSON.stringify(values, null, 2))
})
</script>
