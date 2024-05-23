package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.project.ProjectService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateProject implements ITask<IActivityForm> {

    private final IProjectService<IProjectForm> projectService;

    @Autowired
    public ValidateProject(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public void runTask(IActivityForm param) {
        ObjectNotFoundException.isCondition(Util.isNullOrEmpty(
                        projectService.findProjectById(param.getIdProjects())),
                String.format(Constants.PROJECT_NOT_FOUND, param.getIdProjects()));
    }
}
