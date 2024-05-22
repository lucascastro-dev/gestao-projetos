package com.gestaoprojetos.srvgestaoprojetos.domain.entity;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity implements IClientEntity {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProjectEntity> projects;

    public ClientEntity(IClientForm clientForm) {
        this.idClient = clientForm.getIdClient();
        this.name = clientForm.getName();
        this.email = clientForm.getEmail();
        this.phone = clientForm.getPhone();
        this.projects = clientForm.getProjects().stream().map(
                project -> ProjectEntity.builder().idProject(project).build()).collect(Collectors.toList());
    }
}
