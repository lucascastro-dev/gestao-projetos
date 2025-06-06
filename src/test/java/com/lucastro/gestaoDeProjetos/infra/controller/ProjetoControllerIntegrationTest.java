package com.lucastro.gestaoDeProjetos.infra.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucastro.gestaoDeProjetos.application.form.ProjetoForm;
import com.lucastro.gestaoDeProjetos.application.record.ProjetoRecord;
import com.lucastro.gestaoDeProjetos.application.service.ProjetoService;
import jakarta.transaction.Transactional;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class ProjetoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProjetoService projetoService;

    @Test
    void testCriarProjeto() throws Exception {
        List<String> cpfFuncionarios = new ArrayList<>();
        cpfFuncionarios.add("12345678901");
        ProjetoForm projeto = Instancio.of(ProjetoForm.class)
                .set(field(ProjetoForm::getNomeProjeto), "Projeto Teste")
                .set(field(ProjetoForm::getCpfFuncionario), cpfFuncionarios)
                .create();

        mockMvc.perform(post("/projetos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(projeto)))
                .andExpect(status().isCreated());

        List<ProjetoRecord> projetos = projetoService.buscarTodos();
        assertEquals(1, projetos.size());
        assertEquals("Projeto Teste", projetos.getFirst().nome());
    }

    @Test
    void testBuscarTodosProjetos() throws Exception {
        ProjetoForm projeto1 = Instancio.of(ProjetoForm.class)
                .set(field(ProjetoForm::getNomeProjeto), "Projeto Teste 1")
                .create();

        projetoService.criar(projeto1);

        mockMvc.perform(get("/projetos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Projeto Teste 1"));
    }
}