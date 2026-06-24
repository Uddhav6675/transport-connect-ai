package com.transport.tms.shipmentTracking.interfaces.rest.request;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateLocationRequest(
        UUID truckId,
        BigDecimal latitude,
        BigDecimal longitude
) {
}
