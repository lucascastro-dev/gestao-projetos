package com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.validate;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.form.ClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
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
public class ValidateIdClientTest {
    @InjectMocks
    private ValidateIdClient validateIdClient;
    @Mock
    private ClientService clientService;

    private IClientForm clientForm;
    private IClientEntity clientEntity;

    @BeforeEach
    void init() {
        clientForm = Instancio.of(ClientForm.class).create();
    }

    @Test
    void whenValidateIdActivityShouldNotThrowException() {
        clientEntity = Instancio.of(ClientEntity.class).create();
        when(clientService.findClientById(anyLong())).thenReturn(clientEntity);

        assertDoesNotThrow(() -> validateIdClient.runTask(clientForm));

        verify(clientService, times(1)).findClientById(anyLong());
    }

    @Test
    void whenActivityIsActiveShouldThrowException() {
        var error = Assertions.assertThrows(ObjectNotFoundException.class, () -> validateIdClient.runTask(clientForm));

        Assertions.assertEquals("Cliente não encontrado", error.getMessage());
    }
}
