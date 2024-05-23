package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project;

import java.util.List;

public interface IProjectService<P extends IProjectForm> {
    IProjectEntity save(IProjectForm projectForm);

    void delete(Long idProject);

    List<IProjectEntity> findAllProject();

    IProjectEntity findProjectById(Long idProject);

    IProjectEntity findByNameProject(String nameProject);

    List<IProjectEntity> findProjectByClient(Long idCliente);
}
