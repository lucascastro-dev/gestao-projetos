package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;

import java.util.List;

public interface IActivityService<P extends IActivityForm> {

    IActivityEntity save(IActivityForm activityForm);

    void delete(Long idActivity);

    List<IActivityEntity> findAllActivity();

    IActivityEntity findActivityById(Long idActivity);

    IActivityEntity findByProjects(IProjectEntity project);
}
