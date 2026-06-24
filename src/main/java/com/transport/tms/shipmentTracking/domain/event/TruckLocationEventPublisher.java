package com.transport.tms.shipmentTracking.domain.event;

/**
 * Domain port for publishing truck-location events.
 * The application layer does not need to know whether the implementation is Kafka, RabbitMQ, or something else.
 */
public interface TruckLocationEventPublisher {

    void publish(TruckLocationUpdatedEvent event);
}
