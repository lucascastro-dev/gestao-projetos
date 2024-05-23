package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.client.ClientService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateClientInProject implements ITask<IProjectForm> {

    private final IClientService<IClientForm> clientService;

    @Autowired
    public ValidateClientInProject(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void runTask(IProjectForm param) {
        ObjectNotFoundException.isCondition(Util.isNullOrEmpty(
                        clientService.findClientById(param.getIdClient())),
                String.format(Constants.CLIENT_NOT_FOUND, param.getIdClient()));
    }
}

