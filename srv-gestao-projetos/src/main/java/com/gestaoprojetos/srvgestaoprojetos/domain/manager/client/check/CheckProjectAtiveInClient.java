package com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.check;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.domain.service.project.ProjectService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckProjectAtiveInClient implements ITask<IClientForm> {

    private final IProjectService<IProjectForm> projectService;

    @Autowired
    public CheckProjectAtiveInClient(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public void runTask(IClientForm param) {
        InvalidDataException.isCondition(!Util.isNullOrEmpty(param.getProjects().stream().map(
                idActivity -> projectService.findProjectById(idActivity))
        ), Constants.PROJECT_IS_ATIVE);
    }
}
