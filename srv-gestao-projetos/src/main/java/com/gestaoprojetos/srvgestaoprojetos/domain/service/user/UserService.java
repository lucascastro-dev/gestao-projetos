package com.gestaoprojetos.srvgestaoprojetos.domain.service.user;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.UserEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserService;
import com.gestaoprojetos.srvgestaoprojetos.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService<IUserForm> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public IUserEntity save(IUserForm userForm) {
        return userRepository.save(new UserEntity(userForm));
    }

    @Override
    public void delete(Long idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public IUserEntity findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public IUserEntity findByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    @Override
    public List<IUserEntity> findAllUser() {
        return userRepository.findAll().stream().map(
                userEntity -> (IUserEntity) userEntity).collect(Collectors.toList()
        );
    }

    @Override
    public IUserEntity findUserById(Long idUser) {
        return userRepository.findByIdUser(idUser);
    }
}
