package com.gestaoprojetos.srvgestaoprojetos.domain.repository;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {
}
