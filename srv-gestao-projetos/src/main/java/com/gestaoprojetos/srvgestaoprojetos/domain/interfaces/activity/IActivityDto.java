package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity;

import com.gestaoprojetos.srvgestaoprojetos.domain.dto.ProjectDto;

public interface IActivityDto extends IActivity {
    public ProjectDto getProject();

    public void setProject(ProjectDto project);
}
