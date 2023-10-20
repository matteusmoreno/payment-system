CREATE TABLE payment_document (
    id UUID NOT NULL,
    dateOfIssue DATE,
    dateOfPayment DATE,
    amount DECIMAL(19, 2),
    paymentType VARCHAR(255),
    currency VARCHAR(255),
    status VARCHAR(255),
    PRIMARY KEY (id)
);
