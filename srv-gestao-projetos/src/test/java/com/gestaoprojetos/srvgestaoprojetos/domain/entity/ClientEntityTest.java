package com.gestaoprojetos.srvgestaoprojetos.domain.entity;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientEntityTest {
    @Test
    void testNoArgsConstructor() {
        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setIdClient(1L);
        clientEntity.setName("John Doe");
        clientEntity.setEmail("john.doe@example.com");
        clientEntity.setPhone("1234567890");

        assertEquals(1L, clientEntity.getIdClient());
        assertEquals("John Doe", clientEntity.getName());
        assertEquals("john.doe@example.com", clientEntity.getEmail());
        assertEquals("1234567890", clientEntity.getPhone());
    }

    @Test
    void testAllArgsConstructor() {
        IClientForm clientForm = mock(IClientForm.class);

        when(clientForm.getIdClient()).thenReturn(1L);
        when(clientForm.getName()).thenReturn("John Doe");
        when(clientForm.getEmail()).thenReturn("john.doe@example.com");
        when(clientForm.getPhone()).thenReturn("1234567890");

        ClientEntity clientEntity = new ClientEntity(clientForm);

        assertEquals(1L, clientEntity.getIdClient());
        assertEquals("John Doe", clientEntity.getName());
        assertEquals("john.doe@example.com", clientEntity.getEmail());
        assertEquals("1234567890", clientEntity.getPhone());
    }
}
