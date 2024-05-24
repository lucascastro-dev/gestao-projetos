<template>
  <v-list width="600px">
    <v-list-item>
      <v-row>
        <v-col cols="4">
          <span>Cliente</span>
        </v-col>
        <v-col cols="4">
          <span>Projeto</span>
        </v-col>
        <v-col cols="3">
          <span>Atividade</span>
        </v-col>
      </v-row>
    </v-list-item>

    <v-list-item v-for="(item, index) in items" :key="index">
      <v-row>
        <v-col cols="4">
          <span>{{ item.cliente }}</span>
        </v-col>
        <v-col cols="4">
          <span>{{ item.projeto }}</span>
        </v-col>
        <v-col cols="3">
          <v-icon @click="openModal">mdi-magnify</v-icon>
        </v-col>
      </v-row>
    </v-list-item>
  </v-list>

  <v-dialog v-model="modalActivityOpen" persistent max-width="600px">
    <v-card>
      <v-card-title>Lista de Atividades</v-card-title>
      <v-card-text>
        <v-list>
          <v-list-item v-for="(atividade, index) in atividades" :key="index">
            <v-list-item-title>{{ atividade }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-card-text>
      <v-card-actions>
        <v-btn color="primary" @click="modalActivityOpen = false">Fechar</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
import ActivitiesModal from './ActivitiesModal.vue';

export default {
  components: {
    ActivitiesModal
  },
  data() {
    return {
      items: [
        { cliente: 'Cliente 1', projeto: 'Projeto 1', },
        { cliente: 'Cliente 2', projeto: 'Projeto 2', }
      ],
      modalActivityOpen: false,
      atividades: ['Atividade 1', 'Atividade 2', 'Atividade 3']
    }
  },
  methods: {
    openModal() {
      this.modalActivityOpen = true;
    }
  }
};
</script>
