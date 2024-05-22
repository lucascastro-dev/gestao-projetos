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
            Boolean findByName = userService.findByUserName(param.getUserName()) != null && userService.findByUserName(param.getUserName()).getUserName().equals(param.getUserName());
            Boolean findByEmail = userService.findByUserEmail(param.getUserEmail()) != null && userService.findByUserEmail(param.getUserEmail()).getUserName().equals(param.getUserEmail());

            DuplicateDataBaseException.isCondition(findByName, Constants.DUPLICATE_USER);
            DuplicateDataBaseException.isCondition(findByEmail, Constants.DUPLICATE_USER);
        }
    }
}
