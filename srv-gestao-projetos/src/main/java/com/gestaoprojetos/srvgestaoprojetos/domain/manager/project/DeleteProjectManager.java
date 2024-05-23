package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.check.CheckProjectIsAtive;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.task.TaskDeleteProject;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation.ValidateIdProject;
import com.gestaoprojetos.srvgestaoprojetos.infra.handler.AbstractHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteProjectManager extends AbstractHandler<IProjectForm>
        implements IProjectManager<IProjectForm> {
    protected DeleteProjectManager(ApplicationContext applicationContext) {
        super(applicationContext);

        setTasks(
                List.of(
                        ValidateIdProject.class,
                        CheckProjectIsAtive.class,
                        TaskDeleteProject.class
                )
        );
    }

    @Override
    public void runRequest(IProjectForm param) {
        process(param);
    }
}
