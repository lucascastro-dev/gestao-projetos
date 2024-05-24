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
            <v-select v-model="selectedProjectId" :items="projects.map(project => `${project.value} - ${project.text}`)"
              label="Projeto" @change="loadProjectDetails"></v-select>

            <v-text-field v-model="nameValue" :error-messages="nameErrors" label="Nome do projeto"></v-text-field>

            <v-text-field v-model="descriptionValue" :error-messages="descriptionErrors"
              label="Descrição"></v-text-field>

            <v-text-field v-model="startDateValue" :error-messages="startDateErrors" label="Data início"
              type="date"></v-text-field>

            <v-text-field v-model="endDateValue" :error-messages="endDateErrors" label="Data fim"
              type="date"></v-text-field>

            <v-select v-model="selectedClientId" :items="clients.map(client => `${client.value} - ${client.text}`)"
              :error-messages="clientErrors" label="Cliente"></v-select>

            <v-checkbox v-model="statusValue" label="Ativar projeto" value="1"></v-checkbox>

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
import { useField, useForm } from 'vee-validate';
import { onMounted, ref } from 'vue';
import * as yup from 'yup';

const modalOpenEditProject = ref(false)
const projects = ref([])
const clients = ref([])
const selectedProjectId = ref(null)
const selectedClientId = ref(null)

const validationSchema = yup.object({
  selectedProjectId: yup.string().required('Seleção de projeto obrigatória'),
  name: yup.string().required('Nome obrigatório'),
  description: yup.string(),
  startDate: yup.date().required('Data de início obrigatória'),
  endDate: yup.date().required('Data de fim obrigatória'),
  selectedClientId: yup.string().required('Seleção de cliente obrigatória'),
})

const { handleSubmit, resetForm } = useForm({
  validationSchema,
})

const { value: nameValue, errorMessage: nameErrors } = useField('name')
const { value: descriptionValue, errorMessage: descriptionErrors } = useField('description')
const { value: startDateValue, errorMessage: startDateErrors } = useField('startDate')
const { value: endDateValue, errorMessage: endDateErrors } = useField('endDate')
const { value: clientErrors } = useField('selectedClientId')
const { value: statusValue } = useField('statusValue')

const openModalEditProject = () => {
  modalOpenEditProject.value = true
}

const closeModal = () => {
  modalOpenEditProject.value = false
  resetForm()
}

const loadProjectDetails = async () => {
  const projectId = selectedProjectId.value.split(' - ')[0]
  const project = projects.value.find(proj => proj.value === projectId)

  if (project) {
    nameValue.value = project.name
    descriptionValue.value = project.description
    startDateValue.value = project.startDate
    endDateValue.value = project.endDate
    selectedClientId.value = `${project.client.idClient} - ${project.client.name}`
    statusValue.value = project.status
  }
}

const submit = async (event) => {
  event.preventDefault();
  try {
    const response = await fetch(`http://localhost:8081/srv-gestao-projetos/project`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        idProject: selectedProjectId.value.split(' - ')[0],
        name: nameValue.value,
        description: descriptionValue.value,
        startDate: startDateValue.value,
        endDate: endDateValue.value,
        idClient: selectedClientId.value.split(' - ')[0],
        status: statusValue.value ? true : false,
      })
    })

    if (!response.ok) {
      throw new Error('Erro ao editar projeto')
    }

    resetForm()
    closeModal()
    alert('Projeto editado com sucesso!')
  } catch (error) {
    console.error('Erro ao editar projeto:', error.message)
    alert('Erro ao editar projeto. Por favor, tente novamente.')
  }
}

onMounted(async () => {
  try {
    const clientsResponse = await fetch('http://localhost:8081/srv-gestao-projetos/client')
    if (!clientsResponse.ok) {
      throw new Error('Erro ao obter lista de clientes')
    }
    const clientsData = await clientsResponse.json()
    clients.value = clientsData.map(client => ({
      text: client.name,
      value: client.idClient,
    }))

    const projectsResponse = await fetch('http://localhost:8081/srv-gestao-projetos/project')
    if (!projectsResponse.ok) {
      throw new Error('Erro ao obter lista de projetos')
    }
    const projectsData = await projectsResponse.json()
    projects.value = projectsData.map(project => ({
      text: project.name,
      value: project.idProject,
      ...project
    }))
  } catch (error) {
    console.error('Erro ao obter listas:', error.message)
    alert('Erro ao obter listas de clientes e projetos. Por favor, tente novamente.')
  }
})
</script>
