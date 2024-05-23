package com.gestaoprojetos.srvgestaoprojetos.domain.manager.client;

import com.gestaoprojetos.srvgestaoprojetos.constants.Constants;
import com.gestaoprojetos.srvgestaoprojetos.domain.dto.ClientDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientService;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IFindClienteManager;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.client.ClientService;
import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindClientManager implements IFindClienteManager<IClientDto, IClientForm> {

    private final IClientService<IClientForm> clientService;

    @Autowired
    public FindClientManager(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public List<IClientDto> all() {
        return clientService.findAllClient().stream().map(ClientDto::new).collect(Collectors.toList());
    }

    @Override
    public IClientDto get(IClientForm param) {
        IClientEntity clientEntity = clientService.findClientById(param.getIdClient());
        ObjectNotFoundException.isCondition(Util.isNullOrEmpty(clientEntity), Constants.CLIENT_NOT_FOUND);

        return new ClientDto(clientEntity);
    }
}
