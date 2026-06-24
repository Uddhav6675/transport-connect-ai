package com.transport.tms.shipmentTracking.domain.event;

public interface TruckLocationEventPublisher {

    void publish(TruckLocationUpdatedEvent event);
}
