package com.gestaoprojetos.srvgestaoprojetos.controller;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.UserForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IFindUserManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.user.IUserManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.CreateOrUpdateUserManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.DeleteUserManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.user.FindUserManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Usuários",
        description = "Endpoint responsável pela manutenção dos usuários")
@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserManager<IUserForm> createOrUpdate;
    private final IUserManager<IUserForm> delete;
    private final IFindUserManager<IUserDto, IUserForm> find;

    @Autowired
    public UserController(CreateOrUpdateUserManager createOrUpdate,
                          DeleteUserManager delete,
                          FindUserManager find) {
        this.createOrUpdate = createOrUpdate;
        this.delete = delete;
        this.find = find;
    }

    @PostMapping()
    @Operation(summary = "Criar um novo usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserForm userForm) {
        createOrUpdate.runRequest(userForm);
    }

    @PutMapping()
    @Operation(summary = "Atualizar um usuário")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody UserForm userForm) {
        createOrUpdate.runRequest(userForm);
    }

    @DeleteMapping(value = "/{idUser}")
    @Operation(summary = "Deletar um usuário")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long idUser) {
        delete.runRequest(UserForm.builder().idUser(idUser).build());
    }

    @GetMapping
    @Operation(summary = "Buscar todos os usuários cadastrados")
    @ResponseStatus(HttpStatus.OK)
    public List<IUserDto> findAll() {
        return find.all();
    }

    @GetMapping(value = "/{idUser}")
    @Operation(summary = "Buscar usuário pelo ID")
    @ResponseStatus(HttpStatus.OK)
    public IUserDto findById(@PathVariable Long idUser) {
        return find.get(UserForm.builder().idUser(idUser).build());
    }
}
