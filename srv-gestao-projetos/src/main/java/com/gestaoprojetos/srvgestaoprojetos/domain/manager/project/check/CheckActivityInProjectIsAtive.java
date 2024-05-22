package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.check;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.domain.service.activity.ActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckActivityInProjectIsAtive implements ITask<IProjectForm> {

    private final IActivityService<IActivityForm> activityService;

    @Autowired
    public CheckActivityInProjectIsAtive(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Override
    public void runTask(IProjectForm param) {
        InvalidDataException.isCondition(!Util.isNullOrEmpty(param.getIdsActivity().stream().map(
                idActivity -> activityService.findActivityById(idActivity))
        ), Constants.PROJECT_IS_ATIVE);
    }
}
