package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ProjectEntity;

import java.util.List;

public interface IClientEntity extends IClient {
    List<ProjectEntity> getProjects();

    void setProjects(List<ProjectEntity> projects);
}
