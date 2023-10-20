package mgmgroup.paymentsystem.payment_document.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mgmgroup.paymentsystem.payment_document.request.CreatePaymentDocumentRequest;
import mgmgroup.paymentsystem.payment_document.service.PaymentDocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment_document")
public class PaymentDocumentController {

    private final PaymentDocumentService paymentDocumentService;

    public PaymentDocumentController(PaymentDocumentService paymentDocumentService) {
        this.paymentDocumentService = paymentDocumentService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreatePaymentDocumentRequest request) {
        paymentDocumentService.create(request);
        return ResponseEntity.ok().build();
    }
}
