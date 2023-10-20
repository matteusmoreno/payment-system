package mgmgroup.paymentsystem.payment_document.service;

import mgmgroup.paymentsystem.payment_document.constants.PaymentStatus;
import mgmgroup.paymentsystem.payment_document.domain.PaymentDocument;
import mgmgroup.paymentsystem.payment_document.request.CreatePaymentDocumentRequest;
import mgmgroup.paymentsystem.payment_document.request.UpdatePaymentDocumentRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

@Component
public class PaymentDocumentUtils {

    public void settCreateAttributes(PaymentDocument paymentDocument, CreatePaymentDocumentRequest request) {
        paymentDocument.setDateOfIssue(LocalDate.now());
        paymentDocument.setDateOfPayment(request.dateOfPayment());
        paymentDocument.setAmount(request.amount());
        paymentDocument.setPaymentType(request.paymentType());
        paymentDocument.setCurrency(request.currency());
        paymentDocument.setStatus(PaymentStatus.PENDING);
    }

    public void setUpdateAttributes(PaymentDocument paymentDocument, UpdatePaymentDocumentRequest request) {
        if (request.dateOfPayment() != paymentDocument.getDateOfPayment()) {
            paymentDocument.setDateOfPayment(request.dateOfPayment());
        }
        if (!Objects.equals(request.amount(), paymentDocument.getAmount())) {
            paymentDocument.setAmount(request.amount());
        }
        if (request.paymentType() != paymentDocument.getPaymentType()) {
            paymentDocument.setPaymentType(request.paymentType());
        }
        if (request.currency() != paymentDocument.getCurrency()) {
            paymentDocument.setCurrency(request.currency());
        }
    }
}
