package com.transport.tms.driver.domain.repository;

import com.transport.tms.driver.domain.model.Driver;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DriverRepository {
    Driver save(Driver driver);

    Optional<Driver> findById(UUID id);

    List<Driver> findByOwnerId(UUID ownerId);
}
