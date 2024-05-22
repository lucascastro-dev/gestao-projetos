package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ActivityEntity;

import java.util.Set;

public interface IUserEntity extends IUser {
    Set<ActivityEntity> getActivity();

    void setActivity(Set<ActivityEntity> activity);

}
