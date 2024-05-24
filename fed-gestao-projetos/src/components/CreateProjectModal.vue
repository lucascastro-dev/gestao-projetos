<template>
  <div>
    <v-btn @click="openModalCreateProject" color="primary">
      Criar Projeto
    </v-btn>

    <v-dialog v-model="modalOpenCreateProject" max-width="600">
      <v-card>
        <v-card-title>Criar projeto</v-card-title>
        <v-card-text>
          <form @submit.prevent="submit">
            <v-text-field
              v-model="nameValue"
              label="Nome do projeto"
            ></v-text-field>

            <v-text-field
              v-model="descriptionValue"
              label="Descrição"
            ></v-text-field>

            <v-text-field
              v-model="startDateValue"
              label="Data início"
              type="date"
            ></v-text-field>

            <v-text-field
              v-model="endDateValue"
              label="Data fim"
              type="date"
            ></v-text-field>

            <v-select
              v-model="selectedClientId"
              :items="clients.map(client => `${client.value} - ${client.text}`)"
              label="Cliente"
            ></v-select>

            <v-checkbox
              v-model="statusValue"
              label="Ativar projeto"
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
import { ref, onMounted } from 'vue'
import { useForm } from 'vee-validate'
import * as yup from 'yup'

const modalOpenCreateProject = ref(false)
const clients = ref([])
const selectedClientId = ref(null)

const validationSchema = yup.object({
  name: yup.string().required('Nome obrigatório'),
  description: yup.string(),
  startDate: yup.date().required('Data de início obrigatória'),
  endDate: yup.date().required('Data de fim obrigatória'),
  selectedClientId: yup.string().required('Seleção de cliente obrigatória'),
})

const { handleSubmit, resetForm } = useForm({
  validationSchema,
})

const nameValue = ref('')
const descriptionValue = ref('')
const startDateValue = ref('')
const endDateValue = ref('')
const statusValue = ref(false)

const openModalCreateProject = () => {
  modalOpenCreateProject.value = true
}

const closeModal = () => {
  modalOpenCreateProject.value = false
  resetForm()
}

const submit = async (event) => {
  event.preventDefault();
  try {
    const response = await fetch(`http://localhost:8081/srv-gestao-projetos/project`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        name: nameValue.value,
        description: descriptionValue.value,
        startDate: startDateValue.value,
        endDate: endDateValue.value,
        idClient: selectedClientId.value.split(' - ')[0],
        status: statusValue.value ? true : false,
      })
    })

    if (!response.ok) {
      throw new Error('Erro ao criar projeto')
    }

    resetForm()

    alert('Projeto criado com sucesso!')
  } catch (error) {
    console.error('Erro ao criar projeto:', error.message)
    alert('Erro ao criar projeto. Por favor, tente novamente.')
  }
}

onMounted(async () => {
  try {
    const response = await fetch('http://localhost:8081/srv-gestao-projetos/client')
    if (!response.ok) {
      throw new Error('Erro ao obter lista de clientes')
    }
    const data = await response.json()
    clients.value = data.map(client => ({
      text: client.name,
      value: client.idClient,
    }))
  } catch (error) {
    console.error('Erro ao obter lista de clientes:', error.message)
    alert('Erro ao obter lista de clientes. Por favor, tente novamente.')
  }
})
</script>
