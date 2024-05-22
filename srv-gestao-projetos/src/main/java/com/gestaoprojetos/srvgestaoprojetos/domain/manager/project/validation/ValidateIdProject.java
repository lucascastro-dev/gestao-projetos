package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.domain.service.project.ProjectService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateIdProject implements ITask<IProjectForm> {

    private final IProjectService<IProjectForm> projectService;

    @Autowired
    public ValidateIdProject(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public void runTask(IProjectForm param) {

        if (!Util.isNullOrEmpty(param.getIdProject())) {
            ObjectNotFoundException.isCondition(Util.isNullOrEmpty(projectService.findProjectById(param.getIdProject())),
                    String.format(Constants.PROJECT_NOT_FOUND, param.getIdProject()));
        }
    }
}
