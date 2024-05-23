package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.ActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.CreateOrUpdateActivityManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.task.TaskSaveActivity;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation.ValidateDateActivity;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation.ValidateIdActivity;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation.ValidateProject;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ContextConfiguration(classes = {CreateOrUpdateActivityManager.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CreateOrUpdateActivityManagerTest {
    @Autowired
    private CreateOrUpdateActivityManager createOrUpdate;
    @MockBean
    private ValidateIdActivity validateIdActivity;
    @MockBean
    private ValidateProject validateProject;
    @MockBean
    private ValidateDateActivity validateDateActivity;
    @MockBean
    private TaskSaveActivity taskSaveActivity;

    private IActivityForm activityForm;

    @Test
    void shouldCreateActivity() {
        activityForm = Instancio.of(ActivityForm.class).create();

        createOrUpdate.runRequest(activityForm);

        verify(validateIdActivity, times(1)).runTask(activityForm);
        verify(validateProject, times(1)).runTask(activityForm);
        verify(validateDateActivity, times(1)).runTask(activityForm);
        verify(taskSaveActivity, times(1)).runTask(activityForm);
    }
}
