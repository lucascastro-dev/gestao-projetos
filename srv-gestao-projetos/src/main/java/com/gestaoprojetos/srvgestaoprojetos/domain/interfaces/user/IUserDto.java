package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user;

import java.util.Set;

public interface IUserDto extends IUser {
    Set<Long> getActivity();

    void setActivity(Set<Long> activity);
}
