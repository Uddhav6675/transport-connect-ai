package com.transport.tms.fleet.infrastructure.persistence;

import com.transport.tms.fleet.domain.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface TruckJpaRepository extends JpaRepository<Truck, UUID> {
    List<Truck> findByOwnerId(UUID ownerId);

//   Optional<Truck> findById(UUID truckId);


}
