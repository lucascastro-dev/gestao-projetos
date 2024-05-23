package com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.validate;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.form.ClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.DuplicateDataBaseException;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.client.ClientService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ValidateClientDataTest {

    @InjectMocks
    private ValidateClientData validateClientData;
    @Mock
    private ClientService clientService;

    private IClientForm clientForm;
    private IClientEntity clientEntity;

    @BeforeEach
    void init() {
        clientForm = Instancio.of(ClientForm.class).create();
    }

    @Test
    void whenValidateDataClientShouldNotThrowException() {
        clientForm.setIdClient(null);
        clientEntity = Instancio.of(ClientEntity.class).create();
        when(clientService.findByNameClient(clientForm.getName())).thenReturn(clientEntity);

        assertDoesNotThrow(() -> validateClientData.runTask(clientForm));

        verify(clientService, times(1)).findByNameClient(clientForm.getName());
    }

    @Test
    void whenValidateDataClientShouldThrowException() {
        clientForm.setIdClient(null);
        clientEntity = Instancio.of(ClientEntity.class).set(field(ClientEntity::getName), clientForm.getName()).create();
        when(clientService.findByNameClient(clientForm.getName())).thenReturn(clientEntity);

        var error = Assertions.assertThrows(DuplicateDataBaseException.class, () -> validateClientData.runTask(clientForm));

        Assertions.assertEquals("Cliente já cadastrado", error.getMessage());
    }
}
