package mgmgroup.paymentsystem.payment_document.validations;

import mgmgroup.paymentsystem.payment_document.constants.PaymentStatus;
import mgmgroup.paymentsystem.payment_document.exception.PayException;
import org.springframework.stereotype.Component;

@Component
public class PaymentDocumentValidation {

    public void payValidation(PaymentStatus status) {
        if (status == PaymentStatus.PAID || status == PaymentStatus.REFUNDED || status == PaymentStatus.FAILED || status == PaymentStatus.CANCELLED) {
            throw new PayException();
        }
    }

    public void refundValidation(PaymentStatus status) {
        if (status == PaymentStatus.REFUNDED || status == PaymentStatus.CANCELLED || status == PaymentStatus.FAILED || status == PaymentStatus.PENDING) {
            throw new PayException();
        }
    }

    public void cancelValidation(PaymentStatus status) {
        if (status == PaymentStatus.CANCELLED || status == PaymentStatus.REFUNDED || status == PaymentStatus.PAID) {
            throw new PayException();
        }
    }
}
