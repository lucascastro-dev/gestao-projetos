package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.gestaoprojetos.srvgestaoprojetos.domain.util.Util.validateFromEndValidityDate;
import static com.gestaoprojetos.srvgestaoprojetos.domain.util.Util.validateFromStartValidityDate;

@Service
public class ValidateDateActivity implements ITask<IActivityForm> {
    @Override
    public void runTask(IActivityForm param) {
        validateDate(param.getStartDate(), param.getEndDate());
    }

    private void validateDate(LocalDate startDate, LocalDate endDate) {
        validateFromStartValidityDate(startDate);
        validateFromEndValidityDate(startDate, endDate);
    }
}
