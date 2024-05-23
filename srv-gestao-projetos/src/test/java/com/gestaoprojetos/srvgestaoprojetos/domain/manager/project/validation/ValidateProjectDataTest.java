package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.form.ProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.DuplicateDataBaseException;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.project.ProjectService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ValidateProjectDataTest {

    @InjectMocks
    private ValidateProjectData validateProjectData;
    @Mock
    private ProjectService projectService;

    private IProjectForm projectForm;
    private IProjectEntity projectEntity;

    @BeforeEach
    void init() {
        projectForm = Instancio.of(ProjectForm.class).create();
    }

    @Test
    void whenValidateDataProjectShouldNotThrowException() {
        projectForm.setIdProject(null);
        projectEntity = Instancio.of(ProjectEntity.class).create();
        when(projectService.findByNameProject(projectForm.getName())).thenReturn(projectEntity);

        assertDoesNotThrow(() -> validateProjectData.runTask(projectForm));

        verify(projectService, times(1)).findByNameProject(projectForm.getName());
    }

    @Test
    void whenValidateDataProjectShouldThrowException() {
        projectForm.setIdProject(null);
        projectEntity = Instancio.of(ProjectEntity.class).set(field(ProjectEntity::getName), projectForm.getName()).create();
        when(projectService.findByNameProject(projectForm.getName())).thenReturn(projectEntity);

        var error = Assertions.assertThrows(DuplicateDataBaseException.class, () -> validateProjectData.runTask(projectForm));

        Assertions.assertEquals("Projeto já cadastrado", error.getMessage());
    }
}
