package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity;

import java.util.List;

public interface IActivityService<P extends IActivityForm> {

    IActivityEntity save(IActivityForm activityForm);

    void delete(Long idActivity);

    List<IActivityEntity> findAllActivity();

    IActivityEntity findActivityById(Long idActivity);
}
