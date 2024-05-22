package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.check;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.domain.service.activity.ActivityService;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckActivityIsAtive implements ITask<IActivityForm> {

    private final IActivityService<IActivityForm> activityService;

    @Autowired
    public CheckActivityIsAtive(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Override
    public void runTask(IActivityForm param) {
        IActivityEntity activityEntity = activityService.findActivityById(param.getIdActivity());

        InvalidDataException.isCondition(!activityEntity.getStatus(), Constants.ACTIVITY_IS_ATIVE);
    }
}
