package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ProjectEntity;

public interface IActivityEntity extends IActivity {
    ProjectEntity getProjects();

    void setProjects(ProjectEntity projects);
}
