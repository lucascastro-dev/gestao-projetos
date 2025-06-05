package com.lucastro.gestaoDeProjetos.domain.repository;

import com.lucastro.gestaoDeProjetos.domain.modal.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByCpf(String cpfFuncionario);

    boolean existsByCpf(String cpf);
}
