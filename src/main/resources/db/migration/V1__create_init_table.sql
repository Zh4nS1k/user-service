CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       email VARCHAR(255) NOT NULL,
                       login VARCHAR(255) NOT NULL,
                       full_name VARCHAR(255) NOT NULL

);
