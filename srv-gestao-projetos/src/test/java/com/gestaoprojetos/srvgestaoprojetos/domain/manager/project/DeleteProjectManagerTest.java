package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.ProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.check.CheckActivityInProject;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.check.CheckProjectIsAtive;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.task.TaskDeleteProject;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation.ValidateIdProject;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ContextConfiguration(classes = {DeleteProjectManager.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DeleteProjectManagerTest {

    @Autowired
    private DeleteProjectManager deleteProjectManager;
    @MockBean
    private ValidateIdProject validateIdProject;
    @MockBean
    private CheckProjectIsAtive checkProjectIsAtive;
    @MockBean
    private CheckActivityInProject checkActivityInProject;
    @MockBean
    private TaskDeleteProject taskDeleteProject;

    private IProjectForm projectForm;

    @Test
    void shouldDeleteProject() {
        projectForm = Instancio.of(ProjectForm.class).create();

        deleteProjectManager.runRequest(projectForm);

        verify(validateIdProject, times(1)).runTask(projectForm);
        verify(checkProjectIsAtive, times(1)).runTask(projectForm);
        verify(checkActivityInProject, times(1)).runTask(projectForm);
        verify(taskDeleteProject, times(1)).runTask(projectForm);
    }
}

