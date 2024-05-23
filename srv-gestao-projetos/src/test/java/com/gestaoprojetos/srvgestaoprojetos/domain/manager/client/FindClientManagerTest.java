package com.gestaoprojetos.srvgestaoprojetos.domain.manager.client;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.form.ClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.client.ClientService;
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

@ContextConfiguration(classes = {FindClientManager.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FindClientManagerTest {

    @Autowired
    private FindClientManager find;
    @MockBean
    private ClientService clientService;
    private IClientForm clientForm;
    private IClientEntity clientEntity;

    @Test
    void shouldFindAll() {
        Assertions.assertNotNull(find.all());
    }

    @Test
    void shouldFindById() {
        clientEntity = Instancio.of(ClientEntity.class).create();
        clientForm = Instancio.of(ClientForm.class).create();
        when(clientService.findClientById(anyLong())).thenReturn(clientEntity);

        Assertions.assertNotNull(find.get(clientForm));
    }
}