<template>
  <div>
    <v-btn @click="openModalEditClient" color="primary">
      Editar Cliente
    </v-btn>

    <v-dialog v-model="modalOpenEditClient" max-width="600">
      <v-card>
        <v-card-title>Editar cliente</v-card-title>
        <v-card-text>
          <form @submit.prevent="submit">
            <v-select
              v-model="selectedClientId"
              :items="clients.map(client => client.text)"
              :error-messages="clientIdErrors"
              label="Cliente"
              @change="loadClientDetails(selectedClientId)"
            ></v-select>

            <v-text-field
              v-model="nameValue"
              :error-messages="nameErrors"
              label="Nome do cliente"
            ></v-text-field>

            <v-text-field
              v-model="emailValue"
              :error-messages="emailErrors"
              label="E-mail"
            ></v-text-field>

            <v-text-field
              v-model="phoneValue"
              :error-messages="phoneErrors"
              label="Telefone"
            ></v-text-field>

            <v-btn type="submit" color="primary">
              Editar cliente
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

const modalOpenEditClient = ref(false)
const clients = ref([])
const selectedClientId = ref(null)

const validationSchema = yup.object({
  name: yup.string().required('Nome obrigatório'),
  email: yup.string().email('Email inválido').required('Email obrigatório'),
  phone: yup.string().required('Telefone obrigatório')
})

const { handleSubmit, resetForm } = useForm({
  validationSchema,
})

const { value: clientId, errorMessage: clientIdErrors } = useField('selectedClientId')
const { value: nameValue, errorMessage: nameErrors } = useField('name')
const { value: emailValue, errorMessage: emailErrors } = useField('email')
const { value: phoneValue, errorMessage: phoneErrors } = useField('phone')

const openModalEditClient = () => {
  modalOpenEditClient.value = true
}

const closeModal = () => {
  modalOpenEditClient.value = false
  resetForm()
}

const submit = handleSubmit(async values => {
  try {
    const response = await fetch(`http://localhost:8081/srv-gestao-projetos/client`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        idClient: selectedClientId.value.split(' - ')[0],
        name: values.name,
        email: values.email,
        phone: values.phone
      })
    })

    if (!response.ok) {
      throw new Error('Erro ao editar cliente')
    }

    resetForm()

    alert('Cliente editado com sucesso!')
  } catch (error) {
    console.error('Erro ao editar cliente:', error.message)
    alert('Erro ao editar cliente. Por favor, tente novamente.')
  }
})

const loadClientDetails = (clientId) => {
  const selectedClient = clients.value.find(client => client.value === clientId)
  if (selectedClient) {
    nameValue.value = `${selectedClient.value} - ${selectedClient.name}`
    emailValue.value = selectedClient.email
    phoneValue.value = selectedClient.phone
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
      text: `${client.idClient} - ${client.name}`,
      value: client.idClient,
      name: client.name,
      email: client.email,
      phone: client.phone
    }))
  } catch (error) {
    console.error('Erro ao obter lista de clientes:', error.message)
    alert('Erro ao obter lista de clientes. Por favor, tente novamente.')
  }
})
</script>
