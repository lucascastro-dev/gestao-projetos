package com.lucastro.gestaoDeProjetos.application.service;

import com.lucastro.gestaoDeProjetos.application.form.FuncionarioForm;
import com.lucastro.gestaoDeProjetos.application.form.ProjetoForm;
import com.lucastro.gestaoDeProjetos.application.record.ProjetoRecord;
import com.lucastro.gestaoDeProjetos.domain.modal.entity.Funcionario;
import com.lucastro.gestaoDeProjetos.domain.modal.entity.Projeto;
import com.lucastro.gestaoDeProjetos.domain.repository.ProjetoRepository;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class ProjetoServiceTest {
    @Mock
    ProjetoRepository projetoRepository;
    @Mock
    FuncionarioService funcionarioService;
    @InjectMocks
    ProjetoService projetoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriar() {
        Funcionario funcionario = Instancio.of(Funcionario.class).create();
        ProjetoForm projeto = Instancio.of(ProjetoForm.class).create();
        projeto.getCpfFuncionario().add(funcionario.getCpf());
        when(funcionarioService.buscarFuncionario(funcionario.getCpf())).thenReturn(funcionario);

        projetoService.criar(projeto);

        Mockito.verify(projetoRepository).save(any());
    }

    @Test
    void testBuscarTodos() {
        List<Projeto> projetos = Instancio.ofList(Projeto.class).create();
        when(projetoRepository.findAll()).thenReturn(projetos);

        List<ProjetoRecord> result = projetoService.buscarTodos();

        Assertions.assertNotNull(result);
    }
}
