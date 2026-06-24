package com.transport.tms.shipmentTracking.infrastructure.messaging;

import com.transport.tms.shipmentTracking.domain.event.TruckLocationEventPublisher;
import com.transport.tms.shipmentTracking.domain.event.TruckLocationUpdatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaTruckLocationEventPublisher implements TruckLocationEventPublisher {

    private final KafkaTemplate<String, TruckLocationUpdatedEvent> kafkaTemplate;

    @Value("${app.kafka.topics.truck-location-updated}")
    private String truckLocationUpdatedTopic;

    @Override
    public void publish(TruckLocationUpdatedEvent event) {
        try {
            kafkaTemplate.send(
                    truckLocationUpdatedTopic,
                    event.truckId().toString(),
                    event
            ).whenComplete((result, exception) -> {
                if (exception != null) {
                    log.warn("Failed to publish truck location event for truckId={}", event.truckId(), exception);
                }
            });
        } catch (RuntimeException exception) {
            log.warn("Failed to publish truck location event for truckId={}", event.truckId(), exception);
        }
    }
}
