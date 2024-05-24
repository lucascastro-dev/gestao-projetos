<template>
  <form @submit.prevent="submit">
    <v-text-field
      v-model="name.value.value"
      :error-messages="name.errorMessage.value"
      label="Nome da atividade"
    ></v-text-field>

    <v-text-field
      v-model="description.value.value"
      label="Descrição"
    ></v-text-field>

    <v-text-field
      v-model="startDate.value.value"
      :error-messages="startDate.errorMessage.value"
      label="Data início"
      type="date"
    ></v-text-field>

    <v-text-field
      v-model="endDate.value.value"
      :error-messages="endDate.errorMessage.value"
      label="Data fim"
      type="date"
    ></v-text-field>

    <v-select
      v-model="select.value.value"
      :error-messages="select.errorMessage.value"
      :items="items"
      label="Projeto"
    ></v-select>

    <v-checkbox
      v-model="checkbox.value.value"
      label="Ativar atividade"
      type="checkbox"
      value="1"
    ></v-checkbox>

    <v-btn
      class="me-4"
      type="submit"
    >
      Criar projeto
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
      select (value) {
        if (value) return true

        return 'Obrigatório selecionar projeto para a atividade'
      },
    },
  })
  const name = useField('name')
  const description = useField('description')
  const startDate = useField('startDate')
  const endDate = useField('endDate')
  const select = useField('select')
  const checkbox = useField('checkbox')

  const items = ref([
    'Item 1',
    'Item 2',
    'Item 3',
    'Item 4',
  ])

  const submit = handleSubmit(values => {
    alert(JSON.stringify(values, null, 2))
  })
</script>
