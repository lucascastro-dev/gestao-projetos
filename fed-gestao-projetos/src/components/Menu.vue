<template>
  <v-app-bar :elevation="2">
    <v-menu>
      <template v-slot:activator="{ props }">
        <v-btn color="primary" v-bind="props">
          Cliente
        </v-btn>
      </template>
      <v-list>
        <v-list-item v-for="(item, index) in client" :key="index" :value="index" @click="item.handle(modalOpen)">
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>

    <v-btn color="primary">
      Projeto

      <v-menu activator="parent">
        <v-list>
          <v-list-item v-for="(item, index) in project" :key="index" :value="index">
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </v-btn>

    <v-btn id="menu-activator" color="primary">
      Atividade
    </v-btn>

    <v-menu activator="#menu-activator">
      <v-list>
        <v-list-item v-for="(item, index) in activity" :key="index" :value="index">
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>

    <!-- Renderizar o modal -->
    <CreateClienteModal :modalOpen="modalOpen" />
  </v-app-bar>
</template>

<script>
import CreateClienteModal from './CreateClientModal'

const handleCreateClient = (modalOpen) => {
  console.log("Cadastrar Cliente")
  modalOpen.value = true;
}
const handleEditClient = () => {
  console.log("Editar Cliente")
}
const handleCreateProject = () => {
  console.log("Criar Projeto")
}
const handleEditProject = () => {
  console.log("Editar Projeto")
}
const handleCreateActivity = () => {
  console.log("Criar Atividade")
}
const handleEditActivity = () => {
  console.log("Editar Atividade")
}

export default {
  components: {
    CreateClienteModal
  },
  data: () => ({
    modalOpen: false,
    client: [
      { title: 'Cadastrar Cliente', handle: handleCreateClient},
      { title: 'Editar Cliente', handle: handleEditClient }
    ],
    project: [
      { title: 'Criar Projeto', handle: handleCreateProject },
      { title: 'Editar Projeto', handle: handleEditProject }
    ],
    activity: [
      { title: 'Criar Atividade', handle: handleCreateActivity },
      { title: 'Editar Atividade', handleEditActivity }
    ],
  }),
}
</script>
