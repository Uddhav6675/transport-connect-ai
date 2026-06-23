package com.transport.tms.loadmatching.application.service;

import java.util.UUID;

public interface AssignTruckToLoadUseCase {
    void assign(UUID loadId, UUID truckId);
}
