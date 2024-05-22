package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.dto.ActivityDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IFindActivityManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.service.activity.ActivityService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindActivityManager implements IFindActivityManager<IActivityDto, IActivityForm> {

    private final IActivityService<IActivityForm> activityService;

    @Autowired
    public FindActivityManager(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Override
    public List<IActivityDto> all() {
        return activityService.findAllActivity().stream().map(
                ActivityDto::new).collect(Collectors.toList());
    }

    @Override
    public IActivityDto get(IActivityForm param) {
        IActivityEntity activityEntity = activityService.findActivityById(param.getIdActivity());
        ObjectNotFoundException.isCondition(Util.isNullOrEmpty(activityEntity), Constants.ACTIVITY_NOT_FOUND);

        return new ActivityDto(activityEntity);
    }
}
