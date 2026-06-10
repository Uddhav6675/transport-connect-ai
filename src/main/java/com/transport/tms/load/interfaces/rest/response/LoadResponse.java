package com.transport.tms.load.interfaces.rest.response;

import java.util.UUID;

public record LoadResponse(
        UUID id,
        String sourceCity,
        String destinationCity,
        java.math.BigDecimal weight,
        String materialType,
        java.math.BigDecimal expectedPrice,
        String status
) {
}
