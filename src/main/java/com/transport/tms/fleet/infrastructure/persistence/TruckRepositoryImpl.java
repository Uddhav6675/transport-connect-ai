package com.transport.tms.fleet.infrastructure.persistence;

import com.transport.tms.fleet.domain.model.Truck;
import com.transport.tms.fleet.domain.repository.TruckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TruckRepositoryImpl implements TruckRepository {

    private final TruckJpaRepository jpaRepository;
    @Override
    public Truck save(Truck truck) {
        return jpaRepository.save(truck);
    }

    @Override
    public List<Truck> findByOwnerId(UUID ownerId) {
        return jpaRepository.findByOwnerId(ownerId);
    }

    @Override
    public Optional<Truck> findById(UUID truckId){
        return jpaRepository.findById(truckId)
                .map(this:: toDomain);
    }

    private Truck toDomain(Truck truck) {
        return Truck.builder()
                .id(truck.getId())
                .ownerId(truck.getOwnerId())
                .vehicleNumber(truck.getVehicleNumber())
                .vehicleType(truck.getVehicleType())
                .capacity(truck.getCapacity())
                .driverName(truck.getDriverName())
                .driverMobile(truck.getDriverMobile())
                .status(truck.getStatus())
                .build();
    }
}
