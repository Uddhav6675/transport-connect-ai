package com.transport.tms.shipmentTracking.interfaces.rest.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TrackingLocationResponse(
        UUID truckId,
        BigDecimal latitude,
        BigDecimal longitude,
        LocalDateTime recordedAt
) {
}
