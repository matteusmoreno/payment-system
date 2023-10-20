package mgmgroup.paymentsystem.customer.service;

import mgmgroup.paymentsystem.customer.CustomerRepository;
import mgmgroup.paymentsystem.customer.domain.Customer;
import mgmgroup.paymentsystem.customer.request.CreateCustomerRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(CreateCustomerRequest request) {
        Customer customer = new Customer();

        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setPhone(request.phone());
        customer.setBirthDate(request.birthDate());
        customer.setPaymentDocuments(null);
        //age
        customer.setGender(request.gender());
        customer.setCpf(request.cpf());
        customer.setCep(request.cep());
        //county
        //state
        //city
        //neighborhood
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(null);
        customer.setDeletedAt(null);
        customer.setActive(true);

        customerRepository.save(customer);

        return customer;

    }
}
