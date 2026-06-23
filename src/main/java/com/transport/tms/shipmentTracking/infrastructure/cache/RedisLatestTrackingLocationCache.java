package com.transport.tms.shipmentTracking.infrastructure.cache;

import com.transport.tms.shipmentTracking.domain.model.TrackingLocation;
import com.transport.tms.shipmentTracking.domain.repository.LatestTrackingLocationCache;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class RedisLatestTrackingLocationCache implements LatestTrackingLocationCache {

    private static final String KEY_PREFIX = "tracking:latest:";
    private static final String ID = "id";
    private static final String TRUCK_ID = "truckId";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String RECORDED_AT = "recordedAt";

    private final StringRedisTemplate redisTemplate;

    @Override
    public void save(TrackingLocation location) {
        String key = buildKey(location.getTruckId());

        redisTemplate.opsForHash().putAll(
                key,
                Map.of(
                        ID, location.getId().toString(),
                        TRUCK_ID, location.getTruckId().toString(),
                        LATITUDE, location.getLatitude().toPlainString(),
                        LONGITUDE, location.getLongitude().toPlainString(),
                        RECORDED_AT, location.getRecordedAt().toString()
                )
        );
    }

    @Override
    public Optional<TrackingLocation> findByTruckId(UUID truckId) {
        String key = buildKey(truckId);

        Map<Object, Object> values = redisTemplate.opsForHash().entries(key);

        if (values.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(
                TrackingLocation.builder()
                        .id(UUID.fromString((String) values.get(ID)))
                        .truckId(UUID.fromString((String) values.get(TRUCK_ID)))
                        .latitude(new BigDecimal((String) values.get(LATITUDE)))
                        .longitude(new BigDecimal((String) values.get(LONGITUDE)))
                        .recordedAt(LocalDateTime.parse((String) values.get(RECORDED_AT)))
                        .build()
        );
    }

    private String buildKey(UUID truckId) {
        return KEY_PREFIX + truckId;
    }
}
