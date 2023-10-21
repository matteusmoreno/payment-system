package mgmgroup.paymentsystem.customer.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import mgmgroup.paymentsystem.customer.constants.Gender;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateCustomerRequest(
        @NotNull(message = "Id cannot be null")
        UUID id,
        String name,
        @Email(message = "Email should be valid")
        String email,
        @Pattern(regexp = "\\(\\d{2}\\)\\d{5}\\-\\d{4}", message = "Phone should be valid")
        String phone,
        LocalDate birthDate,
        Gender gender,
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}", message = "CPF should be valid")
        String cpf,
        @Pattern(regexp = "\\d{5}\\-\\d{3}", message = "CEP should be valid")
        String cep) {
}
