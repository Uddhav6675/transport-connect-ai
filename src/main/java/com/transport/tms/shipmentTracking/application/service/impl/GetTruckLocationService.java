package com.transport.tms.shipmentTracking.application.service.impl;

import com.transport.common.exception.ResourceNotFoundException;
import com.transport.tms.shipmentTracking.application.service.GetTruckLocationUseCase;
import com.transport.tms.shipmentTracking.domain.model.TrackingLocation;
import com.transport.tms.shipmentTracking.domain.repository.LatestTrackingLocationCache;
import com.transport.tms.shipmentTracking.domain.repository.TrackingLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetTruckLocationService implements GetTruckLocationUseCase {
    private final TrackingLocationRepository trackingLocationRepository;
    private final LatestTrackingLocationCache latestTrackingLocationCache;

    @Override
    public TrackingLocation get(UUID truckId) {
        return latestTrackingLocationCache.findByTruckId(truckId)
                .or(() -> trackingLocationRepository.findByTruckId(truckId)
                        .map(location -> {
                            latestTrackingLocationCache.save(location);
                            return location;
                        }))
                .orElseThrow(()-> new ResourceNotFoundException("Location not found"));
    }
}
