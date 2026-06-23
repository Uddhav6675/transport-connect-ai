package com.transport.tms.shipmentTracking.domain.repository;

import com.transport.tms.shipmentTracking.domain.model.TrackingLocation;

import java.util.Optional;
import java.util.UUID;

public interface TrackingLocationRepository {
    TrackingLocation save(TrackingLocation location);

    Optional<TrackingLocation> findByTruckId(UUID truckId);
}
