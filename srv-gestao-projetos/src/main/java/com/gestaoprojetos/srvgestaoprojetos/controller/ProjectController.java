package com.gestaoprojetos.srvgestaoprojetos.controller;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.ProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IFindProjectManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.CreateOrUpdateProjectManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.DeleteProjectManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.FindProjectManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Projetos",
        description = "Endpoint responsável pela manutenção dos projetos")
@RestController
@RequestMapping("/project")
public class ProjectController {
    private final IProjectManager<IProjectForm> createOrUpdate;
    private final IProjectManager<IProjectForm> delete;
    private final IFindProjectManager<IProjectDto, IProjectForm> find;

    @Autowired
    public ProjectController(CreateOrUpdateProjectManager createOrUpdate,
                             DeleteProjectManager delete,
                             FindProjectManager find) {
        this.createOrUpdate = createOrUpdate;
        this.delete = delete;
        this.find = find;
    }

    @PostMapping()
    @Operation(summary = "Criar um novo projeto")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProjectForm projectForm) {
        createOrUpdate.runRequest(projectForm);
    }

    @PutMapping()
    @Operation(summary = "Atualizar um projeto")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody ProjectForm projectForm) {
        createOrUpdate.runRequest(projectForm);
    }

    @DeleteMapping(value = "/{idProject}")
    @Operation(summary = "Deletar um projeto")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long idProject) {
        delete.runRequest(ProjectForm.builder().idProject(idProject).build());
    }

    @GetMapping
    @Operation(summary = "Buscar todos os projetos")
    @ResponseStatus(HttpStatus.OK)
    public List<IProjectDto> findAll() {
        return find.all();
    }

    @GetMapping(value = "/{idProject}")
    @Operation(summary = "Buscar um projeto pelo ID")
    @ResponseStatus(HttpStatus.OK)
    public IProjectDto findById(@PathVariable Long idProject) {
        return find.get(ProjectForm.builder().idProject(idProject).build());
    }
}
