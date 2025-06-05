package com.lucastro.gestaoDeProjetos.application.form;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class FuncionarioForm {
    @NotNull(message = "O nome não pode ser nulo.")
    private String nome;

    @NotNull(message = "O CPF não pode ser nulo.")
    @CPF(message = "O CPF informado não é válido.")
    private String cpf;

    @NotNull(message = "O e-mail não pode ser nulo.")
    @Email(message = "O e-mail informado não é válido.")
    private String email;

    @NotNull(message = "O salário não pode ser nulo.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O salário deve ser maior que zero.")
    private Double salario;
}
