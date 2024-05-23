package com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.check;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.ClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.project.ProjectService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CheckProjectAtiveInClientTest {

    @InjectMocks
    private CheckProjectAtiveInClient checkProjectAtiveInClient;
    @Mock
    private ProjectService projectService;
    private IClientForm clientForm;

    @Test
    void whenActivityIsActiveShouldNotThrowException() {
        clientForm = Instancio.of(ClientForm.class).create();
        when(projectService.findProjectByClient(anyLong())).thenReturn(anyList());

        assertDoesNotThrow(() -> checkProjectAtiveInClient.runTask(clientForm));

        verify(projectService, times(1)).findProjectByClient(anyLong());
    }
}
