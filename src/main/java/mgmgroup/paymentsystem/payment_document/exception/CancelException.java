package mgmgroup.paymentsystem.payment_document.exception;

public class CancelException extends RuntimeException{
    public CancelException() {
        super("It is not possible to cancel a document that is not pending or has failed.");
    }
}
