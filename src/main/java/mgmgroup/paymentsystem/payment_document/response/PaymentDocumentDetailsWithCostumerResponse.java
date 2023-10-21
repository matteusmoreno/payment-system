package mgmgroup.paymentsystem.payment_document.response;

import mgmgroup.paymentsystem.payment_document.domain.PaymentDocument;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PaymentDocumentDetailsWithCostumerResponse(
        UUID id,
        LocalDate dateOfIssue,
        LocalDate dateOfPayment,
        BigDecimal amount,
        UUID customerId,
        String currency,
        String paymentType,
        String status) {

    public PaymentDocumentDetailsWithCostumerResponse(PaymentDocument paymentDocument) {
        this(paymentDocument.getId(),
                paymentDocument.getDateOfIssue(),
                paymentDocument.getDateOfPayment(),
                paymentDocument.getAmount(),
                paymentDocument.getCustomer().getId(),
                paymentDocument.getCurrency().getDisplayName(),
                paymentDocument.getPaymentType().getDisplayName(),
                paymentDocument.getStatus().getDisplayName());
    }
}
