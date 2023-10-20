package mgmgroup.paymentsystem.customer.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mgmgroup.paymentsystem.customer.request.CreateCustomerRequest;
import mgmgroup.paymentsystem.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreateCustomerRequest request) {
        customerService.create(request);
        return ResponseEntity.ok().build();
    }
}
