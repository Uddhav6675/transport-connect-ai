package com.transport.tms.fleet.interfaces.rest;

import com.transport.security.SecurityUtils;
import com.transport.tms.fleet.application.service.CreateTruckUseCase;
import com.transport.tms.fleet.application.service.GetMyTrucksUseCase;
import com.transport.tms.fleet.application.service.GetTruckByIdUseCase;
import com.transport.tms.fleet.application.service.UpdateTruckStatusUseCase;
import com.transport.tms.fleet.domain.model.Truck;
import com.transport.tms.fleet.interfaces.rest.request.CreateTruckRequest;
import com.transport.tms.fleet.interfaces.rest.request.rest.UpdateTruckStatusRequest;
import com.transport.tms.fleet.interfaces.rest.response.TruckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/fleet/trucks")
@RequiredArgsConstructor
public class TruckController {

    private final CreateTruckUseCase createTruckUseCase;

    private final GetMyTrucksUseCase getMyTrucksUseCase;

    private final GetTruckByIdUseCase getTruckByIdUseCase;

    private final UpdateTruckStatusUseCase updateTruckStatusUseCase;
    @PostMapping
    public ResponseEntity<TruckResponse> createTruck(@RequestBody CreateTruckRequest
                                                     request){
        return ResponseEntity.ok(
                createTruckUseCase.create(
                        request,
                        SecurityUtils.getCurrentUserId()
                )
        );
    }

    @GetMapping("/my-trucks")
    public ResponseEntity<List<TruckResponse>> myTrucks(){
        return ResponseEntity.ok(
                getMyTrucksUseCase.getMyTrucks(
                        SecurityUtils.getCurrentUserId()
                )
        );
    }
    @GetMapping("/{truckId}")
    public TruckResponse getTruckById(@PathVariable UUID truckId){
        Truck truck = getTruckByIdUseCase.execute(truckId);

        return new TruckResponse(
                truck.getId(),
                truck.getVehicleNumber(),
                truck.getVehicleType(),
                truck.getCapacity(),
                truck.getDriverName(),
                truck.getDriverMobile(),
                truck.getStatus()
        );
    }

    @PutMapping("/{truckId}/status")
    public TruckResponse updateStatus(@PathVariable UUID truckId,
                                      @RequestBody UpdateTruckStatusRequest request){
        Truck truck = updateTruckStatusUseCase.execute(truckId,
                request.status());

        return new TruckResponse(
                truck.getId(),
                truck.getVehicleNumber(),
                truck.getVehicleType(),
                truck.getCapacity(),
                truck.getDriverName(),
                truck.getDriverMobile(),
                truck.getStatus()
        );
    }


}
