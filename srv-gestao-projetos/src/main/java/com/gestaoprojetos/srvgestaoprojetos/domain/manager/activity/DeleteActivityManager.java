package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.check.CheckProjectLinkedActivity;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.task.TaskDeleteActivity;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation.ValidateIdActivity;
import com.gestaoprojetos.srvgestaoprojetos.infra.handler.AbstractHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteActivityManager extends AbstractHandler<IActivityForm>
        implements IActivityManager<IActivityForm> {
    protected DeleteActivityManager(ApplicationContext applicationContext) {
        super(applicationContext);

        setTasks(
                List.of(
                        ValidateIdActivity.class,
                        //TODO: IMPLEMENTAR APÓS CRIAÇÃO DOS SERVIÇOS DE PROJETOS
                        CheckProjectLinkedActivity.class,
                        TaskDeleteActivity.class
                )
        );
    }

    @Override
    public void runRequest(IActivityForm param) {
        process(param);
    }
}
