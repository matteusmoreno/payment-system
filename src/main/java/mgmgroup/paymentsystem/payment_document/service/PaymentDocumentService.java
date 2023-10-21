package mgmgroup.paymentsystem.payment_document.service;

import mgmgroup.paymentsystem.customer.CustomerRepository;
import mgmgroup.paymentsystem.customer.domain.Customer;
import mgmgroup.paymentsystem.payment_document.request.SetPaymentDocumentRequest;
import mgmgroup.paymentsystem.payment_document.PaymentDocumentRepository;
import mgmgroup.paymentsystem.payment_document.constants.PaymentStatus;
import mgmgroup.paymentsystem.payment_document.domain.PaymentDocument;
import mgmgroup.paymentsystem.payment_document.request.CreatePaymentDocumentRequest;
import mgmgroup.paymentsystem.payment_document.request.UpdatePaymentDocumentRequest;
import mgmgroup.paymentsystem.payment_document.response.ListPaymentDocumentResponse;
import mgmgroup.paymentsystem.payment_document.response.PaymentDocumentDetailsResponse;
import mgmgroup.paymentsystem.payment_document.validation.PaymentDocumentValidation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentDocumentService {

    private final PaymentDocumentRepository paymentDocumentRepository;
    private final PaymentDocumentValidation paymentDocumentValidation;
    private final PaymentDocumentUtils paymentDocumentUtils;
    private final CustomerRepository customerRepository;

    public PaymentDocumentService(PaymentDocumentRepository paymentDocumentRepository, PaymentDocumentValidation paymentDocumentValidation, PaymentDocumentUtils paymentDocumentUtils, CustomerRepository customerRepository) {
        this.paymentDocumentRepository = paymentDocumentRepository;
        this.paymentDocumentValidation = paymentDocumentValidation;
        this.paymentDocumentUtils = paymentDocumentUtils;
        this.customerRepository = customerRepository;
    }

    public PaymentDocument create(CreatePaymentDocumentRequest request) {
        PaymentDocument paymentDocument = new PaymentDocument();
        paymentDocumentUtils.settCreateAttributes(paymentDocument, request);

        paymentDocumentRepository.save(paymentDocument);

        return paymentDocument;
    }

    public PaymentDocument details(UUID id) {
        return paymentDocumentRepository.findById(id).orElseThrow();
    }

    public PaymentDocument update(UpdatePaymentDocumentRequest request) {
        PaymentDocument paymentDocument = paymentDocumentRepository.findById(request.id()).orElseThrow();
        paymentDocumentUtils.setUpdateAttributes(paymentDocument, request);

        paymentDocumentRepository.save(paymentDocument);

        return paymentDocument;

    }

    public PaymentDocument pay(UUID id) {
        PaymentDocument paymentDocument = paymentDocumentRepository.findById(id).orElseThrow();
        paymentDocumentValidation.payValidation(paymentDocument.getStatus());
        paymentDocument.setStatus(PaymentStatus.PAID);

        paymentDocumentRepository.save(paymentDocument);

        return paymentDocument;
    }

    public PaymentDocument refund(UUID id) {
        PaymentDocument paymentDocument = paymentDocumentRepository.findById(id).orElseThrow();
        paymentDocumentValidation.refundValidation(paymentDocument.getStatus());
        paymentDocument.setStatus(PaymentStatus.REFUNDED);

        paymentDocumentRepository.save(paymentDocument);

        return paymentDocument;
    }

    public PaymentDocument cancel(UUID id) {
        PaymentDocument paymentDocument = paymentDocumentRepository.findById(id).orElseThrow();
        paymentDocumentValidation.cancelValidation(paymentDocument.getStatus());
        paymentDocument.setStatus(PaymentStatus.CANCELLED);

        paymentDocumentRepository.save(paymentDocument);

        return paymentDocument;
    }

    public PaymentDocument setPaymentDocument(SetPaymentDocumentRequest request) {
        Customer customer = customerRepository.findById(request.customerId()).orElseThrow();
        PaymentDocument paymentDocument = paymentDocumentRepository.findById(request.paymentDocumentId()).orElseThrow();

        paymentDocument.setCustomer(customer);
        customer.getPaymentDocuments().add(paymentDocument);
        customerRepository.save(customer);

        return paymentDocument;
    }

    public Page<ListPaymentDocumentResponse> listAll(Pageable pageable) {
        return paymentDocumentRepository.findAll(pageable).map(ListPaymentDocumentResponse::new);
    }

}
