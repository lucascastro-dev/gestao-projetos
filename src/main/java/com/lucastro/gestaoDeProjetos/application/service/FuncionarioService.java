package com.lucastro.gestaoDeProjetos.application.service;

import com.lucastro.gestaoDeProjetos.application.form.FuncionarioForm;
import com.lucastro.gestaoDeProjetos.application.record.FuncionarioRecord;
import com.lucastro.gestaoDeProjetos.domain.modal.entity.Funcionario;
import com.lucastro.gestaoDeProjetos.domain.repository.FuncionarioRepository;
import com.lucastro.gestaoDeProjetos.interfaces.IFuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioService implements IFuncionarioService {

    @Autowired
    private final FuncionarioRepository funcionarioRepository;

    @Override
    public void cadastrar(FuncionarioForm funcionarioForm) {
        validarCpfDuplicado(funcionarioForm.getCpf());
        funcionarioRepository.save(new Funcionario(funcionarioForm));
    }

    @Override
    public List<FuncionarioRecord> buscarTodos() {
        return funcionarioRepository.findAll()
                .stream()
                .map(funcionario -> new FuncionarioRecord(
                        funcionario.getNome(),
                        funcionario.getCpf(),
                        funcionario.getEmail(),
                        funcionario.getSalario()))
                .collect(Collectors.toList());
    }

    @Override
    public Funcionario buscarFuncionario(String cpfFuncionario) {
        return funcionarioRepository.findByCpf(cpfFuncionario);
    }

    private void validarCpfDuplicado(String cpf) {
        if (funcionarioRepository.existsByCpf(cpf)) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }
    }
}
