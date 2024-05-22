package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project;

import java.util.List;

public interface IProjectForm extends IProject {
    public Long getIdClient();

    public List<Long> getIdsActivity();

    public void setIdClient(Long idClient);

    public void setIdsActivity(List<Long> idsActivity);
}
