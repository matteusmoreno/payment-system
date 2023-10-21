package mgmgroup.paymentsystem.customer.service;

import mgmgroup.paymentsystem.customer.CustomerRepository;
import mgmgroup.paymentsystem.customer.domain.Customer;
import mgmgroup.paymentsystem.customer.request.CreateCustomerRequest;
import mgmgroup.paymentsystem.customer.request.UpdateCustomerRequest;
import mgmgroup.paymentsystem.customer.validation.CustomerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerUtils customerUtils;
    private final CustomerValidation customerValidation;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerUtils customerUtils, CustomerValidation customerValidation) {
        this.customerRepository = customerRepository;
        this.customerUtils = customerUtils;
        this.customerValidation = customerValidation;
    }

    public Customer create(CreateCustomerRequest request) {
        customerValidation.isCpfValid(request.cpf()); // VALIDA O CPF
        customerValidation.isCepValid(request.cep()); // VALIDA O CEP

        Customer customer = new Customer();
        customerUtils.setCreateAttributes(customer, request);
        customerRepository.save(customer);

        return customer;

    }

    public Customer details(UUID id) {
        return customerRepository.findById(id).orElseThrow();
    }

    public Customer update(UpdateCustomerRequest request) {
        Customer customer = customerRepository.findById(request.id()).orElseThrow();
        customerUtils.setUpdateAttributes(customer, request);

        customer.setUpdatedAt(LocalDateTime.now());
        customerRepository.save(customer);

        return customer;
    }
}
