package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project;

import jakarta.validation.constraints.NotNull;

public interface IProjectForm extends IProject {
    @NotNull(message = "Obrigatório informar cliente do projeto")
    public Long getIdClient();

    public void setIdClient(Long idClient);

}
