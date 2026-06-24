package com.transport.tms.load.application.service.impl;

import com.transport.common.exception.InvalidLoadStateException;
import com.transport.common.exception.LoadNotFoundException;
import com.transport.tms.load.application.service.StartTripUseCase;
import com.transport.tms.load.domain.enums.LoadStatus;
import com.transport.tms.load.domain.model.Load;
import com.transport.tms.load.domain.repository.LoadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class StartTripService implements StartTripUseCase {

    private final LoadRepository loadRepository;
    @Override
    public void startTrip(UUID loadId) {
        Load load = loadRepository.findById(loadId)
                .orElseThrow(()-> new LoadNotFoundException("Load not found"));

        if (load.getStatus() != LoadStatus.ASSIGNED){
            throw new InvalidLoadStateException("Only assigned loads can start trip");
        }

        load.setStatus(LoadStatus.IN_TRANSIT);
        loadRepository.save(load);
    }
}
