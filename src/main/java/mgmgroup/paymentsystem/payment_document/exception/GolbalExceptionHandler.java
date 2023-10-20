package mgmgroup.paymentsystem.payment_document.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GolbalExceptionHandler {

    @ExceptionHandler(PayException.class)
    public ResponseEntity<String> handlePayException(PayException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(RefundException.class)
    public ResponseEntity<String> handleRefundException(RefundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(CancelException.class)
    public ResponseEntity<String> handleCancelException(CancelException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
