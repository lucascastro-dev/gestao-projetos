package com.gestaoprojetos.srvgestaoprojetos.domain.dto;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ActivityDto implements IActivityDto {
    private Long idActivity;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean status;
    private Long idProjects;

    public ActivityDto(IActivityEntity activityEntity) {
        this.idActivity = activityEntity.getIdActivity();
        this.name = activityEntity.getName();
        this.description = activityEntity.getDescription();
        this.startDate = activityEntity.getStartDate();
        this.endDate = activityEntity.getEndDate();
        this.status = activityEntity.getStatus();
        this.idProjects = activityEntity.getProjects().getIdProject();
    }
}
