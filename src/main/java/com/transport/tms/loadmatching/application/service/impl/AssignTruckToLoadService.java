package com.transport.tms.loadmatching.application.service.impl;

import com.transport.common.exception.ResourceNotFoundException;
import com.transport.tms.fleet.domain.model.Truck;
import com.transport.tms.fleet.domain.model.TruckStatus;
import com.transport.tms.fleet.domain.repository.TruckRepository;
import com.transport.tms.load.domain.enums.LoadStatus;
import com.transport.tms.load.domain.model.Load;
import com.transport.tms.load.domain.repository.LoadRepository;
import com.transport.tms.loadmatching.application.service.AssignTruckToLoadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class AssignTruckToLoadService implements AssignTruckToLoadUseCase {

    private final LoadRepository loadRepository;
    private final TruckRepository truckRepository;

    @Override
    public void assign(UUID loadId, UUID truckId) {

        Load load = loadRepository.findById(loadId)
                .orElseThrow(() -> new ResourceNotFoundException("Load not found"));

        Truck truck = truckRepository.findById(truckId)
                .orElseThrow(() -> new ResourceNotFoundException("Truck not found"));

        if (load.getStatus() != LoadStatus.OPEN) {
            throw new RuntimeException("Load can't be assigned. Current status:" + load.getStatus());
        }

        if (truck.getStatus() != TruckStatus.AVAILABLE) {
            throw new RuntimeException("Truck is not available. Current status:" + truck.getStatus());
        }

        load.setStatus(LoadStatus.ASSIGNED);
        truck.setStatus(TruckStatus.ON_TRIP);

        loadRepository.save(load);
        truckRepository.save(truck);
    }
}
