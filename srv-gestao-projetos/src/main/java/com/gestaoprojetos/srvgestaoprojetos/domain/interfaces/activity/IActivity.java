package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public interface IActivity {
    Long getIdActivity();

    @NotNull(message = "Nome de atividade é obrigatória")
    String getName();

    String getDescription();

    @NotNull(message = "Data inicio da atividade é obrigatória")
    LocalDate getStartDate();

    @NotNull(message = "Data fim da atividade é obrigatória")
    LocalDate getEndDate();

    Boolean getStatus();

    void setIdActivity(Long idActivity);

    void setName(String name);

    void setDescription(String description);

    void setStartDate(LocalDate startDate);

    void setEndDate(LocalDate endDate);

    void setStatus(Boolean status);
}
