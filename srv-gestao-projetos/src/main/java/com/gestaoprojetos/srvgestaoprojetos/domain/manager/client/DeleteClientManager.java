package com.gestaoprojetos.srvgestaoprojetos.domain.manager.client;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.check.CheckProjectAtiveInClient;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.task.TaskDeleteClient;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.validate.ValidateIdClient;
import com.gestaoprojetos.srvgestaoprojetos.infra.handler.AbstractHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteClientManager extends AbstractHandler<IClientForm>
        implements IClientManager<IClientForm> {
    protected DeleteClientManager(ApplicationContext applicationContext) {
        super(applicationContext);

        setTasks(
                List.of(
                        ValidateIdClient.class,
                        CheckProjectAtiveInClient.class,
                        TaskDeleteClient.class
                )
        );
    }

    @Override
    public void runRequest(IClientForm param) {
        process(param);
    }
}