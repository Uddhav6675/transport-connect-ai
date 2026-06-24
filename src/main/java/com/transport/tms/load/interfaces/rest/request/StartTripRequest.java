package com.transport.tms.load.interfaces.rest.request;

import java.util.UUID;

public record StartTripRequest(
        UUID loadId
) {
}
