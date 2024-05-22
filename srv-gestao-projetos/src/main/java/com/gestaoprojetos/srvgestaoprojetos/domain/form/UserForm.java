package com.gestaoprojetos.srvgestaoprojetos.domain.form;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserForm implements IUserForm {
    private Long idUser;
    private String userName;
    private String userEmail;
    private String password;
    private Set<Long> activity = new HashSet<>();

}
