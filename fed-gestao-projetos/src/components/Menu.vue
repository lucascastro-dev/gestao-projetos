<template>
  <v-navigation-drawer app permanent>
    <v-list dense>
      <v-list-item-title style="align-items: center; display: flex; margin-left: 20px;">Gestão de
        Clientes</v-list-item-title>
      <v-list-item>
        <CreateClienteModal :modalOpenCreateClient="modalOpen" />
        <EditClientModal :modalOpenEditClient="modalOpen" />
      </v-list-item>
      <v-list-item-title style="align-items: center; display: flex; margin-left: 20px;">Gestão de
        Projetos</v-list-item-title>
      <v-list-item>
        <CreateProjectModal :modalOpenCreateProject="modalOpen" />
        <EditProjectModal :modalOpenEditProject="modalOpen" />
      </v-list-item>
      <v-list-item-title style="align-items: center; display: flex; margin-left: 20px;">Gestão de
        Atividades</v-list-item-title>
      <v-list-item>
        <CreateActivityModal :modalOpenCreateActivity="modalOpen" />
        <EditActivityModal :modalOpenEditActivity="modalOpen"/>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
import CreateClienteModal from './CreateClientModal.vue'
import CreateProjectModal from './CreateProjectModal.vue';
import EditClientModal from './EditClientModal.vue';
import EditProjectModal from './EditProjectModal.vue';
import CreateActivityModal from './CreateActivityModal.vue'
import EditActivityModal from './EditActivityModal.vue';

export default {
  components: {
    CreateClienteModal,
    EditClientModal,
    CreateProjectModal,
    EditProjectModal,
    CreateActivityModal,
    EditActivityModal
  },
  data: () => ({
  }),
}
</script>
