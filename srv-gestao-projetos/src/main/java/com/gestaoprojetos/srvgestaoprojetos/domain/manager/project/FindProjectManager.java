package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.dto.ProjectDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IFindProjectManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectService;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.project.ProjectService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindProjectManager implements IFindProjectManager<IProjectDto, IProjectForm> {

    private final IProjectService<IProjectForm> projectService;

    @Autowired
    public FindProjectManager(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public List<IProjectDto> all() {
        return projectService.findAllProject().stream().map(ProjectDto::new).collect(Collectors.toList());
    }

    @Override
    public IProjectDto get(IProjectForm param) {
        IProjectEntity projectEntity = projectService.findProjectById(param.getIdProject());
        ObjectNotFoundException.isCondition(Util.isNullOrEmpty(projectEntity), Constants.PROJECT_NOT_FOUND);

        return new ProjectDto(projectEntity);
    }
}
