package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client;

import java.util.List;

public interface IClientService<P extends IClientForm> {
    IClientEntity save(IClientForm clientForm);

    void delete(Long idClient);

    List<IClientEntity> findAllClient();

    IClientEntity findClientById(Long idClient);

    IClientEntity findByNameClient(String nameClient);
}
