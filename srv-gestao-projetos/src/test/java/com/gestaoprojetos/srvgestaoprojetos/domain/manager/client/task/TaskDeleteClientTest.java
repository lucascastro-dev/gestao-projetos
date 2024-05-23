package com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.task;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.ClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.client.ClientService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TaskDeleteClientTest {

    @InjectMocks
    private TaskDeleteClient taskDeleteClient;
    @Mock
    private ClientService clientService;
    private IClientForm clientForm;

    @Test
    void shouldSaveClient() {
        clientForm = Instancio.of(ClientForm.class).create();

        taskDeleteClient.runTask(clientForm);

        verify(clientService, times(1)).delete(anyLong());
    }
}
