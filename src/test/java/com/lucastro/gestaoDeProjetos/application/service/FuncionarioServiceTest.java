package com.lucastro.gestaoDeProjetos.application.service;

import com.lucastro.gestaoDeProjetos.application.form.FuncionarioForm;
import com.lucastro.gestaoDeProjetos.application.record.FuncionarioRecord;
import com.lucastro.gestaoDeProjetos.domain.modal.entity.Funcionario;
import com.lucastro.gestaoDeProjetos.domain.repository.FuncionarioRepository;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

class FuncionarioServiceTest {
    @Mock
    FuncionarioRepository funcionarioRepository;
    @InjectMocks
    FuncionarioService funcionarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCadastrar() {
        funcionarioService.cadastrar(new FuncionarioForm());

        Mockito.verify(funcionarioRepository).save(any());
    }

    @Test
    void testBuscarTodos() {
        List<Funcionario> funcionarios = Instancio.ofList(Funcionario.class).create();
        when(funcionarioRepository.findAll()).thenReturn(funcionarios);

        List<FuncionarioRecord> result = funcionarioService.buscarTodos();

        Assertions.assertNotNull(result);
    }

    @Test
    void testBuscarFuncionario() {
        Funcionario funcionario = Instancio.of(Funcionario.class).create();
        when(funcionarioRepository.findByCpf(anyString())).thenReturn(funcionario);

        Funcionario result = funcionarioService.buscarFuncionario("cpfFuncionario");

        assertEquals(funcionario, result);
    }

    @Test
    void testCpfJaCadastrado() {
        FuncionarioForm funcionarioForm = Instancio.of(FuncionarioForm.class).create();
        when(funcionarioRepository.existsByCpf(anyString())).thenReturn(true);

        var exception = assertThrows(
                RuntimeException.class,
                () -> funcionarioService.cadastrar(funcionarioForm)
        );

        assertEquals("CPF já cadastrado", exception.getMessage());
    }

}