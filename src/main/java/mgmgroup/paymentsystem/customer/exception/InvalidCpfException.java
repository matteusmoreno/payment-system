package mgmgroup.paymentsystem.customer.exception;

public class InvalidCpfException extends RuntimeException{
    public InvalidCpfException() {
        super("Invalid CPF");
    }
}
