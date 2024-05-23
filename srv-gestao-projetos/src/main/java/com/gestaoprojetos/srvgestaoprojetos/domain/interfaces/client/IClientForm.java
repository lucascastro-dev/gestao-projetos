package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client;

import java.util.Set;

public interface IClientForm extends IClient {
    Set<Long> getProjects();

    void setProjects(Set<Long> projects);
}
