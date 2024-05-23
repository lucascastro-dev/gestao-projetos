package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.form.ClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.form.ProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.project.ProjectService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {FindProjectManager.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FindProjectManagerTest {
    @Autowired
    private FindProjectManager find;
    @MockBean
    private ProjectService projectService;
    private IProjectForm projectForm;
    private IProjectEntity projectEntity;

    @Test
    void shouldFindAll() {
        Assertions.assertNotNull(find.all());
    }

    @Test
    void shouldFindById() {
        projectEntity = Instancio.of(ProjectEntity.class).create();
        projectForm = Instancio.of(ProjectForm.class).create();
        when(projectService.findProjectById(anyLong())).thenReturn(projectEntity);

        Assertions.assertNotNull(find.get(projectForm));
    }
}