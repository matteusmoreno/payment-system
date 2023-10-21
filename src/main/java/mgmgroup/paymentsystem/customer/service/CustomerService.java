package mgmgroup.paymentsystem.customer.service;

import mgmgroup.paymentsystem.customer.CustomerRepository;
import mgmgroup.paymentsystem.customer.domain.Customer;
import mgmgroup.paymentsystem.customer.request.CreateCustomerRequest;
import mgmgroup.paymentsystem.customer.request.UpdateCustomerRequest;
import mgmgroup.paymentsystem.customer.response.ListCustomerResponse;
import mgmgroup.paymentsystem.customer.validation.CustomerValidation;
import mgmgroup.paymentsystem.payment_document.PaymentDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerUtils customerUtils;
    private final CustomerValidation customerValidation;
    private final PaymentDocumentRepository paymentDocumentRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerUtils customerUtils, CustomerValidation customerValidation, PaymentDocumentRepository paymentDocumentRepository) {
        this.customerRepository = customerRepository;
        this.customerUtils = customerUtils;
        this.customerValidation = customerValidation;
        this.paymentDocumentRepository = paymentDocumentRepository;
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


    public Customer desactivate(UUID id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setActive(false);

        customerRepository.save(customer);

        return customer;
    }

    public Page<ListCustomerResponse> listAll(Pageable pageable) {
        return customerRepository.findAll(pageable).map(ListCustomerResponse::new);
    }
}
