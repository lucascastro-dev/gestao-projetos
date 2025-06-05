package com.lucastro.gestaoDeProjetos.infra.controller;

import com.lucastro.gestaoDeProjetos.application.form.ProjetoForm;
import com.lucastro.gestaoDeProjetos.application.record.ProjetoRecord;
import com.lucastro.gestaoDeProjetos.application.service.ProjetoService;
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
@RequestMapping("/projetos")
@Tag(name = "Projetos", description = "Gerenciamentos de projetos")
public class ProjetoController {

    @Autowired
    private final ProjetoService projetoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "CRIA UM NOVO PROJETO")
    public void criarProjeto(@Valid @RequestBody ProjetoForm projetoForm) {
        projetoService.criar(projetoForm);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "RECUPERA TODOS OS PROJETOS")
    public List<ProjetoRecord> buscarTodosProjetos() {
        return projetoService.buscarTodos();
    }
}
