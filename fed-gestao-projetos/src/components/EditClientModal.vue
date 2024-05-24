<template>
  <form @submit.prevent="submit">
    <v-select
      v-model="select.value.value"
      :error-messages="select.errorMessage.value"
      :items="items"
      label="Cliente"
    ></v-select>

    <v-text-field
      v-model="name.value.value"
      :error-messages="name.errorMessage.value"
      label="Nome do cliente"
    ></v-text-field>

    <v-text-field
      v-model="email.value.value"
      :error-messages="email.errorMessage.value"
      label="E-mail"
    ></v-text-field>

    <v-text-field
      v-model="phone.value.value"
      :error-messages="phone.errorMessage.value"
      label="Telefone"
    ></v-text-field>

    <v-btn
      class="me-4"
      type="submit"
    >
      Cadastrar cliente
    </v-btn>

    <v-btn @click="handleReset">
      Limpar
    </v-btn>
  </form>
</template>

<script setup>
  import { ref } from 'vue'
  import { useField, useForm } from 'vee-validate'

  const { handleSubmit, handleReset } = useForm({
    validationSchema: {
      name (value) {
        if (value?.length) return true

        return 'Nome obrigatório'
      },
      email (value) {
        if (value?.length) return true

        return 'Email obrigatório'
      },
      phone (value) {
        if (value?.length) return true

        return 'Telefone obrigatório'
      },
      select (value) {
        if (value) return true

        return 'Obrigatório selecionar cliente para editar'
      },
    },
  })
  const name = useField('name')
  const email = useField('email')
  const phone = useField('phone')
  const select = useField('select')

  const submit = handleSubmit(values => {
    alert(JSON.stringify(values, null, 2))
  })
</script>
