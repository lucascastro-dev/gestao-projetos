package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ProjectEntity;

import java.util.Set;

public interface IClientEntity extends IClient {
    Set<ProjectEntity> getProjects();
    void setProjects(Set<ProjectEntity> projects);
}
