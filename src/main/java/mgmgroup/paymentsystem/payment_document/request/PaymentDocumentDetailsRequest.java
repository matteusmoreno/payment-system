package mgmgroup.paymentsystem.payment_document.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PaymentDocumentDetailsRequest(
        @NotNull(message = "Id is mandatory")
        UUID id) {
}
