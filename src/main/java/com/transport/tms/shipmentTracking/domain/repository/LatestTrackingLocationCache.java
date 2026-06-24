package com.transport.tms.shipmentTracking.domain.repository;

import com.transport.tms.shipmentTracking.domain.model.TrackingLocation;

import java.util.Optional;
import java.util.UUID;

/**
 * Domain port for reading/writing the latest truck location from a fast cache.
 * The application layer depends on this interface, not directly on Redis.
 */
public interface LatestTrackingLocationCache {

    /**
     * Store only the newest known location for a truck.
     * Full tracking history is still stored separately in PostgreSQL.
     */
    void save(TrackingLocation location);

    /**
     * Returns empty when Redis does not have the truck location yet.
     * The service can then fall back to PostgreSQL.
     */
    Optional<TrackingLocation> findByTruckId(UUID truckId);
}
