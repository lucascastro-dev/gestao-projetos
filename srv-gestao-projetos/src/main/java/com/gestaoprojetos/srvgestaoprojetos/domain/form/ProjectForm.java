package com.gestaoprojetos.srvgestaoprojetos.domain.form;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectForm implements IProjectForm {
    private Long idProject;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean status;
    private Long idClient;
}
