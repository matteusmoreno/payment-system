package mgmgroup.paymentsystem.payment_document.service;

import mgmgroup.paymentsystem.payment_document.PaymentDocumentRepository;
import mgmgroup.paymentsystem.payment_document.constants.PaymentStatus;
import mgmgroup.paymentsystem.payment_document.domain.PaymentDocument;
import mgmgroup.paymentsystem.payment_document.request.CreatePaymentDocumentRequest;
import mgmgroup.paymentsystem.payment_document.request.UpdatePaymentDocumentRequest;
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

    public PaymentDocument update(UpdatePaymentDocumentRequest request) {
        PaymentDocument paymentDocument = paymentDocumentRepository.findById(request.id()).orElseThrow();
        paymentDocument.setDateOfPayment(request.dateOfPayment());
        paymentDocument.setAmount(request.amount());
        paymentDocument.setPaymentType(request.paymentType());
        paymentDocument.setCurrency(request.currency());

        paymentDocumentRepository.save(paymentDocument);

        return paymentDocument;

    }

    public PaymentDocument pay(UUID id) {
        PaymentDocument paymentDocument = paymentDocumentRepository.findById(id).orElseThrow();
        paymentDocument.setStatus(PaymentStatus.PAID);

        paymentDocumentRepository.save(paymentDocument);

        return paymentDocument;
    }

    public PaymentDocument refund(UUID id) {
        PaymentDocument paymentDocument = paymentDocumentRepository.findById(id).orElseThrow();
        paymentDocument.setStatus(PaymentStatus.REFUNDED);

        paymentDocumentRepository.save(paymentDocument);

        return paymentDocument;
    }
}
