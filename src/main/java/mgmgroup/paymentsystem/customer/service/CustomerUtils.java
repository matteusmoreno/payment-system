package mgmgroup.paymentsystem.customer.service;

import mgmgroup.paymentsystem.customer.client.ViaCepClient;
import mgmgroup.paymentsystem.customer.domain.Customer;
import mgmgroup.paymentsystem.customer.request.CreateCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Component
public class CustomerUtils {

    private final ViaCepClient viaCepClient;

    @Autowired
    public CustomerUtils(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    public int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }

    public void setAdressAttributes(Customer customer, String cep) {
        var adress = viaCepClient.getAdress(cep);

        customer.setState(adress.uf());
        customer.setCity(adress.localidade());
        customer.setNeighborhood(adress.bairro());
    }

    public void setCreateAttributes(Customer customer, CreateCustomerRequest request) {
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setPhone(request.phone());
        customer.setBirthDate(request.birthDate());
        customer.setPaymentDocuments(null);
        // IDADE
        customer.setAge(calculateAge(request.birthDate()));
        customer.setGender(request.gender());
        customer.setCpf(request.cpf());
        // ENDEREÇO
        customer.setCep(request.cep());
        setAdressAttributes(customer, request.cep());

        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(null);
        customer.setDeletedAt(null);
        customer.setActive(true);
    }
}
