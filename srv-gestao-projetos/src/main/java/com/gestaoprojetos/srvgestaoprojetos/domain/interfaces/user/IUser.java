package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user;

import jakarta.validation.constraints.NotNull;

public interface IUser {

    Long getIdUser();

    @NotNull(message = "Nome de usuário é obrigatório")
    String getUserName();

    @NotNull(message = "Email do usuário é obrigatório")
    String getUserEmail();

    @NotNull(message = "Senha do usuário é obrigatória")
    String getPassword();

    void setIdUser(Long idUser);

    void setUserName(String userName);

    void setUserEmail(String userEmail);

    void setPassword(String password);

}
