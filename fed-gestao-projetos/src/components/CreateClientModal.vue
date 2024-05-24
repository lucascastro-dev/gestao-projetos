<template>
  <div>
    <v-btn @click="openModalCreateClient" color="primary">
      Cadastrar Cliente
    </v-btn>

    <v-dialog v-model="modalOpenCreateClient" max-width="600">
      <v-card>
        <v-card-title>Cadastro de cliente</v-card-title>
        <v-card-text>
          <form @submit.prevent="submit">
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
              Cadastrar cliente
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

const modalOpenCreateClient = ref(false)

const validationSchema = yup.object({
  name: yup.string().required('Nome obrigatório'),
  email: yup.string().email('Email inválido').required('Email obrigatório'),
  phone: yup.string().required('Telefone obrigatório')
})

const { handleSubmit, resetForm } = useForm({
  validationSchema,
})

const { value: nameValue, errorMessage: nameErrors } = useField('name')
const { value: emailValue, errorMessage: emailErrors } = useField('email')
const { value: phoneValue, errorMessage: phoneErrors } = useField('phone')

const openModalCreateClient = () => {
  modalOpenCreateClient.value = true
}

const closeModal = () => {
  modalOpenCreateClient.value = false
  resetForm()
}

const submit = handleSubmit(async values => {
  try {
    const response = await fetch('http://localhost:8081/srv-gestao-projetos/client', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(values)
    })

    if (!response.ok) {
      throw new Error('Erro ao cadastrar cliente')
    }

    resetForm()

    alert('Cliente cadastrado com sucesso!')
  } catch (error) {
    console.error('Erro ao cadastrar cliente:', error.message)
    alert('Erro ao cadastrar cliente. Por favor, tente novamente.')
  }
})
</script>
