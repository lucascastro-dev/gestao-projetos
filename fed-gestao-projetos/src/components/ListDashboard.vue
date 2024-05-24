<template>
  <div>
    <v-list width="600px">
      <v-list-item>
        <v-row>
          <v-col cols="4">
            <span>Cliente</span>
          </v-col>
          <v-col cols="4">
            <span>Projeto</span>
          </v-col>
          <v-col cols="4">
            <span>Atividade</span>
          </v-col>
        </v-row>
      </v-list-item>

      <v-list-item-group>
        <v-list-item v-for="(project, projectIndex) in filteredProjects" :key="projectIndex">
          <v-row>
            <v-col cols="4">
              <span>{{ project.client.name }}</span>
            </v-col>
            <v-col cols="4">
              <span>{{ project.name }}</span>
            </v-col>
            <v-col cols="4">
              <v-icon @click="openModal(projectIndex)">mdi-magnify</v-icon>
            </v-col>
          </v-row>
        </v-list-item>
      </v-list-item-group>
    </v-list>

    <ActivitiesModal :modalActivityOpen="modalActivityOpen" :atividades="filteredProjectActivities" @close="modalActivityOpen = false" />
  </div>
</template>

<script>
import ActivitiesModal from './ActivitiesModal.vue';

export default {
  components: {
    ActivitiesModal
  },
  data() {
    return {
      projects: [],
      modalActivityOpen: false,
      modalProjectIndex: null
    };
  },
  mounted() {
    this.fetchProjects();
  },
  methods: {
    async fetchProjects() {
      try {
        const projectsResponse = await fetch('http://localhost:8081/srv-gestao-projetos/project');
        if (!projectsResponse.ok) {
          throw new Error('Erro ao obter lista de projetos');
        }

        const projectsData = await projectsResponse.json();

        this.projects = projectsData.map(project => ({
          ...project,
          activities: []
        }));

        await this.fetchActivities();
      } catch (error) {
        console.error('Error fetching projects:', error.message);
      }
    },
    async fetchActivities() {
      try {
        const activitiesResponse = await fetch('http://localhost:8081/srv-gestao-projetos/activity');
        if (!activitiesResponse.ok) {
          throw new Error('Erro ao obter lista de atividades');
        }

        const activitiesData = await activitiesResponse.json();

        activitiesData.forEach(activity => {
          const projectIndex = this.projects.findIndex(project => project.idProject === activity.project.idProject);
          if (projectIndex !== -1) {
            this.projects[projectIndex].activities.push(activity);
          }
        });

      } catch (error) {
        console.error('Error fetching activities:', error.message);
      }
    },
    openModal(projectIndex) {
      this.modalProjectIndex = projectIndex;
      this.modalActivityOpen = true;
    }
  },
  computed: {
    filteredProjects() {
      return this.projects.filter(project => project.status);
    },
    filteredProjectActivities() {
      if (this.modalProjectIndex !== null) {
        return this.projects[this.modalProjectIndex].activities.filter(activity => activity.status);
      }
      return [];
    }
  }
};
</script>
