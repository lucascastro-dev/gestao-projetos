package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.form.ActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.activity.ActivityService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {FindActivityManager.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FindActivityManagerTest {

    @Autowired
    private FindActivityManager find;

    @MockBean
    private ActivityService activityService;

    private IActivityForm activityForm;
    private IActivityEntity activityEntity;

    @Test
    void shouldFindAll() {
        Assertions.assertNotNull(find.all());
    }

    @Test
    void shouldFindById() {
        activityEntity = Instancio.of(ActivityEntity.class).create();
        activityForm = Instancio.of(ActivityForm.class).create();
        when(activityService.findActivityById(anyLong())).thenReturn(activityEntity);

        Assertions.assertNotNull(find.get(activityForm));
    }
}
