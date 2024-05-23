package com.gestaoprojetos.srvgestaoprojetos.infra.repository;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {
    IActivityEntity findByIdActivity(Long idActivity);

    IActivityEntity findByProjects(IProjectEntity idProject);
}
