<template>
  <v-dialog :modelValue="modalActivityOpen" persistent max-width="600px">
    <v-card>
      <v-card-title>Lista de Atividades</v-card-title>
      <v-card-text>
        <v-list>
          <v-list-item v-for="(atividade, index) in atividades" :key="index">
            <v-list-item-title>
              <div>{{ atividade.name }}</div>
              <div>{{ atividade.description }}</div>
            </v-list-item-title>
          </v-list-item>
        </v-list>
      </v-card-text>
      <v-card-actions>
        <v-btn color="primary" @click="closeModal">Fechar</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  props: {
    modalActivityOpen: {
      type: Boolean,
      required: true
    },
    atividades: {
      type: Array,
      required: true
    }
  },
  methods: {
    closeModal() {
      this.$emit('close');
    }
  }
};
</script>
