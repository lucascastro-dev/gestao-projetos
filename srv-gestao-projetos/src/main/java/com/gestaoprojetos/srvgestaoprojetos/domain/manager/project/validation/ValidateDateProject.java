package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.gestaoprojetos.srvgestaoprojetos.domain.util.Util.validateFromEndValidityDate;
import static com.gestaoprojetos.srvgestaoprojetos.domain.util.Util.validateFromStartValidityDate;

@Service
public class ValidateDateProject implements ITask<IProjectForm> {
    private final IProjectService<IProjectForm> projectService;

    @Autowired
    public ValidateDateProject(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public void runTask(IProjectForm param) {
        validateDate(param.getStartDate(), param.getEndDate());
    }

    private void validateDate(LocalDate startDate, LocalDate endDate) {
        validateFromStartValidityDate(startDate);
        validateFromEndValidityDate(startDate, endDate);
    }
}