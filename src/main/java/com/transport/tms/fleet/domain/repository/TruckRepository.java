package com.transport.tms.fleet.domain.repository;

import com.transport.tms.fleet.domain.model.Truck;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TruckRepository {
    Truck save(Truck truck);

    List<Truck> findByOwnerId(UUID ownerId);

    Optional<Truck> findById(UUID truckId);


}
