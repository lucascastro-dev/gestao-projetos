package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user;

import com.gestaoprojetos.srvgestaoprojetos.domain.dto.ActivityDto;

import java.util.Set;

public interface IUserDto extends IUser {
    Set<ActivityDto> getActivity();

    void setActivity(Set<ActivityDto> activity);
}
