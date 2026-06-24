package com.transport.tms.driver.interfaces.rest;

import com.transport.tms.driver.application.service.CreateDriverUseCase;
import com.transport.tms.driver.interfaces.rest.request.CreateDriverRequest;
import com.transport.tms.load.interfaces.rest.request.CompleteTripRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/drivers")
@RequiredArgsConstructor
public class DriverController {
    private final CreateDriverUseCase createDriverUseCase;

    @PostMapping
    public String createDriver(@RequestBody CreateDriverRequest request){
        createDriverUseCase.create(request);
        return "Driver created successfully";
    }
}
