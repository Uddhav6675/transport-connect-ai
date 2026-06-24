package com.transport.tms.load.interfaces.rest;

import com.transport.tms.load.application.service.CompleteTripUseCase;
import com.transport.tms.load.application.service.StartTripUseCase;
import com.transport.tms.load.interfaces.rest.request.CompleteTripRequest;
import com.transport.tms.load.interfaces.rest.request.StartTripRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/trips")
@RequiredArgsConstructor
public class TripController {

    private final StartTripUseCase startTripUseCase;
    private final CompleteTripUseCase completeTripUseCase;

    @PostMapping("/start")
    public String startTrip(@RequestBody StartTripRequest request){
        startTripUseCase.startTrip(request.loadId());
        return "Trip Started";
    }

    @PostMapping("/complete")
    public String completeTrip(@RequestBody CompleteTripRequest request){
        completeTripUseCase.completeTrip(request.loadId());

        return "Trip Completed";
    }
}
