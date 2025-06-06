package com.lucastro.gestaoDeProjetos.infra.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucastro.gestaoDeProjetos.application.form.FuncionarioForm;
import com.lucastro.gestaoDeProjetos.application.service.FuncionarioService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FuncionarioControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FuncionarioService funcionarioService;

    @Test
    void testCadastrarFuncionario() throws Exception {
        FuncionarioForm funcionario = Instancio.of(FuncionarioForm.class)
                .set(field(FuncionarioForm::getNome), "João Silva")
                .set(field(FuncionarioForm::getEmail), "teste@teste.com")
                .set(field(FuncionarioForm::getCpf), "21564188027")
                .create();

        mockMvc.perform(post("/funcionarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(funcionario)))
                .andExpect(status().isCreated());

        var funcionarios = funcionarioService.buscarTodos();
        assertEquals(1, funcionarios.size());
        assertEquals("João Silva", funcionarios.getFirst().nome());
    }

    @Test
    void testBuscarTodosFuncionarios() throws Exception {
        FuncionarioForm funcionario1 = Instancio.of(FuncionarioForm.class).set(field(FuncionarioForm::getNome), "João Silva").create();
        funcionarioService.cadastrar(funcionario1);

        mockMvc.perform(get("/funcionarios")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("João Silva"));
    }
}
