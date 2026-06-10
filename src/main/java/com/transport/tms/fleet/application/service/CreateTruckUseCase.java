package com.transport.tms.fleet.application.service;

import com.transport.tms.fleet.domain.model.Truck;
import com.transport.tms.fleet.domain.model.TruckStatus;
import com.transport.tms.fleet.domain.repository.TruckRepository;
import com.transport.tms.fleet.interfaces.rest.request.CreateTruckRequest;
import com.transport.tms.fleet.interfaces.rest.response.TruckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateTruckUseCase {
    private final TruckRepository truckRepository;

    public TruckResponse create(CreateTruckRequest
                                request, UUID ownerId){
        Truck truck = Truck.builder()
                .ownerId(ownerId)
                .vehicleNumber(request.vehicleNumber())
                .vehicleType(request.vehicleType())
                .capacity(BigDecimal.valueOf(request.capacity()))
                .driverName(request.driverName())
                .driverMobile(request.driverMobile())
                .status(TruckStatus.AVAILABLE)
                .build();

        Truck saved = truckRepository.save(truck);

        return new TruckResponse(
                saved.getId(),
                saved.getVehicleNumber(),
                saved.getVehicleType(),
                saved.getCapacity(),
                saved.getDriverName(),
                saved.getDriverMobile(),
                saved.getStatus()
        );
    }
}
