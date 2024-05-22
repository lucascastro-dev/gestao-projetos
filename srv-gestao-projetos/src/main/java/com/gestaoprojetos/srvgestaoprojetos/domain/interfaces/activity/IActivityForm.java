package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity;

import jakarta.validation.constraints.NotNull;

public interface IActivityForm extends IActivity {
    @NotNull(message = "Obrigatório informar projeto para criar atividade")
    Long getIdProjects();

    void setIdProjects(Long idProjects);
}
