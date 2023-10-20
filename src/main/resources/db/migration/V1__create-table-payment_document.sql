CREATE TABLE payment_document (
    id BINARY(16) NOT NULL,
    date_of_issue DATE,
    date_of_payment DATE,
    amount DECIMAL(19, 2),
    payment_type VARCHAR(255),
    currency VARCHAR(255),
    status VARCHAR(255),
    PRIMARY KEY (id)
);
