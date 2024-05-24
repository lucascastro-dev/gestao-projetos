<template>
  <div>
    <v-btn @click="openModalCreateActivity" color="primary">
      Criar Atividade
    </v-btn>

    <v-dialog v-model="modalOpenCreateActivity" max-width="600">
      <v-card>
        <v-card-title>Cadastro de Atividade</v-card-title>
        <v-card-text>
          <form @submit.prevent="submit">
            <v-select
              v-model="selectedProjectId"
              :items="projects.map(project => `${project.value} - ${project.text}`)"
              label="Projeto"
              :error-messages="projectErrors"
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

            <v-checkbox
              v-model="statusValue"
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
import { ref, onMounted } from 'vue'
import { useField, useForm } from 'vee-validate'
import * as yup from 'yup'

const modalOpenCreateActivity = ref(false)
const projects = ref([])
const selectedProjectId = ref(null)

const validationSchema = yup.object({
  selectedProjectId: yup.string().required('Seleção de projeto obrigatória'),
  name: yup.string().required('Nome obrigatório'),
  startDate: yup.date().required('Data de início obrigatória'),
  endDate: yup.date().required('Data de fim obrigatória'),
})

const { handleSubmit, resetForm } = useForm({
  validationSchema,
})


const nameValue = ref('')
const descriptionValue = ref('')
const startDateValue = ref('')
const endDateValue = ref('')
const statusValue = ref(false)
const { value: projectValue, errorMessage: projectErrors } = useField('selectedProjectId')

const openModalCreateActivity = () => {
  modalOpenCreateActivity.value = true
}

const closeModal = () => {
  modalOpenCreateActivity.value = false
  resetForm()
}

const submit = async (event) => {
  event.preventDefault();
  try {
    const response = await fetch(`http://localhost:8081/srv-gestao-projetos/activity`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        name: nameValue.value,
        description: descriptionValue.value,
        startDate: startDateValue.value,
        endDate: endDateValue.value,
        idProjects: selectedProjectId.value.split(' - ')[0],
        status: statusValue.value ? true : false,
      })
    })

    if (!response.ok) {
      throw new Error('Erro ao criar atividade')
    }

    resetForm()
    closeModal()
    alert('Atividade criada com sucesso!')
  } catch (error) {
    console.error('Erro ao criar atividade:', error.message)
    alert('Erro ao criar atividade. Por favor, tente novamente.')
  }
}

onMounted(async () => {
  try {
    const projectsResponse = await fetch('http://localhost:8081/srv-gestao-projetos/project')
    if (!projectsResponse.ok) {
      throw new Error('Erro ao obter lista de projetos')
    }
    const projectsData = await projectsResponse.json()
    projects.value = projectsData.map(project => ({
      text: project.name,
      value: project.idProject,
    }))
  } catch (error) {
    console.error('Erro ao obter lista de projetos:', error.message)
    alert('Erro ao obter lista de projetos. Por favor, tente novamente.')
  }
})
</script>
