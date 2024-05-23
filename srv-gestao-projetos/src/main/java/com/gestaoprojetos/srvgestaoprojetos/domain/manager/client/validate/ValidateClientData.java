package com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.validate;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.DuplicateDataBaseException;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateClientData implements ITask<IClientForm> {

    private final IClientService<IClientForm> clientService;

    @Autowired
    public ValidateClientData(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void runTask(IClientForm param) {
        if (Util.isNullOrEmpty(param.getIdClient())) {
            IClientEntity clientEntity = clientService.findByNameClient(param.getName());

            DuplicateDataBaseException.isCondition(
                    clientEntity != null && clientEntity.getName().equals(param.getName()),
                    Constants.DUPLICATE_CLIENT
            );
        }
    }
}
