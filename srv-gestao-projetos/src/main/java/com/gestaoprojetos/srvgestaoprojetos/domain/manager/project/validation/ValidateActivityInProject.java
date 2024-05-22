package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.domain.service.activity.ActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateActivityInProject implements ITask<IProjectForm> {

    private final IActivityService<IActivityForm> activityService;

    @Autowired
    public ValidateActivityInProject(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Override
    public void runTask(IProjectForm param) {
        if (!Util.isNullOrEmpty(param.getIdsActivity())) {

            ObjectNotFoundException.isCondition(Util.isNullOrEmpty(
                            param.getIdsActivity().stream().map(
                                    id -> activityService.findActivityById(id)
                            )),
                    String.format(Constants.ACTIVITY_NOT_FOUND, param.getIdsActivity()));
        }
    }
}
