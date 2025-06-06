package com.lucastro.gestaoDeProjetos.domain.modal.entity;

import com.lucastro.gestaoDeProjetos.application.form.ProjetoForm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjeto;

    private String nome;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @ManyToMany(mappedBy = "projetos")
    private Set<Funcionario> funcionarios;

    public Projeto(ProjetoForm projetoForm, Set<Funcionario> listaDeFuncionarios) {
        this.nome = projetoForm.getNomeProjeto();
        this.dataCriacao = projetoForm.getDataCriacao();
        this.funcionarios = listaDeFuncionarios;
    }
}
