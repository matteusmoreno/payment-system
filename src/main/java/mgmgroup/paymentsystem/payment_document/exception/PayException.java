package mgmgroup.paymentsystem.payment_document.exception;

public class PayException extends RuntimeException{
    public PayException() {
        super("It is not possible to pay a document that has already been paid, refunded, cancelled or failed.");
    }
}
