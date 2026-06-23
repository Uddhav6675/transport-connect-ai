package com.transport.tms.driver.application.service.impl;

import com.transport.security.SecurityUtils;
import com.transport.tms.driver.application.service.CreateDriverUseCase;
import com.transport.tms.driver.domain.model.Driver;
import com.transport.tms.driver.domain.model.DriverStatus;
import com.transport.tms.driver.domain.repository.DriverRepository;
import com.transport.tms.driver.interfaces.rest.request.CreateDriverRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateDriverService implements CreateDriverUseCase {

    private final DriverRepository driverRepository;
    @Override
    public void create(CreateDriverRequest request) {
        Driver driver = Driver.builder()
                .ownerId(SecurityUtils.getCurrentUserId())
                .name(request.name())
                .mobile(request.mobile())
                .licenseNumber(request.licenseNumber())
                .status(DriverStatus.AVAILABLE)
                .build();

        driverRepository.save(driver);
    }
}
