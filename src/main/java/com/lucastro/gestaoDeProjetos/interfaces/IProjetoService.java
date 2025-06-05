package com.lucastro.gestaoDeProjetos.interfaces;

import com.lucastro.gestaoDeProjetos.application.form.ProjetoForm;
import com.lucastro.gestaoDeProjetos.application.record.ProjetoRecord;
import jakarta.validation.Valid;

import java.util.List;

public interface IProjetoService {
    void criar(@Valid ProjetoForm projetoForm);

    List<ProjetoRecord> buscarTodos();
}
