package com.transport.tms.shipmentTracking.application.service;

import java.math.BigDecimal;
import java.util.UUID;

public interface UpdateTruckLocationUseCase {
    void update(UUID truckId,
                BigDecimal latitude,
                BigDecimal longitude);
}
