package com.transport.tms.fleet.interfaces.rest.response;

import com.transport.tms.fleet.domain.model.TruckStatus;
import com.transport.tms.fleet.domain.model.VehicleType;

import java.util.UUID;

public record TruckResponse(
        UUID id,
        String vehicleNumber,
        VehicleType vehicleType,
        java.math.BigDecimal capacity,
        String driverName,
        String driverMobile,
        TruckStatus status
) {
}
