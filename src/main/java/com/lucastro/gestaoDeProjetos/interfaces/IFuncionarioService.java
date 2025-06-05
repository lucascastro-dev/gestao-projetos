package com.lucastro.gestaoDeProjetos.interfaces;

import com.lucastro.gestaoDeProjetos.application.form.FuncionarioForm;
import com.lucastro.gestaoDeProjetos.application.record.FuncionarioRecord;
import com.lucastro.gestaoDeProjetos.domain.modal.entity.Funcionario;
import jakarta.validation.Valid;

import java.util.List;

public interface IFuncionarioService {
    void cadastrar(@Valid FuncionarioForm funcionarioForm);

    List<FuncionarioRecord> buscarTodos();

    Funcionario buscarFuncionario(String funcionario);
}
