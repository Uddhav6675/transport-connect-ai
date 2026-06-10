package com.transport.tms.fleet.interfaces.rest.request;

import com.transport.tms.fleet.domain.model.TruckStatus;

public record UpdateTruckStatusRequest(
        TruckStatus status
) {
}
