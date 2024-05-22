package com.gestaoprojetos.srvgestaoprojetos.domain.service.activity;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService implements IActivityService<IActivityForm> {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public IActivityEntity save(IActivityForm activityForm) {
        return activityRepository.save(new ActivityEntity(activityForm));
    }

    @Override
    public void delete(Long idActivity) {
        activityRepository.deleteById(idActivity);
    }

    @Override
    public List<IActivityEntity> findAllActivity() {
        return activityRepository.findAll().stream().map(
                activityEntity -> (IActivityEntity) activityEntity).collect(Collectors.toList());
    }

    @Override
    public IActivityEntity findActivityById(Long idActivity) {
        return activityRepository.findByIdActivity(idActivity);
    }
}
