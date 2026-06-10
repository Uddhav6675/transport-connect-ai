package com.transport.tms.load.application.service;

import com.transport.tms.load.interfaces.rest.response.LoadResponse;

import java.util.List;

public interface GetMyLoadsUseCase {

    List<LoadResponse> getMyLoads();
}
