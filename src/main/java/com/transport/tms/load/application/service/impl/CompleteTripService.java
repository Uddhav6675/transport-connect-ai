package com.transport.tms.load.application.service.impl;

import com.transport.common.exception.InvalidLoadStateException;
import com.transport.common.exception.LoadNotFoundException;
import com.transport.tms.load.application.service.CompleteTripUseCase;
import com.transport.tms.load.domain.enums.LoadStatus;
import com.transport.tms.load.domain.model.Load;
import com.transport.tms.load.domain.repository.LoadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompleteTripService implements CompleteTripUseCase {
    private final LoadRepository loadRepository;

    @Override
    public void completeTrip(UUID loadId) {
        Load load = loadRepository.findById(loadId)
                .orElseThrow(()-> new LoadNotFoundException("Load not Found"));

        if(load.getStatus() != LoadStatus.IN_TRANSIT){
            throw new InvalidLoadStateException("Load must be IN_TRANSIT");
        }

        load.setStatus(LoadStatus.DELIVERED);
        loadRepository.save(load);
    }
}
