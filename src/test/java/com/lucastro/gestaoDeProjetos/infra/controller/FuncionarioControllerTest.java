package com.lucastro.gestaoDeProjetos.infra.controller;

import com.lucastro.gestaoDeProjetos.application.form.FuncionarioForm;
import com.lucastro.gestaoDeProjetos.application.record.FuncionarioRecord;
import com.lucastro.gestaoDeProjetos.application.service.FuncionarioService;
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

class FuncionarioControllerTest {
    @Mock
    FuncionarioService funcionarioService;
    @InjectMocks
    FuncionarioController funcionarioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCadastrarFuncionario() {
        FuncionarioForm funcionario = Instancio.of(FuncionarioForm.class).create();

        funcionarioController.cadastrarFuncionario(funcionario);

        verify(funcionarioService).cadastrar(any());
    }

    @Test
    void testBuscarTodosFuncionarios() {
        List<FuncionarioRecord> funcionario = Instancio.ofList(FuncionarioRecord.class).create();
        when(funcionarioService.buscarTodos()).thenReturn(funcionario);

        List<FuncionarioRecord> result = funcionarioController.buscarTodosFuncionarios();

        Assertions.assertEquals(funcionario, result);
    }
}