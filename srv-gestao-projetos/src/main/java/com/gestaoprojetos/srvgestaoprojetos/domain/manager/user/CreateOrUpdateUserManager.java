package com.gestaoprojetos.srvgestaoprojetos.domain.manager.user;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.task.TaskSaveUser;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.validation.ValidateActivity;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.validation.ValidateIdUser;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.validation.ValidateUserData;
import com.gestaoprojetos.srvgestaoprojetos.infra.handler.AbstractHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateOrUpdateUserManager extends AbstractHandler<IUserForm>
        implements IUserManager<IUserForm> {
    protected CreateOrUpdateUserManager(ApplicationContext applicationContext) {
        super(applicationContext);

        setTasks(
                List.of(
                        ValidateIdUser.class,
                        ValidateUserData.class,
                        ValidateActivity.class,
                        TaskSaveUser.class
                )
        );
    }

    @Override
    public void runRequest(IUserForm param) {
        process(param);
    }
}
