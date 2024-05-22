package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client;

import com.gestaoprojetos.srvgestaoprojetos.domain.dto.ProjectDto;

import java.util.List;

public interface IClientDto extends IClient {
    List<ProjectDto> getProjects();

    void setProjects(List<ProjectDto> projects);

}