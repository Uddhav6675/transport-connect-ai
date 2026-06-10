package com.transport.tms.load.application.service;

import com.transport.tms.load.interfaces.rest.response.LoadResponse;

import java.util.UUID;

public interface GetLoadByIdUseCase {
    LoadResponse getLoadById(UUID loadId);
}
