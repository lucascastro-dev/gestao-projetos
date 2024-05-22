package com.gestaoprojetos.srvgestaoprojetos.domain.manager.client;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.task.TaskSaveClient;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.validate.ValidateClientData;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.validate.ValidateIdClient;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.validate.ValidateProjectClient;
import com.gestaoprojetos.srvgestaoprojetos.infra.handler.AbstractHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateOrUpdateClientManager extends AbstractHandler<IClientForm>
        implements IClientManager<IClientForm> {

    protected CreateOrUpdateClientManager(ApplicationContext applicationContext) {
        super(applicationContext);

        setTasks(List.of(
                ValidateIdClient.class,
                ValidateClientData.class,
                ValidateProjectClient.class,
                TaskSaveClient.class
        ));
    }

    @Override
    public void runRequest(IClientForm param) {
        process(param);
    }
}