package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.task.TaskSaveProject;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation.ValidateClientInProject;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation.ValidateDateProject;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation.ValidateIdProject;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation.ValidateProjectData;
import com.gestaoprojetos.srvgestaoprojetos.infra.handler.AbstractHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateOrUpdateProjectManager extends AbstractHandler<IProjectForm>
        implements IProjectManager<IProjectForm> {
    protected CreateOrUpdateProjectManager(ApplicationContext applicationContext) {
        super(applicationContext);

        setTasks(
                List.of(
                        ValidateIdProject.class,
                        ValidateProjectData.class,
                        ValidateDateProject.class,
                        ValidateClientInProject.class,
                        TaskSaveProject.class
                )
        );
    }

    @Override
    public void runRequest(IProjectForm param) {
        process(param);
    }
}
