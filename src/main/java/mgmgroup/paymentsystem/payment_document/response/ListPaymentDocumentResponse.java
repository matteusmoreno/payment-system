package mgmgroup.paymentsystem.payment_document.response;

import mgmgroup.paymentsystem.customer.domain.Customer;
import mgmgroup.paymentsystem.payment_document.domain.PaymentDocument;

import java.time.LocalDate;
import java.util.UUID;

public record ListPaymentDocumentResponse(
        UUID id, LocalDate dateOfIssue,
        LocalDate dateOfPayment,
        String paymentType,
        String currency,
        String status) {

    public ListPaymentDocumentResponse(PaymentDocument paymentDocument) {
        this(paymentDocument.getId(), paymentDocument.getDateOfIssue(), paymentDocument.getDateOfPayment(),
                paymentDocument.getPaymentType().getDisplayName(), paymentDocument.getCurrency().getDisplayName(), paymentDocument.getStatus().getDisplayName());
    }
}
