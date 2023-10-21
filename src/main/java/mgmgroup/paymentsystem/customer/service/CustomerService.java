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

        if (request.name() != null) {
            customer.setName(request.name());
        }

        if (request.email() != null) {
            customer.setEmail(request.email());
        }

        if (request.phone() != null) {
            customer.setPhone(request.phone());
        }

        if (request.birthDate() != null) {
            customer.setBirthDate(request.birthDate());
            customer.setAge(customerUtils.calculateAge(request.birthDate()));
        }

        if (request.gender() != null) {
            customer.setGender(request.gender());
        }

        if (request.cpf() != null) {
            customer.setCpf(request.cpf());
        }

        if (request.cep() != null) {
            customer.setCep(request.cep());
            customerUtils.setAdressAttributes(customer, request.cep());
        }

        customer.setUpdatedAt(LocalDateTime.now());
        customerRepository.save(customer);

        return customer;
    }
}
