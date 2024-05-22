package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.check;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import org.springframework.stereotype.Service;

@Service
public class CheckProjectLinkedActivity implements ITask<IActivityForm> {

    @Override
    public void runTask(IActivityForm param) {

    }
}
