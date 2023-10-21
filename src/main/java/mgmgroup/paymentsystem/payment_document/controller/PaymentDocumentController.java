package mgmgroup.paymentsystem.payment_document.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mgmgroup.paymentsystem.payment_document.PaymentDocumentRepository;
import mgmgroup.paymentsystem.payment_document.request.SetPaymentDocumentRequest;
import mgmgroup.paymentsystem.payment_document.request.CreatePaymentDocumentRequest;
import mgmgroup.paymentsystem.payment_document.request.IdPaymentDocumentRequest;
import mgmgroup.paymentsystem.payment_document.request.PaymentDocumentDetailsRequest;
import mgmgroup.paymentsystem.payment_document.request.UpdatePaymentDocumentRequest;
import mgmgroup.paymentsystem.payment_document.response.ListPaymentDocumentResponse;
import mgmgroup.paymentsystem.payment_document.response.PaymentDocumentDetailsResponse;
import mgmgroup.paymentsystem.payment_document.response.PaymentDocumentDetailsWithCostumerResponse;
import mgmgroup.paymentsystem.payment_document.service.PaymentDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/payment_document")
public class PaymentDocumentController {

    private final PaymentDocumentService paymentDocumentService;
    @Autowired
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

    @PostMapping("/set-payment-document")
    @Transactional
    public ResponseEntity setPaymentDocument(@RequestBody @Valid SetPaymentDocumentRequest request) {
        var paymentDocument = paymentDocumentService.setPaymentDocument(request);
        return ResponseEntity.ok(new PaymentDocumentDetailsWithCostumerResponse(paymentDocument));
    }

    @GetMapping("/details")
    public ResponseEntity details(@RequestBody @Valid PaymentDocumentDetailsRequest request) {
        var paymentDocument = paymentDocumentService.details(request.id());
        return ResponseEntity.ok(new PaymentDocumentDetailsResponse(paymentDocument));
    }

    @GetMapping("/list")
    public ResponseEntity<Page<ListPaymentDocumentResponse>> list(@PageableDefault(sort = {"dateOfPayment"}) Pageable pageable) {
        var page = paymentDocumentService.listAll(pageable);

        return ResponseEntity.ok(page);
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

    @PutMapping("/refund")
    @Transactional
    public ResponseEntity refund(@RequestBody @Valid IdPaymentDocumentRequest request) {
        var paymentDocument = paymentDocumentService.refund(request.id());
        return ResponseEntity.ok(new PaymentDocumentDetailsResponse(paymentDocument));
    }

    @PutMapping("/cancel")
    @Transactional
    public ResponseEntity cancel(@RequestBody @Valid IdPaymentDocumentRequest request) {
        var paymentDocument = paymentDocumentService.cancel(request.id());
        return ResponseEntity.ok(new PaymentDocumentDetailsResponse(paymentDocument));
    }
}
