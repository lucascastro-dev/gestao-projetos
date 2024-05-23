package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.check;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.InvalidDataException;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.activity.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckActivityInProject implements ITask<IProjectForm> {

    private final IActivityService<IActivityForm> activityService;

    @Autowired
    public CheckActivityInProject(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Override
    public void runTask(IProjectForm param) {
        IActivityEntity activityEntity = activityService.findByProjects(
                ProjectEntity.builder().idProject(param.getIdProject()).build()
        );

        InvalidDataException.isCondition(!Util.isNullOrEmpty(activityEntity.getProjects())
                , Constants.CLIENT_PROJECT_IS_BROCKER);
    }
}
