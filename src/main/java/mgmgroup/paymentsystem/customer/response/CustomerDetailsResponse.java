package mgmgroup.paymentsystem.customer.response;

import mgmgroup.paymentsystem.customer.domain.Customer;
import mgmgroup.paymentsystem.payment_document.domain.PaymentDocument;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CustomerDetailsResponse(
        UUID id,
        String name,
        String email,
        String phone,
        String birthDate,
        int age,
        String gender,
        String cpf,
        String cep,
        String state,
        String city,
        String neighborhood,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt,
        Boolean active) {

    public CustomerDetailsResponse(Customer customer) {
        this(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getBirthDate().toString(),
                customer.getAge(),
                customer.getGender().getDisplayName(),
                customer.getCpf(),
                customer.getCep(),
                customer.getState(),
                customer.getCity(),
                customer.getNeighborhood(),
                customer.getCreatedAt(),
                customer.getUpdatedAt(),
                customer.getDeletedAt(),
                customer.getActive());
    }

}
