package com.transport.tms.load.domain.model;

import com.transport.tms.load.domain.enums.LoadStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
@Entity
@Table(name = "loads")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String sourceCity;

    private String destinationCity;
    @Column(nullable = false)
    private BigDecimal weight;
    private String materialType;
    @Column(name = "expected_price")
    private BigDecimal expectedPrice;
    @Enumerated(EnumType.STRING)
    private LoadStatus status;
    private UUID shipperId;
    private Instant createdAt;
    @Column(name = "assigned_truck_id")
    private UUID assignedTruckId;
}
