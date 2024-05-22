package com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.validation;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.domain.service.user.UserService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.DuplicateDataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateUserData implements ITask<IUserForm> {
    private final IUserService<IUserForm> userService;

    @Autowired
    public ValidateUserData(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void runTask(IUserForm param) {
        if (Util.isNullOrEmpty(param.getIdUser())) {
            DuplicateDataBaseException.isCondition(
                    Util.isNullOrEmpty(userService.findByUserName(param.getUserName())), Constants.DUPLICATE_USER);
            DuplicateDataBaseException.isCondition(
                    Util.isNullOrEmpty(userService.findByUserEmail(param.getUserEmail())), Constants.DUPLICATE_USER);
        }
    }
}
