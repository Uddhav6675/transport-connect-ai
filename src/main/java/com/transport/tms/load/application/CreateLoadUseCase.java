package com.transport.tms.load.application;

import com.transport.tms.load.domain.enums.LoadStatus;
import com.transport.tms.load.domain.model.Load;
import com.transport.tms.load.domain.repository.LoadRepository;
import com.transport.tms.load.interfaces.rest.request.CreateLoadRequest;
import com.transport.tms.load.interfaces.rest.response.LoadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateLoadUseCase {
    private final LoadRepository loadRepository;

    public LoadResponse create(CreateLoadRequest request, UUID shipperId){
        Load load = Load.builder()
                .sourceCity(request.sourceCity())
                .destinationCity(request.destinationCity())
                .weight(BigDecimal.valueOf(request.weight()))
                .materialType(request.materialType())
                .expectedPrice(BigDecimal.valueOf(request.expectedPrice()))
                .shipperId(shipperId)
                .status(LoadStatus.OPEN)
                .createdAt(Instant.now())
                .build();
        load = loadRepository.save(load);

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
