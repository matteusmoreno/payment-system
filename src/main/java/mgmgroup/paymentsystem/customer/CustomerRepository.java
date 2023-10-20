package mgmgroup.paymentsystem.customer;

import mgmgroup.paymentsystem.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
