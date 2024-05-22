package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import com.gestaoprojetos.srvgestaoprojetos.domain.service.activity.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.gestaoprojetos.srvgestaoprojetos.domain.util.Util.validateFromEndValidityDate;
import static com.gestaoprojetos.srvgestaoprojetos.domain.util.Util.validateFromStartValidityDate;

@Service
public class ValidateDate implements ITask<IActivityForm> {
    private final IActivityService<IActivityForm> activityService;

    @Autowired
    public ValidateDate(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Override
    public void runTask(IActivityForm param) {
        validateDate(param.getStartDate(), param.getEndDate());
    }

    private void validateDate(LocalDate startDate, LocalDate endDate) {
        validateFromStartValidityDate(startDate);
        validateFromEndValidityDate(startDate, endDate);
    }
}
