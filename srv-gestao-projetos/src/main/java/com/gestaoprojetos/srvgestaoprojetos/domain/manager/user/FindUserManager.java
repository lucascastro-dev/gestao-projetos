package com.gestaoprojetos.srvgestaoprojetos.domain.manager.user;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.dto.UserDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IFindUserManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserService;
import com.gestaoprojetos.srvgestaoprojetos.domain.service.user.UserService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindUserManager implements IFindUserManager<IUserDto, IUserForm> {

    private final IUserService<IUserForm> userService;

    @Autowired
    public FindUserManager(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<IUserDto> all() {
        return userService.findAllUser().stream().map(UserDto::new).collect(Collectors.toList());
    }

    @Override
    public IUserDto get(IUserForm param) {
        IUserEntity userEntity = userService.findUserById(param.getIdUser());
        ObjectNotFoundException.isCondition(Util.isNullOrEmpty(userEntity), Constants.USER_NOT_FOUND);

        return new UserDto(userEntity);
    }
}
