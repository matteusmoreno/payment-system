package mgmgroup.paymentsystem.payment_document.exception;

public class RefundException extends RuntimeException{
    public RefundException() {
        super("It is not possible to refund a document that has not been paid.");
    }
}
