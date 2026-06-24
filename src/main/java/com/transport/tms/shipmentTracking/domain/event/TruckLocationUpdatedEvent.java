package com.transport.tms.shipmentTracking.domain.event;

import com.transport.tms.shipmentTracking.domain.model.TrackingLocation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Event published after a truck location is saved.
 * Other modules can consume this event later for analytics, alerts, live dashboards, or ETA calculation.
 */
public record TruckLocationUpdatedEvent(
        UUID eventId,
        UUID trackingLocationId,
        UUID truckId,
        BigDecimal latitude,
        BigDecimal longitude,
        LocalDateTime recordedAt,
        LocalDateTime eventCreatedAt
) {

    public static TruckLocationUpdatedEvent from(TrackingLocation location) {
        // eventId is different from trackingLocationId because this is a message identity, not a DB row identity.
        return new TruckLocationUpdatedEvent(
                UUID.randomUUID(),
                location.getId(),
                location.getTruckId(),
                location.getLatitude(),
                location.getLongitude(),
                location.getRecordedAt(),
                LocalDateTime.now()
        );
    }
}
