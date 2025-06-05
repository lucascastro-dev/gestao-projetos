package com.lucastro.gestaoDeProjetos.application.form;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ProjetoForm {

    @NotNull(message = "O nome não pode ser nulo.")
    private String nomeProjeto;

    @NotNull(message = "A data de criação não pode ser nula.")
    private LocalDate dataCriacao;

    private List<String> cpfFuncionario;
}
