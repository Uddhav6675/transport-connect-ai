package com.transport.tms.fleet.application.service;

import com.transport.tms.fleet.domain.model.Truck;
import com.transport.tms.fleet.domain.model.TruckStatus;
import com.transport.tms.fleet.domain.repository.TruckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateTruckStatusUseCase {
    private final TruckRepository truckRepository;

    public Truck execute(UUID truckId, String status){
        Truck truck = truckRepository.findById(truckId)
                .orElseThrow(()-> new RuntimeException("Truck not found"));

        truck.setStatus(
                TruckStatus.valueOf(status.toUpperCase())
        );
        return truckRepository.save(truck);
    }

}
