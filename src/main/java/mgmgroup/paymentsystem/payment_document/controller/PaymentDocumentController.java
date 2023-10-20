package mgmgroup.paymentsystem.payment_document.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mgmgroup.paymentsystem.payment_document.request.CreatePaymentDocumentRequest;
import mgmgroup.paymentsystem.payment_document.request.IdPaymentDocumentRequest;
import mgmgroup.paymentsystem.payment_document.request.PaymentDocumentDetailsRequest;
import mgmgroup.paymentsystem.payment_document.request.UpdatePaymentDocumentRequest;
import mgmgroup.paymentsystem.payment_document.response.PaymentDocumentDetailsResponse;
import mgmgroup.paymentsystem.payment_document.service.PaymentDocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/payment_document")
public class PaymentDocumentController {

    private final PaymentDocumentService paymentDocumentService;

    public PaymentDocumentController(PaymentDocumentService paymentDocumentService) {
        this.paymentDocumentService = paymentDocumentService;
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreatePaymentDocumentRequest request, UriComponentsBuilder uriBuilder) {
        var paymentDocument = paymentDocumentService.create(request);
        var uri = uriBuilder.path("/payment_document/details/{id}").buildAndExpand(paymentDocument.getId()).toUri();
        return ResponseEntity.created(uri).body(new PaymentDocumentDetailsResponse(paymentDocument));
    }

    @GetMapping("/details")
    public ResponseEntity details(@RequestBody @Valid PaymentDocumentDetailsRequest request) {
        var paymentDocument = paymentDocumentService.details(request.id());
        return ResponseEntity.ok(new PaymentDocumentDetailsResponse(paymentDocument));
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdatePaymentDocumentRequest request) {
        var paymentDocument = paymentDocumentService.update(request);
        return ResponseEntity.ok(new PaymentDocumentDetailsResponse(paymentDocument));
    }

    @PutMapping("/pay")
    @Transactional
    public ResponseEntity pay(@RequestBody @Valid IdPaymentDocumentRequest request) {
        var paymentDocument = paymentDocumentService.pay(request.id());
        return ResponseEntity.ok(new PaymentDocumentDetailsResponse(paymentDocument));
    }
}
