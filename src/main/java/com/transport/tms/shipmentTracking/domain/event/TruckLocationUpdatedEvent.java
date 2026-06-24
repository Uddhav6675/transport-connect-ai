package com.transport.tms.shipmentTracking.domain.event;

import com.transport.tms.shipmentTracking.domain.model.TrackingLocation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

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
