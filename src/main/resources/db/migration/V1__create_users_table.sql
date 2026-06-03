CREATE TABLE users (
    id UUID PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(255) UNIQUE,
    mobile_number VARCHAR(20),
    password VARCHAR(255),
    role VARCHAR(50),
    status VARCHAR(50),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);