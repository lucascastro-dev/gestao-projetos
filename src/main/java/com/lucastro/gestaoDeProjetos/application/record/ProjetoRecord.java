package com.lucastro.gestaoDeProjetos.application.record;

import java.time.LocalDate;
import java.util.List;

public record ProjetoRecord(String nome, LocalDate dataCriacao, List<String> funcionarios) {
}
