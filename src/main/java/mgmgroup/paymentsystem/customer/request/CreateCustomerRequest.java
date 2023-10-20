package mgmgroup.paymentsystem.customer.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import mgmgroup.paymentsystem.customer.constants.Gender;

import java.time.LocalDate;

public record CreateCustomerRequest(
        @NotBlank(message = "Name is mandatory")
        String name,
        @Email(message = "Email should be valid")
        String email,
        @Pattern(regexp = "\\(\\d{2}\\)\\d{5}\\-\\d{4}", message = "Phone should be valid")
        String phone,
        @NotNull(message = "Birth date is mandatory")
        LocalDate birthDate,
        @NotNull(message = "Gender is mandatory")
        Gender gender,
        @NotBlank(message = "CPF is mandatory")
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}", message = "CPF should be valid")
        String cpf,
        @NotBlank(message = "CEP is mandatory")
        @Pattern(regexp = "\\d{5}\\-\\d{3}", message = "CEP should be valid")
        String cep) {
}
