package mgmgroup.paymentsystem.payment_document;

import mgmgroup.paymentsystem.payment_document.domain.PaymentDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentDocumentRepository extends JpaRepository<PaymentDocument, UUID> {
}
