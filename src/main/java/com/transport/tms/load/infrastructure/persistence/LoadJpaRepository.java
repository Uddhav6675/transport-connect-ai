package com.transport.tms.load.infrastructure.persistence;

import com.transport.tms.load.domain.model.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LoadJpaRepository extends JpaRepository<Load, UUID> {

    List<Load> findByShipperId(UUID shipperId);
}
