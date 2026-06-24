package com.transport.tms.shipmentTracking.application.service;

import com.transport.tms.shipmentTracking.domain.model.TrackingLocation;

import java.util.UUID;

public interface GetTruckLocationUseCase {
    TrackingLocation get(UUID truckId);
}
