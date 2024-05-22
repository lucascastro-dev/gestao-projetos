package com.gestaoprojetos.srvgestaoprojetos.domain.dto;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class UserDto implements IUserDto {
    private Long idUser;
    private String userName;
    private String userEmail;
    private String password;
    private Set<ActivityDto> activity;

    public UserDto(IUserEntity userEntity) {
        this.idUser = userEntity.getIdUser();
        this.userName = userEntity.getUserName();
        this.userEmail = userEntity.getUserEmail();
        this.activity = userEntity.getActivity().stream().map(
                ActivityDto::new).collect(Collectors.toSet());
    }
}
