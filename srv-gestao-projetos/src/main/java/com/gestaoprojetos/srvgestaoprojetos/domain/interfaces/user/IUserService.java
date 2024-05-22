package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user;

import java.util.List;

public interface IUserService<P extends IUserForm> {

    IUserEntity save(IUserForm userForm);

    void delete(Long idUser);

    IUserEntity findByUserName(String userName);

    IUserEntity findByUserEmail(String userEmail);

    List<IUserEntity> findAllUser();

    IUserEntity findUserById(Long idUser);
}
