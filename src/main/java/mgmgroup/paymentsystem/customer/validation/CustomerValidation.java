package mgmgroup.paymentsystem.customer.validation;

import mgmgroup.paymentsystem.customer.client.ViaCepClient;
import mgmgroup.paymentsystem.customer.exception.InvalidCepException;
import mgmgroup.paymentsystem.customer.exception.InvalidCpfException;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidation {

    private final ViaCepClient viaCepClient;

    public CustomerValidation(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    public void isCpfValid(String cpf) {
        // Remove caracteres de formatação (pontos e traço)
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            throw new InvalidCpfException();
        }

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(cpf.charAt(i));
            sum += digit * (10 - i);
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit == 10 || firstDigit == 11) {
            firstDigit = 0;
        }
        if (firstDigit != Character.getNumericValue(cpf.charAt(9))) {
            throw new InvalidCpfException();
        }

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            int digit = Character.getNumericValue(cpf.charAt(i));
            sum += digit * (11 - i);
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit == 10 || secondDigit == 11) {
            secondDigit = 0;
        }
        if (secondDigit != Character.getNumericValue(cpf.charAt(10))) {
            throw new InvalidCpfException();
        }
    }

    public void isCepValid(String cep) {
        var adress = viaCepClient.getAdress(cep);
        if (adress.bairro() == null || adress.localidade() == null || adress.uf() == null) {
            throw new InvalidCepException();
        }

    }
}
