package mgmgroup.paymentsystem.customer.service;

import mgmgroup.paymentsystem.customer.CustomerRepository;
import mgmgroup.paymentsystem.customer.client.ViaCepClient;
import mgmgroup.paymentsystem.customer.domain.Customer;
import mgmgroup.paymentsystem.customer.request.CreateCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setPhone(request.phone());
        customer.setBirthDate(request.birthDate());
        customer.setPaymentDocuments(null);
        customer.setAge(customerUtils.calculateAge(request.birthDate()));
        customer.setGender(request.gender());
        customer.setCpf(request.cpf());

        customer.setCep(request.cep());
        customerUtils.setAdressAttributes(customer, request.cep());

        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(null);
        customer.setDeletedAt(null);
        customer.setActive(true);

        customerRepository.save(customer);

        return customer;

    }
}
