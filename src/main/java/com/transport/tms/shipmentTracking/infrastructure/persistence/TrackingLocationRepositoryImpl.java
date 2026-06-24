package com.transport.tms.shipmentTracking.infrastructure.persistence;

import com.transport.tms.shipmentTracking.domain.model.TrackingLocation;
import com.transport.tms.shipmentTracking.domain.repository.TrackingLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
@RequiredArgsConstructor
public class TrackingLocationRepositoryImpl implements TrackingLocationRepository {

    private final TrackingLocationJpaRepository jpaRepository;
    @Override
    public TrackingLocation save(TrackingLocation location) {
        return jpaRepository.save(location);
    }

    @Override
    public Optional<TrackingLocation> findByTruckId(UUID truckId) {
        return jpaRepository.findTopByTruckIdOrderByRecordedAtDesc(truckId);
    }
}
