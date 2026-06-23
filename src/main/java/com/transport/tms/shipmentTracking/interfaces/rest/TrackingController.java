package com.transport.tms.shipmentTracking.interfaces.rest;

import com.transport.tms.shipmentTracking.application.service.GetTruckLocationUseCase;
import com.transport.tms.shipmentTracking.application.service.UpdateTruckLocationUseCase;
import com.transport.tms.shipmentTracking.domain.model.TrackingLocation;
import com.transport.tms.shipmentTracking.interfaces.rest.request.UpdateLocationRequest;
import com.transport.tms.shipmentTracking.interfaces.rest.response.TrackingLocationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tracking")
@RequiredArgsConstructor
public class TrackingController {
    private final UpdateTruckLocationUseCase updateTruckLocationUseCase;
    private final GetTruckLocationUseCase getTruckLocationUseCase;

    @PostMapping("/update")
    public String updateLocation(@RequestBody UpdateLocationRequest request){
        updateTruckLocationUseCase.update(
                request.truckId(),
                request.latitude(),
                request.longitude()
        );

        return "Location Updated successfully";
    }
    @GetMapping("/latest/{truckId}")
    public TrackingLocationResponse latestLocation(@PathVariable UUID truckId){
        TrackingLocation location = getTruckLocationUseCase.get(truckId);

        return new TrackingLocationResponse(
                location.getTruckId(),
                location.getLatitude(),
                location.getLongitude(),
                location.getRecordedAt()
        );
    }
}
