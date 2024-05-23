package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.check;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.form.ProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.InvalidDataException;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CheckProjectIsAtiveTest {

    @InjectMocks
    private CheckProjectIsAtive checkProjectIsAtive;
    @Mock
    private ProjectService projectService;

    private IProjectForm projectForm;
    private IProjectEntity projectEntity;

    @BeforeEach
    void init() {
        projectForm = Instancio.of(ProjectForm.class).create();
        projectEntity = Instancio.of(ProjectEntity.class).create();
        when(projectService.findProjectById(anyLong())).thenReturn(projectEntity);
    }

    @Test
    void whenCheckProjectIsAtiveShouldNotThrowException() {
        projectEntity.setStatus(false);

        assertDoesNotThrow(() -> checkProjectIsAtive.runTask(projectForm));

        verify(projectService, times(1)).findProjectById(any());
    }

    @Test
    void whenCheckProjectIsAtiveShouldThrowException() {
        projectEntity.setStatus(true);

        var error = Assertions.assertThrows(InvalidDataException.class, () -> checkProjectIsAtive.runTask(projectForm));

        Assertions.assertEquals("Não é possível deletar projeto quando ativo", error.getMessage());

    }
}
