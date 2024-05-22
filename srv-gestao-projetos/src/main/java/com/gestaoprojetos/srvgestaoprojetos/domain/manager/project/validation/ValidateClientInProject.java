package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import org.springframework.stereotype.Service;

@Service
public class ValidateClientInProject implements ITask<IProjectForm> {
    @Override
    public void runTask(IProjectForm param) {

    }
}
