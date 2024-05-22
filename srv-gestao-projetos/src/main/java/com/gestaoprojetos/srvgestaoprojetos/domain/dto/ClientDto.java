package com.gestaoprojetos.srvgestaoprojetos.domain.dto;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ClientDto implements IClientDto {
    private Long idClient;
    private String name;
    private String email;
    private String phone;
    private List<ProjectDto> projects;

    public ClientDto(IClientEntity clientEntity) {
        this.idClient = clientEntity.getIdClient();
        this.name = clientEntity.getName();
        this.email = clientEntity.getEmail();
        this.phone = clientEntity.getPhone();
        this.projects = clientEntity.getProjects().stream().map(
                ProjectDto::new).collect(Collectors.toList());
    }
}
