package com.transport.tms.driver.infrastructure.persistence;

import com.transport.tms.driver.domain.model.Driver;
import com.transport.tms.driver.domain.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
@RequiredArgsConstructor
public class DriverRepositoryImpl implements DriverRepository {

    private final DriverJpaRepository jpaRepository;

    @Override
    public Driver save(Driver driver) {
        return jpaRepository.save(driver);
    }

    @Override
    public Optional<Driver> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Driver> findByOwnerId(UUID ownerId) {
        return jpaRepository.findByOwnerId(ownerId);
    }
}
