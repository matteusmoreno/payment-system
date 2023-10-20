package mgmgroup.paymentsystem.payment_document.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record IdPaymentDocumentRequest(
        @NotNull(message = "id is mandatory")
        UUID id) {
}
