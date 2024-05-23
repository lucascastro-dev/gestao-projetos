package com.gestaoprojetos.srvgestaoprojetos.controller;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.ClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IFindClienteManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.CreateOrUpdateClientManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.DeleteClientManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.client.FindClientManager;
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

@Tag(name = "Cliente",
        description = "Endpoint responsável pela manutenção de clientes")
@RestController
@RequestMapping("/client")
public class ClientController {

    private final IClientManager<IClientForm> createOrUpdate;
    private final IClientManager<IClientForm> delete;
    private final IFindClienteManager<IClientDto, IClientForm> find;

    @Autowired
    public ClientController(CreateOrUpdateClientManager createOrUpdate,
                            DeleteClientManager delete,
                            FindClientManager find) {
        this.createOrUpdate = createOrUpdate;
        this.delete = delete;
        this.find = find;
    }

    @PostMapping()
    @Operation(summary = "Criar um novo cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ClientForm clientForm) {
        createOrUpdate.runRequest(clientForm);
    }

    @PutMapping()
    @Operation(summary = "Atualizar um cliente")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody ClientForm clientForm) {
        createOrUpdate.runRequest(clientForm);
    }

    @DeleteMapping(value = "/{idClient}")
    @Operation(summary = "Deletar um cliente")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long idClient) {
        delete.runRequest(ClientForm.builder().idClient(idClient).build());
    }

    @GetMapping
    @Operation(summary = "Buscar todos os cliente")
    @ResponseStatus(HttpStatus.OK)
    public List<IClientDto> findAll() {
        return find.all();
    }

    @GetMapping(value = "/{idCliente}")
    @Operation(summary = "Buscar um cliente pelo ID")
    @ResponseStatus(HttpStatus.OK)
    public IClientDto findById(@PathVariable Long idCliente) {
        return find.get(ClientForm.builder().idClient(idCliente).build());
    }
}
