CREATE TABLE users
    (
        id BIGSERIAL
            PRIMARY KEY,
        email VARCHAR(350) NOT NULL
            UNIQUE,
        password VARCHAR(128) NOT NULL,
        avatar VARCHAR(2048) NULL,
        role VARCHAR(128) NOT NULL
            CHECK (role IN ('ROLE_USER', 'ROLE_ADMIN')),
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
