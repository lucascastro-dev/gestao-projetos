package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public interface IProject {
    Long getIdProject();

    @NotNull(message = "Obrigatório informar nome do projeto")
    String getName();

    String getDescription();

    @NotNull(message = "Obrigatório informar data inicio do projeto")
    LocalDate getStartDate();

    @NotNull(message = "Obrigatório informar data fim do projeto")
    LocalDate getEndDate();

    Boolean getStatus();

    void setIdProject(Long idProject);

    void setName(String name);

    void setDescription(String description);

    void setStartDate(LocalDate startDate);

    void setEndDate(LocalDate endDate);

    void setStatus(Boolean status);
}
