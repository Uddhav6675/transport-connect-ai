package com.transport.tms.fleet.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "trucks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private UUID ownerId;
    @Column(nullable = false, unique = true)
    private String vehicleNumber;
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    @Column(nullable = false)
    private BigDecimal capacity;
    private  String driverName;
    private String driverMobile;
    @Enumerated(EnumType.STRING)
    private TruckStatus status;
}
