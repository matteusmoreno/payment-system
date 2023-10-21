package mgmgroup.paymentsystem.payment_document.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SetPaymentDocumentRequest(
        @NotNull(message = "Customer id is mandatory")
        UUID customerId,
        @NotNull(message = "Payment document id is mandatory")
        UUID paymentDocumentId) {
}
