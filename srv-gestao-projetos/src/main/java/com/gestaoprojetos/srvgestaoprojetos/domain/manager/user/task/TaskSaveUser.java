package com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.task;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.domain.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskSaveUser implements ITask<IUserForm> {

    private final IUserService<IUserForm> userService;

    @Autowired
    public TaskSaveUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void runTask(IUserForm param) {
        userService.save(param);
    }
}
