package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project;

import com.gestaoprojetos.srvgestaoprojetos.domain.dto.ClientDto;

public interface IProjectDto extends IProject {
    ClientDto getClient();

    void setClient(ClientDto client);

}
