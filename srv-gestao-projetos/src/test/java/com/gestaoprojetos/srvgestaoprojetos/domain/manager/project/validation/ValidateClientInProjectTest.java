package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.form.ProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.ObjectNotFoundException;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.client.ClientService;
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
public class ValidateClientInProjectTest {
    @InjectMocks
    private ValidateClientInProject validateClientInProject;
    @Mock
    private ClientService clientService;
    private IProjectForm projectForm;
    private IProjectEntity projectEntity;
    private IClientEntity clientEntity;

    @BeforeEach
    void init() {
        projectForm = Instancio.of(ProjectForm.class).create();
    }

    @Test
    void whenValidateClientInProjectShouldNotThrowException() {
        projectEntity = Instancio.of(ProjectEntity.class).create();
        clientEntity = Instancio.of(ClientEntity.class).create();
        when(clientService.findClientById(anyLong())).thenReturn(clientEntity);

        assertDoesNotThrow(() -> validateClientInProject.runTask(projectForm));

        verify(clientService, times(1)).findClientById(anyLong());
    }

    @Test
    void whenValidateClientInProjectShouldThrowException() {
        var error = Assertions.assertThrows(ObjectNotFoundException.class, () -> validateClientInProject.runTask(projectForm));

        Assertions.assertEquals("Cliente não encontrado", error.getMessage());
    }
}
