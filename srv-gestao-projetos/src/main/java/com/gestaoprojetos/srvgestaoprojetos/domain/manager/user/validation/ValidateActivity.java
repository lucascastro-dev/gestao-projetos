package com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.validation;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import org.springframework.stereotype.Service;

@Service
public class ValidateActivity implements ITask<IUserForm> {

//    private final IActivityService<IActivityForm> activityService;

    @Override
    public void runTask(IUserForm param) {

    }
}
