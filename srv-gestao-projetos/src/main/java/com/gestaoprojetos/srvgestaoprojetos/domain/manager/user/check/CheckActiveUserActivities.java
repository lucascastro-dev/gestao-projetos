package com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.check;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import org.springframework.stereotype.Service;

@Service
public class CheckActiveUserActivities implements ITask<IUserForm> {

    @Override
    public void runTask(IUserForm param) {

    }
}
