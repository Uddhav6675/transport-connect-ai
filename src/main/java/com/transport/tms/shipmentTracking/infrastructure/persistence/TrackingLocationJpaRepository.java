package com.transport.tms.shipmentTracking.infrastructure.persistence;

import com.transport.tms.shipmentTracking.domain.model.TrackingLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TrackingLocationJpaRepository extends JpaRepository<TrackingLocation, UUID> {

    Optional<TrackingLocation> findTopByTruckIdOrderByRecordedAtDesc(UUID truckId);
}
