package com.gestaoprojetos.srvgestaoprojetos.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityEntity implements IActivityEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActivity;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "idProject")
    @JsonIgnore
    private ProjectEntity projects;

    public ActivityEntity(IActivityForm activityForm) {
        this.idActivity = activityForm.getIdActivity();
        this.name = activityForm.getName();
        this.description = activityForm.getDescription();
        this.startDate = activityForm.getStartDate();
        this.endDate = activityForm.getEndDate();
        this.status = activityForm.getStatus();
        this.projects = ProjectEntity.builder().idProject(activityForm.getIdProjects()).build();
    }
}