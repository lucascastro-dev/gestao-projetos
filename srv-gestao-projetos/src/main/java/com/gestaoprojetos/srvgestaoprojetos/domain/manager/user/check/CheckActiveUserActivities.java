package com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.check;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.domain.service.activity.ActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckActiveUserActivities implements ITask<IUserForm> {

    private final IActivityService<IActivityForm> activityService;

    @Autowired
    public CheckActiveUserActivities(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Override
    public void runTask(IUserForm param) {
        if (!Util.isNullOrEmpty(param.getActivity())) {
            param.getActivity().forEach(
                    activity -> InvalidDataException.isCondition(
                            activityService.findActivityById(activity).getStatus().equals(Boolean.TRUE),
                            Constants.ACTIVITY_DEPENDENCY_TRUE)
            );
        }
    }
}
