package com.gestaoprojetos.srvgestaoprojetos.infra.repository;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    IProjectEntity findByIdProject(Long idProject);

    IProjectEntity findByName(String name);

    List<IProjectEntity> findByClient(IClientEntity client);
}
