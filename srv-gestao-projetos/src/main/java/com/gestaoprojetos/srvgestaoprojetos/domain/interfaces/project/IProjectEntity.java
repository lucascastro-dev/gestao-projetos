package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ClientEntity;

import java.util.List;

public interface IProjectEntity extends IProject {
    ClientEntity getClient();

    List<ActivityEntity> getActivity();

    void setClient(ClientEntity client);

    void setActivity(List<ActivityEntity> activity);
}
