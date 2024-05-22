package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client;

import jakarta.validation.constraints.NotNull;

public interface IClient {
    Long getIdClient();

    @NotNull(message = "Obrigatório informar nome do cliente")
    String getName();

    @NotNull(message = "Obrigatório informar email do cliente")
    String getEmail();

    @NotNull(message = "Obrigatório informar telefone do cliente")
    String getPhone();

    void setIdClient(Long idClient);

    void setName(String name);

    void setEmail(String email);

    void setPhone(String phone);
}
