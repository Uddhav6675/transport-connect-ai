package com.transport.tms.load.application.service;

import java.util.UUID;

public interface CompleteTripUseCase {
    void completeTrip(UUID loadId);
}
