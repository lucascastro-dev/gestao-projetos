package com.gestaoprojetos.srvgestaoprojetos.domain.form;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientForm implements IClientForm {
    private Long idClient;
    private String name;
    private String email;
    private String phone;
}
