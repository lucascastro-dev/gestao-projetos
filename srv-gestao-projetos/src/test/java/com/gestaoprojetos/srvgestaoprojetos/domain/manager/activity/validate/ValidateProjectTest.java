package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validate;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.form.ActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation.ValidateProject;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.ObjectNotFoundException;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.project.ProjectService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ValidateProjectTest {

    @InjectMocks
    private ValidateProject validateProject;
    @Mock
    private ProjectService projectService;

    private IActivityForm activityForm;

    private IProjectEntity projectEntity;

    @BeforeEach
    void init() {
        activityForm = Instancio.of(ActivityForm.class).create();
    }

    @Test
    void whenValidateIdActivityShouldNotThrowException() {
        projectEntity = Instancio.of(ProjectEntity.class).create();
        when(projectService.findProjectById(anyLong())).thenReturn(projectEntity);

        assertDoesNotThrow(() -> validateProject.runTask(activityForm));

        verify(projectService, times(1)).findProjectById(anyLong());
    }

    @Test
    void whenValidateProjectShouldThrowException() {
        var error = Assertions.assertThrows(ObjectNotFoundException.class, () -> validateProject.runTask(activityForm));

        Assertions.assertEquals("Projeto não encontrado", error.getMessage());
    }
}
