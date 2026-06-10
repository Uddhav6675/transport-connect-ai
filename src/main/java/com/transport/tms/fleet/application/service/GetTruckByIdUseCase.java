package com.transport.tms.fleet.application.service;

import com.transport.tms.fleet.domain.model.Truck;
import com.transport.tms.fleet.domain.repository.TruckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetTruckByIdUseCase {
    private final TruckRepository truckRepository;

    public Truck execute(UUID truckId){
        return truckRepository.findById(truckId)
                .orElseThrow(()-> new RuntimeException("Truck not found"));
    }
}
