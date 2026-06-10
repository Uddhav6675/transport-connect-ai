CREATE TABLE loads (
    id UUID PRIMARY KEY,
    source_city VARCHAR(100) NOT NULL,
    destination_city VARCHAR(100) NOT NULL,
    weight NUMERIC(10,2) NOT NULL,
    material_type VARCHAR(100),
    expected_price NUMERIC(15,2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    shipper_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL
);
