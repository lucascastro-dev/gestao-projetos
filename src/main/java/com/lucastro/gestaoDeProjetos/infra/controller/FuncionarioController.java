package com.lucastro.gestaoDeProjetos.infra.controller;

import com.lucastro.gestaoDeProjetos.application.form.FuncionarioForm;
import com.lucastro.gestaoDeProjetos.application.record.FuncionarioRecord;
import com.lucastro.gestaoDeProjetos.application.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/funcionario")
@Tag(name = "Funcionarios", description = "Gerenciamentos de funcionarios")
public class FuncionarioController {

    @Autowired
    private final FuncionarioService funcionarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "CRIA UM NOVO FUNCIONÁRIO")
    public void cadastrarFuncionario(@Valid @RequestBody FuncionarioForm funcionarioForm) {
        funcionarioService.cadastrar(funcionarioForm);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "RECUPERA TODOS OS FUNCIONARIOS")
    public List<FuncionarioRecord> buscarTodosFuncionarios() {
        return funcionarioService.buscarTodos();
    }
}
