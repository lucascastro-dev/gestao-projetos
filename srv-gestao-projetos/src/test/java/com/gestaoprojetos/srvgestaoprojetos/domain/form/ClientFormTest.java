package com.gestaoprojetos.srvgestaoprojetos.domain.form;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientFormTest {
    @Test
    void testNoArgsConstructor() {
        ClientForm clientForm = new ClientForm();

        clientForm.setIdClient(1L);
        clientForm.setName("John Doe");
        clientForm.setEmail("john.doe@example.com");
        clientForm.setPhone("1234567890");

        assertEquals(1L, clientForm.getIdClient());
        assertEquals("John Doe", clientForm.getName());
        assertEquals("john.doe@example.com", clientForm.getEmail());
        assertEquals("1234567890", clientForm.getPhone());
    }

    @Test
    void testAllArgsConstructor() {
        ClientForm clientForm = new ClientForm(1L, "John Doe", "john.doe@example.com", "1234567890");

        assertEquals(1L, clientForm.getIdClient());
        assertEquals("John Doe", clientForm.getName());
        assertEquals("john.doe@example.com", clientForm.getEmail());
        assertEquals("1234567890", clientForm.getPhone());
    }

    @Test
    void testBuilder() {
        ClientForm clientForm = ClientForm.builder()
                .idClient(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .phone("1234567890")
                .build();

        assertEquals(1L, clientForm.getIdClient());
        assertEquals("John Doe", clientForm.getName());
        assertEquals("john.doe@example.com", clientForm.getEmail());
        assertEquals("1234567890", clientForm.getPhone());
    }
}
