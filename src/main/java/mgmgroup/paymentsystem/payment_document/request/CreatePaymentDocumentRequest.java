package mgmgroup.paymentsystem.payment_document.request;

import jakarta.validation.constraints.NotNull;
import mgmgroup.paymentsystem.payment_document.constants.PaymentCurrency;
import mgmgroup.paymentsystem.payment_document.constants.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreatePaymentDocumentRequest(
        @NotNull(message = "Date of payment is mandatory")
        LocalDate dateOfPayment,
        @NotNull(message = "Amount is mandatory")
        BigDecimal amount,
        @NotNull(message = "Currency is mandatory")
        PaymentCurrency currency,
        @NotNull(message = "Payment type is mandatory")
        PaymentType paymentType) {
}
