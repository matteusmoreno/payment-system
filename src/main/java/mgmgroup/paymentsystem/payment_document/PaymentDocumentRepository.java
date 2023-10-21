package mgmgroup.paymentsystem.payment_document;

import mgmgroup.paymentsystem.payment_document.domain.PaymentDocument;
import mgmgroup.paymentsystem.payment_document.response.PaymentDocumentDetailsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentDocumentRepository extends JpaRepository<PaymentDocument, UUID> {
}
