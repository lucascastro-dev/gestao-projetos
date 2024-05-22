package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.task.TaskSaveActivity;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation.ValidateDateActivity;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation.ValidateIdActivity;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation.ValidateProject;
import com.gestaoprojetos.srvgestaoprojetos.infra.handler.AbstractHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateOrUpdateActivityManager extends AbstractHandler<IActivityForm>
        implements IActivityManager<IActivityForm> {
    protected CreateOrUpdateActivityManager(ApplicationContext applicationContext) {
        super(applicationContext);

        setTasks(
                List.of(
                        ValidateIdActivity.class,
                        ValidateProject.class,
                        ValidateDateActivity.class,
                        TaskSaveActivity.class
                )
        );
    }

    @Override
    public void runRequest(IActivityForm param) {
        process(param);
    }
}
