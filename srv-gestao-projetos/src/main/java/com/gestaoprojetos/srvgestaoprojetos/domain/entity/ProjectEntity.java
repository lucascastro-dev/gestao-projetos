package com.gestaoprojetos.srvgestaoprojetos.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity implements IProjectEntity {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProject;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnore
    private ClientEntity client;

    public ProjectEntity(IProjectForm projectForm) {
        this.idProject = projectForm.getIdProject();
        this.name = projectForm.getName();
        this.description = projectForm.getDescription();
        this.startDate = projectForm.getStartDate();
        this.endDate = projectForm.getEndDate();
        this.status = projectForm.getStatus();
        this.client = ClientEntity.builder().idClient(projectForm.getIdClient()).build();
    }
}
