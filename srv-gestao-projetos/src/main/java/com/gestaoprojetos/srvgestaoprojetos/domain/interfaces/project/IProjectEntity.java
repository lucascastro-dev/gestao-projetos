package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ClientEntity;

import java.util.Set;

public interface IProjectEntity extends IProject {
    ClientEntity getClient();

    void setClient(ClientEntity client);
}
