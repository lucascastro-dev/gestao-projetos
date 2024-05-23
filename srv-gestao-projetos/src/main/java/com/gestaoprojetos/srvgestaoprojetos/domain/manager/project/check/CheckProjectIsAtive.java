package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.check;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.InvalidDataException;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckProjectIsAtive implements ITask<IProjectForm> {

    private final IProjectService<IProjectForm> projectService;

    @Autowired
    public CheckProjectIsAtive(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public void runTask(IProjectForm param) {
        IProjectEntity projectEntity = projectService.findProjectById(param.getIdProject());

        InvalidDataException.isCondition(projectEntity.getStatus(), Constants.PROJECT_IS_ATIVE);
    }
}
