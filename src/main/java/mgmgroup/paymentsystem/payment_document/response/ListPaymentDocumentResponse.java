package mgmgroup.paymentsystem.payment_document.response;

import mgmgroup.paymentsystem.customer.domain.Customer;
import mgmgroup.paymentsystem.payment_document.domain.PaymentDocument;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ListPaymentDocumentResponse(
        UUID id, LocalDate dateOfIssue,
        LocalDate dateOfPayment,
        BigDecimal amount,
        String currency,
        String paymentType,
        String status) {

    public ListPaymentDocumentResponse(PaymentDocument paymentDocument) {
        this(paymentDocument.getId(), paymentDocument.getDateOfIssue(), paymentDocument.getDateOfPayment(), paymentDocument.getAmount(),
                paymentDocument.getPaymentType().getDisplayName(), paymentDocument.getCurrency().getDisplayName(), paymentDocument.getStatus().getDisplayName());
    }
}
