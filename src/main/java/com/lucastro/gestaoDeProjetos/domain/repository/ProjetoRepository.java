package com.lucastro.gestaoDeProjetos.domain.repository;

import com.lucastro.gestaoDeProjetos.domain.modal.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
