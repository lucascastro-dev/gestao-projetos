package com.lucastro.gestaoDeProjetos.application.service;

import com.lucastro.gestaoDeProjetos.application.form.ProjetoForm;
import com.lucastro.gestaoDeProjetos.application.record.ProjetoRecord;
import com.lucastro.gestaoDeProjetos.domain.modal.entity.Funcionario;
import com.lucastro.gestaoDeProjetos.domain.modal.entity.Projeto;
import com.lucastro.gestaoDeProjetos.domain.repository.ProjetoRepository;
import com.lucastro.gestaoDeProjetos.interfaces.IProjetoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjetoService implements IProjetoService {

    @Autowired
    private final ProjetoRepository projetoRepository;
    @Autowired
    private final FuncionarioService funcionarioService;

    @Override
    public void criar(ProjetoForm projetoForm) {
        Set<Funcionario> listaDeFuncionarios = validarFuncionarios(projetoForm.getCpfFuncionario());

        Projeto projeto = new Projeto(projetoForm, new HashSet<>());
        listaDeFuncionarios.forEach(funcionario -> funcionario.getProjetos().add(projeto));

        projetoRepository.save(projeto);
    }

    @Override
    public List<ProjetoRecord> buscarTodos() {
        return projetoRepository.findAll()
                .stream()
                .map(projeto -> new ProjetoRecord(
                        projeto.getNome(),
                        projeto.getDataCriacao(),
                        projeto.getFuncionarios().stream()
                                .map(funcionario -> funcionario.getNome() + " - " + funcionario.getCpf())
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    private Set<Funcionario> validarFuncionarios(List<String> cpfFuncionarios) {
        Set<Funcionario> listaDeFuncionarios = new HashSet<>();

        if (cpfFuncionarios != null && !cpfFuncionarios.isEmpty()) {
            cpfFuncionarios.forEach(cpf -> {
                Funcionario funcionario = funcionarioService.buscarFuncionario(cpf);
                if (funcionario != null) {
                    listaDeFuncionarios.add(funcionario);
                } else {
                    log.info("Funcionário com CPF " + cpf + " não encontrado.");
                }
            });
        }

        return listaDeFuncionarios;
    }
}
