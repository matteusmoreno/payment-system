CREATE TABLE customer (
    id binary(16) NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(20),
    birth_date DATE,
    age INT,
    gender VARCHAR(10),
    cpf VARCHAR(15) UNIQUE,
    cep VARCHAR(10),
    state VARCHAR(50),
    city VARCHAR(50),
    neighborhood VARCHAR(150),
    created_at DATETIME,
    updated_at DATETIME,
    deleted_at DATETIME,
    active TINYINT(1),
    PRIMARY KEY (id)
);
