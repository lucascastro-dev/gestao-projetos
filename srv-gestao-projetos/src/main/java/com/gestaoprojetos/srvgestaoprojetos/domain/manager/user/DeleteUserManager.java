package com.gestaoprojetos.srvgestaoprojetos.domain.manager.user;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.check.CheckActiveUserActivities;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.task.TaskDeleteUser;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.validation.ValidateIdUser;
import com.gestaoprojetos.srvgestaoprojetos.infra.handler.AbstractHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteUserManager extends AbstractHandler<IUserForm>
        implements IUserManager<IUserForm> {
    protected DeleteUserManager(ApplicationContext applicationContext) {
        super(applicationContext);

        setTasks(
                List.of(
                        ValidateIdUser.class,
                        //TODO: AJUSTAR APÓS CRIAR OS SERVIÇOS DE ATIVIDADES
                        CheckActiveUserActivities.class,
                        TaskDeleteUser.class
                )
        );
    }

    @Override
    public void runRequest(IUserForm param) {
        process(param);
    }
}
