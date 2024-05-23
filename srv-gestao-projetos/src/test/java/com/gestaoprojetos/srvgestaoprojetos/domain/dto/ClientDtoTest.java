package com.gestaoprojetos.srvgestaoprojetos.domain.dto;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientDtoTest {

    @Test
    void testConstructor() {
        ClientDto clientDto = new ClientDto();
        clientDto.setIdClient(1L);
        clientDto.setName("John Doe");
        clientDto.setEmail("john.doe@example.com");
        clientDto.setPhone("1234567890");

        assertEquals(1L, clientDto.getIdClient());
        assertEquals("John Doe", clientDto.getName());
        assertEquals("john.doe@example.com", clientDto.getEmail());
        assertEquals("1234567890", clientDto.getPhone());
    }

    @Test
    void testAllArgsConstructor() {
        IClientEntity clientEntity = mock(IClientEntity.class);
        when(clientEntity.getIdClient()).thenReturn(1L);
        when(clientEntity.getName()).thenReturn("John Doe");
        when(clientEntity.getEmail()).thenReturn("john.doe@example.com");
        when(clientEntity.getPhone()).thenReturn("1234567890");

        ClientDto clientDto = new ClientDto(clientEntity);

        assertEquals(1L, clientDto.getIdClient());
        assertEquals("John Doe", clientDto.getName());
        assertEquals("john.doe@example.com", clientDto.getEmail());
        assertEquals("1234567890", clientDto.getPhone());
    }
}
