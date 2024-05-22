package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.domain.service.project.ProjectService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.DuplicateDataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateProjectData implements ITask<IProjectForm> {
    private final IProjectService<IProjectForm> projectService;

    @Autowired
    public ValidateProjectData(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public void runTask(IProjectForm param) {
        if (Util.isNullOrEmpty(param.getIdProject())) {
            DuplicateDataBaseException.isCondition(
                    Util.isNullOrEmpty(projectService.findByNameProject(param.getName())), Constants.DUPLICATE_PROJECT);
        }
    }
}
