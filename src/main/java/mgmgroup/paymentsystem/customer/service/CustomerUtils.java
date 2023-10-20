package mgmgroup.paymentsystem.customer.service;

import mgmgroup.paymentsystem.customer.client.ViaCepClient;
import mgmgroup.paymentsystem.customer.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
}
