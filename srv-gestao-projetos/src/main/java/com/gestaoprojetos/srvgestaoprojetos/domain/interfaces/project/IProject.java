package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project;

import java.time.LocalDate;

public interface IProject {
    Long getIdProject();

    String getName();

    String getDescription();

    LocalDate getStartDate();

    LocalDate getEndDate();

    Boolean getStatus();

    void setIdProject(Long idProject);

    void setName(String name);

    void setDescription(String description);

    void setStartDate(LocalDate startDate);

    void setEndDate(LocalDate endDate);

    void setStatus(Boolean status);
}
