package mgmgroup.paymentsystem.payment_document.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mgmgroup.paymentsystem.customer.domain.Customer;
import mgmgroup.paymentsystem.payment_document.constants.PaymentCurrency;
import mgmgroup.paymentsystem.payment_document.constants.PaymentStatus;
import mgmgroup.paymentsystem.payment_document.constants.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "payment_document")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PaymentDocument {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDate dateOfIssue;
    private LocalDate dateOfPayment;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @Enumerated(EnumType.STRING)
    private PaymentCurrency currency;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;



}
