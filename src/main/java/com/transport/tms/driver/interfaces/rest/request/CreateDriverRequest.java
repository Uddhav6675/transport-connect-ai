package com.transport.tms.driver.interfaces.rest.request;

import org.apache.kafka.common.protocol.types.Field;

public record CreateDriverRequest(
        String name,
        String mobile,
        String licenseNumber
) {
}
