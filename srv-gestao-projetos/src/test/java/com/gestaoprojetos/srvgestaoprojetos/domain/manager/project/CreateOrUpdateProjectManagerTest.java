package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.ProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.task.TaskSaveProject;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation.ValidateClientInProject;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation.ValidateDateProject;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation.ValidateIdProject;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation.ValidateProjectData;
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

@ContextConfiguration(classes = {CreateOrUpdateProjectManager.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CreateOrUpdateProjectManagerTest {

    @Autowired
    private CreateOrUpdateProjectManager createOrUpdateProjectManager;
    @MockBean
    private ValidateIdProject validateIdProject;
    @MockBean
    private ValidateProjectData validateProjectData;
    @MockBean
    private ValidateDateProject validateDateProject;
    @MockBean
    private ValidateClientInProject validateClientInProject;
    @MockBean
    private TaskSaveProject taskSaveProject;

    private IProjectForm projectForm;

    @Test
    void shouldCreateProject() {
        projectForm = Instancio.of(ProjectForm.class).create();

        createOrUpdateProjectManager.runRequest(projectForm);

        verify(validateIdProject, times(1)).runTask(projectForm);
        verify(validateProjectData, times(1)).runTask(projectForm);
        verify(validateDateProject, times(1)).runTask(projectForm);
        verify(validateClientInProject, times(1)).runTask(projectForm);
        verify(taskSaveProject, times(1)).runTask(projectForm);
    }
}
