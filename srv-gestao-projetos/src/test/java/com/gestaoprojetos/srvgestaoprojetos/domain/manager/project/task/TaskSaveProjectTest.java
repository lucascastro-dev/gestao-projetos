package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.task;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.ClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.form.ProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.project.ProjectService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TaskSaveProjectTest {
    @InjectMocks
    private TaskSaveProject taskSaveProject;
    @Mock
    private ProjectService projectService;
    private IProjectForm projectForm;

    @Test
    void shouldSaveProject() {
        projectForm = Instancio.of(ProjectForm.class).create();

        taskSaveProject.runTask(projectForm);

        verify(projectService, times(1)).save(projectForm);
    }
}
