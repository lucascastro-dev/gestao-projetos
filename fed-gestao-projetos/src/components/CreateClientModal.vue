<template>
  <div>
    <v-btn @click="openModal" color="primary">
      Cadastrar Cliente
    </v-btn>

    <v-dialog v-model="modalOpen" max-width="600">
      <v-card>
        <v-card-title>Formulário de Cliente</v-card-title>
        <v-card-text>
          <form @submit.prevent="submit">
            <v-text-field
              v-model="name.value"
              :error-messages="name.errorMessage"
              label="Nome do cliente"
            ></v-text-field>

            <v-text-field
              v-model="email.value"
              :error-messages="email.errorMessage"
              label="E-mail"
            ></v-text-field>

            <v-text-field
              v-model="phone.value"
              :error-messages="phone.errorMessage"
              label="Telefone"
            ></v-text-field>

            <v-btn type="submit">
              Cadastrar cliente
            </v-btn>
            <v-btn @click="handleReset">
              Limpar
            </v-btn>
          </form>
        </v-card-text>
        <v-card-actions>
          <v-btn @click="closeModal">
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

const modalOpen = ref(false)

const { handleSubmit, handleReset } = useForm({
  validationSchema: {
    name: (value) => value?.length || 'Nome obrigatório',
    email: (value) => value?.length || 'Email obrigatório',
    phone: (value) => value?.length || 'Telefone obrigatório',
  },
})
const name = useField('name')
const email = useField('email')
const phone = useField('phone')

const openModal = () => {
  modalOpen.value = true
}

const closeModal = () => {
  modalOpen.value = false
}

const submit = handleSubmit(values => {
  alert(JSON.stringify(values, null, 2))
})
</script>
