package com.transport.tms.fleet.interfaces.rest.request;

import com.transport.tms.fleet.domain.model.VehicleType;

public record CreateTruckRequest(
        String vehicleNumber,
        VehicleType vehicleType,
        Double capacity,
        String driverName,
        String driverMobile
) {
}
