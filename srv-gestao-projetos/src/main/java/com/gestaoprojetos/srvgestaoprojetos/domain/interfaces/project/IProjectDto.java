package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project;

import com.gestaoprojetos.srvgestaoprojetos.domain.dto.ActivityDto;

import java.util.List;

public interface IProjectDto extends IProject {
    public List<ActivityDto> getActivity();

    public void setActivity(List<ActivityDto> activity);
}
