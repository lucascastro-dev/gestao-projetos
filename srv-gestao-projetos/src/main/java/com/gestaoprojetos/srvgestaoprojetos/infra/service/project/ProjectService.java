package com.gestaoprojetos.srvgestaoprojetos.infra.service.project;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectService;
import com.gestaoprojetos.srvgestaoprojetos.infra.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService implements IProjectService<IProjectForm> {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public IProjectEntity save(IProjectForm projectForm) {
        return projectRepository.save(new ProjectEntity(projectForm));
    }

    @Override
    public void delete(Long idProject) {
        projectRepository.deleteById(idProject);
    }

    @Override
    public List<IProjectEntity> findAllProject() {
        return projectRepository.findAll().stream().map(
                projectEntity -> (IProjectEntity) projectEntity).collect(Collectors.toList());
    }

    @Override
    public IProjectEntity findProjectById(Long idProject) {
        return projectRepository.findByIdProject(idProject);
    }

    @Override
    public IProjectEntity findByNameProject(String nameProject) {
        return projectRepository.findByName(nameProject);
    }

    @Override
    public List<IProjectEntity> findProjectByClient(Long idCliente) {
        return projectRepository.findByClient(ClientEntity.builder().idClient(idCliente).build());
    }
}
