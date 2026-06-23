package com.transport.tms.loadmatching.interfaces.rest;

import com.transport.tms.loadmatching.application.service.AssignTruckToLoadUseCase;
import com.transport.tms.loadmatching.interfaces.rest.request.AssignTruckRequest;
import com.transport.tms.loadmatching.interfaces.rest.response.AssignmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/load-matching")
@RequiredArgsConstructor
public class LoadMatchinngController {

    private final AssignTruckToLoadUseCase assignTruckToLoadUseCase;

    @PostMapping("/assign")
    public AssignmentResponse assignmentResponse(@RequestBody AssignTruckRequest request){
        assignTruckToLoadUseCase.assign(
                request.loadId(),
                request.truckId()
        );

        return new AssignmentResponse("Truck assigned successfully");
    }
}
