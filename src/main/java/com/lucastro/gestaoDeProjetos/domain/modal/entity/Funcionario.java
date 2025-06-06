package com.lucastro.gestaoDeProjetos.domain.modal.entity;

import com.lucastro.gestaoDeProjetos.application.form.FuncionarioForm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;
    private String nome;
    private String cpf;
    private String email;
    private Double salario;

    @ManyToMany
    @JoinTable(
            name = "funcionario_projeto",
            joinColumns = @JoinColumn(name = "funcionario_id"),
            inverseJoinColumns = @JoinColumn(name = "projeto_id")
    )
    private Set<Projeto> projetos;

    public Funcionario(FuncionarioForm funcionarioForm) {
        this.nome = funcionarioForm.getNome();
        this.cpf = funcionarioForm.getCpf();
        this.email = funcionarioForm.getEmail();
        this.salario = funcionarioForm.getSalario();
    }
}
