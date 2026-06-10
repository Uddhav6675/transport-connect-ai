package com.transport.tms.fleet.application.service;

import com.transport.tms.fleet.domain.repository.TruckRepository;
import com.transport.tms.fleet.interfaces.rest.response.TruckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetMyTrucksUseCase {

    private final TruckRepository truckRepository;

    public List<TruckResponse> getMyTrucks(UUID ownerId){
        return truckRepository.findByOwnerId(ownerId)
                .stream()
                .map(truck -> new TruckResponse(
                        truck.getId(),
                        truck.getVehicleNumber(),
                        truck.getVehicleType(),
                        truck.getCapacity(),
                        truck.getDriverName(),
                        truck.getDriverMobile(),
                        truck.getStatus()
                )).toList();
    }
}
