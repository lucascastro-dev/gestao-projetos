package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ClientEntity;

import java.time.LocalDate;
import java.util.List;

public interface IProject {
    Long getIdProject();

    String getName();

    String getDescription();

    LocalDate getStartDate();

    LocalDate getEndDate();

    Boolean getStatus();

    ClientEntity getClient();

    List<ActivityEntity> getActivity();

    void setIdProject(Long idProject);

    void setName(String name);

    void setDescription(String description);

    void setStartDate(LocalDate startDate);

    void setEndDate(LocalDate endDate);

    void setStatus(Boolean status);

    void setClient(ClientEntity client);

    void setActivity(List<ActivityEntity> activity);
}
