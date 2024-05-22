package com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.validate;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.domain.service.project.ProjectService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateProjectClient implements ITask<IClientForm> {

    private final IProjectService<IProjectForm> projectService;

    @Autowired
    public ValidateProjectClient(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public void runTask(IClientForm param) {
        if (!Util.isNullOrEmpty(param.getProjects())) {

            ObjectNotFoundException.isCondition(Util.isNullOrEmpty(
                            param.getProjects().stream().map(
                                    id -> projectService.findProjectById(id)
                            )),
                    String.format(Constants.PROJECT_NOT_FOUND, param.getProjects()));
        }
    }
}
