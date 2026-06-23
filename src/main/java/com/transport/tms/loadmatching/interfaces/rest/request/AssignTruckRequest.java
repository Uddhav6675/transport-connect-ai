package com.transport.tms.loadmatching.interfaces.rest.request;

import java.util.UUID;

public record AssignTruckRequest(
        UUID loadId,
        UUID truckId
) {
}
