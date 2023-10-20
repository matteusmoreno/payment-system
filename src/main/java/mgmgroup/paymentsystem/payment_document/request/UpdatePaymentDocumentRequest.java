package mgmgroup.paymentsystem.payment_document.request;

import jakarta.validation.constraints.NotNull;
import mgmgroup.paymentsystem.payment_document.constants.PaymentCurrency;
import mgmgroup.paymentsystem.payment_document.constants.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record UpdatePaymentDocumentRequest(
        @NotNull(message = "id is mandatory")
        UUID id,
        LocalDate dateOfPayment,
        BigDecimal amount,
        PaymentType paymentType,
        PaymentCurrency currency) {
}
