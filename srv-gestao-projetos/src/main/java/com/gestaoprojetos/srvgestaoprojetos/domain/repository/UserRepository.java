package com.gestaoprojetos.srvgestaoprojetos.domain.repository;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.UserEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    IUserEntity findByUserName(String userName);

    IUserEntity findByUserEmail(String userEmail);

    IUserEntity findByIdUser(Long idUser);

}
