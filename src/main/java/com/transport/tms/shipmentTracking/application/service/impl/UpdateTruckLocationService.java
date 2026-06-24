package com.transport.tms.shipmentTracking.application.service.impl;

import com.transport.common.exception.ResourceNotFoundException;
import com.transport.tms.fleet.domain.repository.TruckRepository;
import com.transport.tms.shipmentTracking.application.service.UpdateTruckLocationUseCase;
import com.transport.tms.shipmentTracking.domain.event.TruckLocationEventPublisher;
import com.transport.tms.shipmentTracking.domain.event.TruckLocationUpdatedEvent;
import com.transport.tms.shipmentTracking.domain.model.TrackingLocation;
import com.transport.tms.shipmentTracking.domain.repository.LatestTrackingLocationCache;
import com.transport.tms.shipmentTracking.domain.repository.TrackingLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateTruckLocationService implements UpdateTruckLocationUseCase {
    private final TruckRepository truckRepository;
    private final TrackingLocationRepository trackingLocationRepository;
    private final LatestTrackingLocationCache latestTrackingLocationCache;
    private final TruckLocationEventPublisher truckLocationEventPublisher;

    @Override
    public void update(UUID truckId, BigDecimal latitude, BigDecimal longitude) {
        truckRepository.findById(truckId)
                .orElseThrow(()-> new ResourceNotFoundException("Truck not found"));

        TrackingLocation location = TrackingLocation.builder()
                .truckId(truckId)
                .latitude(latitude)
                .longitude(longitude)
                .recordedAt(LocalDateTime.now())
                .build();

        TrackingLocation savedLocation = trackingLocationRepository.save(location);
        latestTrackingLocationCache.save(savedLocation);
        truckLocationEventPublisher.publish(
                TruckLocationUpdatedEvent.from(savedLocation)
        );
    }
}
