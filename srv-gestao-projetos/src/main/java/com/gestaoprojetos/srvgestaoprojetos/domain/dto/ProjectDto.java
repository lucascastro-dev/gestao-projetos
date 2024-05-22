package com.gestaoprojetos.srvgestaoprojetos.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ProjectDto implements IProjectDto {
    private Long idProject;
    private String name;
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;
    private Boolean status;
    private ClientEntity client;
    private List<ActivityDto> activity;

    public ProjectDto(IProjectEntity projectEntity) {
        this.idProject = projectEntity.getIdProject();
        this.name = projectEntity.getName();
        this.description = projectEntity.getDescription();
        this.startDate = projectEntity.getStartDate();
        this.endDate = projectEntity.getEndDate();
        this.status = projectEntity.getStatus();
        this.client = projectEntity.getClient();
        this.activity = projectEntity.getActivity().stream().map(
                ActivityDto::new).collect(Collectors.toList());
    }
}
