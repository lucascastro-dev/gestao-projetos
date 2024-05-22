package com.gestaoprojetos.srvgestaoprojetos.domain.entity;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserForm;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements IUserEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String userName;
    private String userEmail;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_activity",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private Set<ActivityEntity> activity;

    public UserEntity(IUserForm userForm) {
        this.idUser = userForm.getIdUser();
        this.userName = userForm.getUserName();
        this.userEmail = userForm.getUserEmail();
        this.password = userForm.getPassword();
        this.activity = userForm.getActivity().stream().map(
                idActivity -> ActivityEntity.builder().idActivity(idActivity).build()).collect(Collectors.toSet());
    }
}
