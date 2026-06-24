package com.transport.tms.driver.application.service;

import com.transport.tms.driver.interfaces.rest.request.CreateDriverRequest;

public interface CreateDriverUseCase {
    void create(CreateDriverRequest request);
}
