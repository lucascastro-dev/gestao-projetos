package com.gestaoprojetos.srvgestaoprojetos.domain.repository;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClientEntity, Long> {
    IClientEntity findByIdClient(Long idClient);

    IClientEntity findByName(String userName);
}
