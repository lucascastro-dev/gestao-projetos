<template>
  <div>
    <v-btn @click="openModalEditActivity" color="primary">
      Editar Atividade
    </v-btn>
    <v-dialog v-model="modalOpenEditActivity" max-width="600">
      <v-card>
        <v-card-title>Editar Atividade</v-card-title>
        <v-card-text>
          <form @submit.prevent="submit">
            <v-select
              v-model="selectedProjectId"
              :items="projects.map(project => `${project.value} - ${project.text}`)"
              label="Projeto"
              @change="loadActivities"
            ></v-select>

            <v-select
              v-model="selectedActivityId"
              :items="filteredActivities.map(activity => `${activity.value} - ${activity.text}`)"
              label="Atividade"
              @change="loadActivityDetails"
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
              value="1"
            ></v-checkbox>

            <v-btn type="submit" color="primary">
              Salvar Atividade
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
import { ref, onMounted, watch } from 'vue'
import { useField, useForm } from 'vee-validate'
import * as yup from 'yup'

const modalOpenEditActivity = ref(false)
const projects = ref([])
const activities = ref([])
const selectedProjectId = ref('')
const selectedActivityId = ref(null)
const filteredActivities = ref([])

const validationSchema = yup.object({
  selectedProjectId: yup.string().required('Seleção de projeto obrigatória'),
  selectedActivityId: yup.string().required('Seleção de atividade obrigatória'),
  name: yup.string().required('Nome obrigatório'),
  startDate: yup.date().required('Data de início obrigatória'),
  endDate: yup.date().required('Data de fim obrigatória'),
})

const { handleSubmit, resetForm } = useForm({
  validationSchema,
})

const { value: nameValue, errorMessage: nameErrors } = useField('name')
const { value: descriptionValue } = useField('description')
const { value: startDateValue, errorMessage: startDateErrors } = useField('startDate')
const { value: endDateValue, errorMessage: endDateErrors } = useField('endDate')
const { value: statusValue } = useField('statusValue')

const openModalEditActivity = () => {
  modalOpenEditActivity.value = true
}

const closeModal = () => {
  modalOpenEditActivity.value = false
  resetForm()
}

const loadActivities = () => {
  const projectId = selectedProjectId.value.split(' - ')[0];
  filteredActivities.value = activities.value.filter(activity => activity.projectValue.idProject === parseInt(projectId));
}

watch(selectedProjectId, (newValue, oldValue) => {
  if (newValue) {
    loadActivities()
  }
});

const loadActivityDetails = async () => {
  const activityId = selectedActivityId.value.split(' - ')[0]
  const activity = activities.value.find(act => act.value === activityId)

  if (activity) {
    nameValue.value = activity.name
    descriptionValue.value = activity.description
    startDateValue.value = activity.startDate
    endDateValue.value = activity.endDate
    statusValue.value = activity.status
  }
}

const submit = async (event) => {
  event.preventDefault()
  try {
    const response = await fetch(`http://localhost:8081/srv-gestao-projetos/activity`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        idActivity: selectedActivityId.value.split(' - ')[0],
        name: nameValue.value,
        description: descriptionValue.value,
        startDate: startDateValue.value,
        endDate: endDateValue.value,
        idProjects: selectedProjectId.value.split(' - ')[0],
        status: statusValue.value ? true : false,
      })
    })

    if (!response.ok) {
      throw new Error('Erro ao editar atividade')
    }

    resetForm()
    closeModal()
    alert('Atividade editada com sucesso!')
  } catch (error) {
    console.error('Erro ao editar atividade:', error.message)
    alert('Erro ao editar atividade. Por favor, tente novamente.')
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

    const activitiesResponse = await fetch('http://localhost:8081/srv-gestao-projetos/activity')
    if (!activitiesResponse.ok) {
      throw new Error('Erro ao obter lista de atividades')
    }
    const activitiesData = await activitiesResponse.json()
    activities.value = activitiesData.map(activity => ({
      text: activity.name,
      value: activity.idActivity,
      projectValue: activity.project
    }))
  } catch (error) {
    alert('Erro ao obter listas de projetos e atividades. Por favor, tente novamente.')
  }
})
</script>
