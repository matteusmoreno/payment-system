package mgmgroup.paymentsystem.customer.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record IdCustomerRequest(
        @NotNull(message = "Id is required")
        UUID id) {
}
