package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ProjectEntity;

import java.time.LocalDate;

public interface IActivity {
    Long getIdActivity();

    String getName();

    String getDescription();

    LocalDate getStartDate();

    LocalDate getEndDate();

    Boolean getStatus();

    ProjectEntity getProjects();

    void setIdActivity(Long idActivity);

    void setName(String name);

    void setDescription(String description);

    void setStartDate(LocalDate startDate);

    void setEndDate(LocalDate endDate);

    void setStatus(Boolean status);

    void setProjects(ProjectEntity projects);
}
