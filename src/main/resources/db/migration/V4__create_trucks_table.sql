CREATE TABLE trucks (
    id UUID PRIMARY KEY,

    owner_id UUID NOT NULL,

    vehicle_number VARCHAR(50) NOT NULL UNIQUE,

    vehicle_type VARCHAR(50) NOT NULL,

    capacity DECIMAL(10,2) NOT NULL,

    driver_name VARCHAR(100) NOT NULL,

    driver_mobile VARCHAR(20) NOT NULL,

    status VARCHAR(50) NOT NULL
);