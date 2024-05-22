package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ProjectEntity;

import java.util.List;

public interface IClient {
    Long getIdClient();

    String getName();

    String getEmail();

    String getPhone();

    List<ProjectEntity> getProjects();

    void setIdClient(Long idClient);

    void setName(String name);

    void setEmail(String email);

    void setPhone(String phone);

    void setProjects(List<ProjectEntity> projects);
}
