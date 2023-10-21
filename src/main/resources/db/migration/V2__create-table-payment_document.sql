CREATE TABLE payment_document (
    id binary(16) NOT NULL,
    date_of_issue DATE,
    date_of_payment DATE,
    amount DECIMAL(19, 2),
    payment_type VARCHAR(255),
    currency VARCHAR(255),
    status VARCHAR(255),
    customer_id binary(16), -- Adiciona a coluna para representar o relacionamento com o cliente
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer (id) -- Chave estrangeira para o cliente
);
