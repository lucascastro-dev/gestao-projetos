package com.gestaoprojetos.srvgestaoprojetos.infra.service.client;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientService;
import com.gestaoprojetos.srvgestaoprojetos.infra.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService<IClientForm> {

    private final ClienteRepository clienteRepository;

    public ClientService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public IClientEntity save(IClientForm clientForm) {
        return clienteRepository.save(new ClientEntity(clientForm));
    }

    @Override
    public void delete(Long idClient) {
        clienteRepository.deleteById(idClient);
    }

    @Override
    public List<IClientEntity> findAllClient() {
        return clienteRepository.findAll().stream().map(
                clientEntity -> (IClientEntity) clientEntity).collect(Collectors.toList());
    }

    @Override
    public IClientEntity findClientById(Long idClient) {
        return clienteRepository.findByIdClient(idClient);
    }

    @Override
    public IClientEntity findByNameClient(String nameClient) {
        return clienteRepository.findByName(nameClient);
    }
}
