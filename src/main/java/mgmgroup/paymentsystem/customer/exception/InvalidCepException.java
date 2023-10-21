package mgmgroup.paymentsystem.customer.exception;

public class InvalidCepException extends RuntimeException{
    public InvalidCepException() {
        super("Invalid CEP");
    }
}
