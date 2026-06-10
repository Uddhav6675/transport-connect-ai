package com.transport.tms.load.interfaces.rest.request;

public record CreateLoadRequest(
        String sourceCity,
        String destinationCity,
        Double weight,
        String materialType,
        Double expectedPrice
) {
}
