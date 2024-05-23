package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.check;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.form.ProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.InvalidDataException;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.activity.ActivityService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CheckActivityInProjectTest {

    @InjectMocks
    private CheckActivityInProject checkActivityInProject;
    @Mock
    private ActivityService activityService;
    private IProjectForm projectForm;
    private IActivityEntity activityEntity;

    @BeforeEach
    void init() {
        projectForm = Instancio.of(ProjectForm.class).create();
        activityEntity = Instancio.of(ActivityEntity.class).create();
        when(activityService.findByProjects(any())).thenReturn(activityEntity);
    }

    @Test
    void whenCheckActivityInProjectShouldNotThrowException() {
        activityEntity.setProjects(null);

        assertDoesNotThrow(() -> checkActivityInProject.runTask(projectForm));

        verify(activityService, times(1)).findByProjects(any());
    }

    @Test
    void whenCheckActivityInProjectShouldThrowException() {
        var error = Assertions.assertThrows(InvalidDataException.class, () -> checkActivityInProject.runTask(projectForm));

        Assertions.assertEquals("Não é possível deletar cliente com projeto vinculado", error.getMessage());

    }
}
