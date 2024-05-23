package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.ActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.check.CheckActivityIsAtive;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.task.TaskDeleteActivity;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation.ValidateIdActivity;
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

@ContextConfiguration(classes = {DeleteActivityManager.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DeleteActivityManagerTest {
    @Autowired
    private DeleteActivityManager deleteActivityManager;
    @MockBean
    private ValidateIdActivity validateIdActivity;
    @MockBean
    private CheckActivityIsAtive checkActivityIsAtive;
    @MockBean
    private TaskDeleteActivity taskDeleteActivity;

    private IActivityForm activityForm;

    @Test
    void shouldDeleteActivity() {
        activityForm = Instancio.of(ActivityForm.class).create();

        deleteActivityManager.runRequest(activityForm);

        verify(validateIdActivity, times(1)).runTask(activityForm);
        verify(checkActivityIsAtive, times(1)).runTask(activityForm);
        verify(taskDeleteActivity, times(1)).runTask(activityForm);
    }
}
