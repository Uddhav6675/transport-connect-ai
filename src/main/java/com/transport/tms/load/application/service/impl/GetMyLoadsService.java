package com.transport.tms.load.application.service.impl;

import com.transport.security.SecurityUtils;
import com.transport.tms.load.application.service.GetMyLoadsUseCase;
import com.transport.tms.load.infrastructure.persistence.LoadJpaRepository;
import com.transport.tms.load.interfaces.rest.response.LoadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetMyLoadsService implements GetMyLoadsUseCase {

    private final LoadJpaRepository loadJpaRepository;

    @Override
    public List<LoadResponse> getMyLoads() {
        UUID shipperId = SecurityUtils.getCurrentUserId();
        return loadJpaRepository.findByShipperId(shipperId)
                .stream()
                .map(load -> new LoadResponse(
                        load.getId(),
                        load.getSourceCity(),
                        load.getDestinationCity(),
                        load.getWeight(),
                        load.getMaterialType(),
                        load.getExpectedPrice(),
                        load.getStatus().name()
                ))
                .toList();
    }
}
