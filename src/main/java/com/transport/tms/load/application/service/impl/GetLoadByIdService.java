package com.transport.tms.load.application.service.impl;

import com.transport.tms.load.application.service.GetLoadByIdUseCase;
import com.transport.tms.load.domain.model.Load;
import com.transport.tms.load.infrastructure.persistence.LoadJpaRepository;
import com.transport.tms.load.interfaces.rest.response.LoadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetLoadByIdService implements GetLoadByIdUseCase {

    private final LoadJpaRepository loadJpaRepository;


    @Override
    public LoadResponse getLoadById(UUID loadId) {
        Load load = loadJpaRepository.findById(loadId)
                .orElseThrow(()-> new RuntimeException("Load Not Found"));

        return new LoadResponse(
                load.getId(),
                load.getSourceCity(),
                load.getDestinationCity(),
                load.getWeight(),
                load.getMaterialType(),
                load.getExpectedPrice(),
                load.getStatus().name()
        );
    }
}
