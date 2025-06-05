package com.lucastro.gestaoDeProjetos.infra.controller;

import com.lucastro.gestaoDeProjetos.application.form.ProjetoForm;
import com.lucastro.gestaoDeProjetos.application.record.ProjetoRecord;
import com.lucastro.gestaoDeProjetos.application.service.ProjetoService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProjetoControllerTest {
    @Mock
    ProjetoService projetoService;
    @InjectMocks
    ProjetoController projetoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarProjeto() {
        ProjetoForm projeto = Instancio.of(ProjetoForm.class).create();

        projetoController.criarProjeto(projeto);

        verify(projetoService).criar(any());
    }

    @Test
    void testBuscarTodosProjetos() {
        List<ProjetoRecord> projetos = Instancio.ofList(ProjetoRecord.class).create();
        when(projetoService.buscarTodos()).thenReturn(projetos);

        List<ProjetoRecord> result = projetoController.buscarTodosProjetos();

        Assertions.assertEquals(projetos, result);
    }
}
