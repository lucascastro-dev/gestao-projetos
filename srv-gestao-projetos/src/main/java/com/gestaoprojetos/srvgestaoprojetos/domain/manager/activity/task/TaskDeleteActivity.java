package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.task;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.activity.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskDeleteActivity implements ITask<IActivityForm> {

    private final IActivityService<IActivityForm> activityService;

    @Autowired
    public TaskDeleteActivity(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Override
    public void runTask(IActivityForm param) {
        activityService.delete(param.getIdActivity());
    }
}
