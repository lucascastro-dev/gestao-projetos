package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.task;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskDeleteProject implements ITask<IProjectForm> {

    private final IProjectService<IProjectForm> projectService;

    @Autowired
    public TaskDeleteProject(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public void runTask(IProjectForm param) {
        projectService.delete(param.getIdProject());
    }
}
