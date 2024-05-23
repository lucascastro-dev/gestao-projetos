package com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.task;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskSaveClient implements ITask<IClientForm> {

    private final IClientService<IClientForm> clientService;

    @Autowired
    public TaskSaveClient(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void runTask(IClientForm param) {
        clientService.save(param);
    }
}
