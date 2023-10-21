package mgmgroup.paymentsystem.customer.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mgmgroup.paymentsystem.customer.request.CreateCustomerRequest;
import mgmgroup.paymentsystem.customer.request.IdCustomerRequest;
import mgmgroup.paymentsystem.customer.request.UpdateCustomerRequest;
import mgmgroup.paymentsystem.customer.response.CustomerDetailsResponse;
import mgmgroup.paymentsystem.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreateCustomerRequest request, UriComponentsBuilder uriBuilder) {
        var customer = customerService.create(request);
        var uri = uriBuilder.path("/customer/details/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomerDetailsResponse(customer));
    }

    @GetMapping("/details")
    public ResponseEntity details(@RequestBody @Valid IdCustomerRequest request) {
        var customer = customerService.details(request.id());
        return ResponseEntity.ok(new CustomerDetailsResponse(customer));
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateCustomerRequest request) {
        var customer = customerService.update(request);
        return ResponseEntity.ok(new CustomerDetailsResponse(customer));
    }

    @DeleteMapping("/desactivate")
    @Transactional
    public ResponseEntity desactivate(@RequestBody @Valid IdCustomerRequest request) {
        var customer = customerService.desactivate(request.id());
        return ResponseEntity.ok(new CustomerDetailsResponse(customer));
    }


}
