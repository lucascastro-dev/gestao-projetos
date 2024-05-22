package com.gestaoprojetos.srvgestaoprojetos.domain.repository;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    IProjectEntity findByIdProject(Long idProject);

    IProjectEntity findByName(String name);
}
