package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.activity.ActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateIdActivity implements ITask<IActivityForm> {

    private final IActivityService<IActivityForm> activityService;

    @Autowired
    public ValidateIdActivity(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Override
    public void runTask(IActivityForm param) {
        if (!Util.isNullOrEmpty(param.getIdActivity())) {
            ObjectNotFoundException.isCondition(Util.isNullOrEmpty(activityService.findActivityById(param.getIdActivity())),
                    String.format(Constants.ACTIVITY_NOT_FOUND, param.getIdActivity()));
        }
    }
}
