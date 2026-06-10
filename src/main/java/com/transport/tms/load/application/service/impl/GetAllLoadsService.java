package com.transport.tms.load.application.service.impl;

import com.transport.tms.load.application.service.GetAllLoadsUseCase;
import com.transport.tms.load.domain.model.Load;
import com.transport.tms.load.infrastructure.persistence.LoadJpaRepository;
import com.transport.tms.load.interfaces.rest.response.LoadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllLoadsService implements GetAllLoadsUseCase {
    private final LoadJpaRepository loadJpaRepository;
    @Override
    public List<LoadResponse> getAllLoads() {
        return loadJpaRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private LoadResponse mapToResponse(Load load) {
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
