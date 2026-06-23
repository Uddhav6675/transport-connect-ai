package com.transport.tms.driver.infrastructure.persistence;

import com.transport.tms.driver.domain.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DriverJpaRepository extends JpaRepository<Driver, UUID> {
    List<Driver> findByOwnerId(UUID ownerId);
}
