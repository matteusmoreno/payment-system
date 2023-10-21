package mgmgroup.paymentsystem.customer.response;

import mgmgroup.paymentsystem.customer.domain.Customer;

import java.time.LocalDate;
import java.util.UUID;

public record ListCustomerResponse(
        UUID id,
        String name,
        String email,
        String phone,
        LocalDate birthDate,
        int age,
        Boolean active) {

    public ListCustomerResponse(Customer customer) {
        this(customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getBirthDate(),
                customer.getAge(),
                customer.getActive());
    }
}
