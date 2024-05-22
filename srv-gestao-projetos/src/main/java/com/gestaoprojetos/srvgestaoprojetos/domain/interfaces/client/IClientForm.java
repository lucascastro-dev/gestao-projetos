package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client;

import java.util.List;

public interface IClientForm extends IClient {
    List<Long> getProjects();

    void setProjects(List<Long> projects);
}
