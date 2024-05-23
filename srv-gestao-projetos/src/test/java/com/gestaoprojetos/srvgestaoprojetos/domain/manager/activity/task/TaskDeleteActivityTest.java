package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.task;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.ActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.task.TaskDeleteActivity;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.activity.ActivityService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TaskDeleteActivityTest {

    @InjectMocks
    private TaskDeleteActivity taskDeleteActivity;
    @Mock
    private ActivityService activityService;

    private IActivityForm activityForm;

    @Test
    void shouldSaveActivity() {
        activityForm = Instancio.of(ActivityForm.class).create();

        taskDeleteActivity.runTask(activityForm);

        verify(activityService, times(1)).delete(anyLong());
    }
}
