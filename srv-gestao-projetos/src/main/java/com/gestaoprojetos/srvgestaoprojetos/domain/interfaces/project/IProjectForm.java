package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface IProjectForm extends IProject {
    @NotNull(message = "Obrigatório informar cliente do projeto")
    public Long getIdClient();

    public List<Long> getIdsActivity();

    public void setIdClient(Long idClient);

    public void setIdsActivity(List<Long> idsActivity);
}
