CREATE TABLE tracking_locations(
    id UUID PRIMARY KEY,
    truck_id UUID NOT NULL,
    latitude DECIMAL(10,8) NOT NULL,
    longitude DECIMAL(11,8) NOT NULL,
    recorded_at TIMESTAMP NOT NULL
);