package mgmgroup.paymentsystem.customer.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mgmgroup.paymentsystem.customer.constants.Gender;
import mgmgroup.paymentsystem.payment_document.domain.PaymentDocument;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private Gender gender;
    private String cpf;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<PaymentDocument> paymentDocuments;
    private String cep;
    private String country;
    private String state;
    private String city;
    private String neighborhood;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Boolean active;

}
