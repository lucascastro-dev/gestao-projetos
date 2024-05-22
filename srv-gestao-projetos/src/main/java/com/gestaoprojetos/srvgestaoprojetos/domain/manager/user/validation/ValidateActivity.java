package com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.validation;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.domain.service.activity.ActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ValidateActivity implements ITask<IUserForm> {

    private final IActivityService<IActivityForm> activityService;

    public ValidateActivity(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Override
    public void runTask(IUserForm param) {
        if (!Util.isNullOrEmpty(param.getActivity())) {

            boolean allActivitiesExist = param.getActivity().stream()
                    .allMatch(id -> {
                        try {
                            activityService.findActivityById(id);
                            return true;
                        } catch (ObjectNotFoundException e) {
                            return false;
                        }
                    });

            ObjectNotFoundException.isCondition(allActivitiesExist, String.format(Constants.ACTIVITY_NOT_FOUND, param.getIdUser()));
        }
    }
}
