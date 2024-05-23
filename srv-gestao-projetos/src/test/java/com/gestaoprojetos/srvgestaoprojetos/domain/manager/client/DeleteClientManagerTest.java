package com.gestaoprojetos.srvgestaoprojetos.domain.manager.client;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.ClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.check.CheckProjectAtiveInClient;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.task.TaskDeleteClient;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.task.TaskSaveClient;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.validate.ValidateClientData;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.validate.ValidateIdClient;
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

@ContextConfiguration(classes = {DeleteClientManager.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DeleteClientManagerTest {
    @Autowired
    private DeleteClientManager deleteClientManager;
    @MockBean
    private ValidateIdClient validateIdClient;
    @MockBean
    private CheckProjectAtiveInClient checkProjectAtiveInClient;
    @MockBean
    private TaskDeleteClient taskDeleteClient;

    private IClientForm clientForm;

    @Test
    void shouldDeleteCliente() {
        clientForm = Instancio.of(ClientForm.class).create();

        deleteClientManager.runRequest(clientForm);

        verify(validateIdClient, times(1)).runTask(clientForm);
        verify(checkProjectAtiveInClient, times(1)).runTask(clientForm);
        verify(taskDeleteClient, times(1)).runTask(clientForm);
    }
}