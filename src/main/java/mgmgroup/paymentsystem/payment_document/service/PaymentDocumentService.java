package mgmgroup.paymentsystem.payment_document.service;

import mgmgroup.paymentsystem.payment_document.PaymentDocumentRepository;
import mgmgroup.paymentsystem.payment_document.constants.PaymentStatus;
import mgmgroup.paymentsystem.payment_document.domain.PaymentDocument;
import mgmgroup.paymentsystem.payment_document.request.CreatePaymentDocumentRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PaymentDocumentService {

    private final PaymentDocumentRepository paymentDocumentRepository;

    public PaymentDocumentService(PaymentDocumentRepository paymentDocumentRepository) {
        this.paymentDocumentRepository = paymentDocumentRepository;
    }

    public PaymentDocument create(CreatePaymentDocumentRequest request) {
        PaymentDocument paymentDocument = new PaymentDocument();
        paymentDocument.setDateOfIssue(LocalDate.now());
        paymentDocument.setDateOfPayment(request.dateOfPayment());
        paymentDocument.setAmount(request.amount());
        paymentDocument.setPaymentType(request.paymentType());
        paymentDocument.setCurrency(request.currency());
        paymentDocument.setStatus(PaymentStatus.PENDING);

        paymentDocumentRepository.save(paymentDocument);

        return paymentDocument;
    }

    public PaymentDocument details(UUID id) {
        return paymentDocumentRepository.findById(id).orElseThrow();
    }
}
