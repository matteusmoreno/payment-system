package mgmgroup.paymentsystem.customer.service;

import mgmgroup.paymentsystem.customer.CustomerRepository;
import mgmgroup.paymentsystem.customer.client.ViaCepClient;
import mgmgroup.paymentsystem.customer.domain.Customer;
import mgmgroup.paymentsystem.customer.request.CreateCustomerRequest;
import mgmgroup.paymentsystem.customer.request.UpdateCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerUtils customerUtils;
    private final ViaCepClient viaCepClient;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerUtils customerUtils, ViaCepClient viaCepClient) {
        this.customerRepository = customerRepository;
        this.customerUtils = customerUtils;
        this.viaCepClient = viaCepClient;
    }

    public Customer create(CreateCustomerRequest request) {
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
