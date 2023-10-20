package mgmgroup.paymentsystem.payment_document.response;

import mgmgroup.paymentsystem.payment_document.constants.PaymentCurrency;
import mgmgroup.paymentsystem.payment_document.constants.PaymentStatus;
import mgmgroup.paymentsystem.payment_document.constants.PaymentType;
import mgmgroup.paymentsystem.payment_document.domain.PaymentDocument;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PaymentDocumentDetailsResponse(
        UUID id,
        LocalDate dateOfIssue,
        LocalDate dateOfPayment,
        BigDecimal amount,
        PaymentCurrency currency,
        PaymentType paymentType,
        PaymentStatus status) {

    public PaymentDocumentDetailsResponse(PaymentDocument paymentDocument) {
        this(paymentDocument.getId(),
                paymentDocument.getDateOfIssue(),
                paymentDocument.getDateOfPayment(),
                paymentDocument.getAmount(),
                paymentDocument.getCurrency(),
                paymentDocument.getPaymentType(),
                paymentDocument.getStatus());
    }
}
