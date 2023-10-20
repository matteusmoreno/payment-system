package mgmgroup.paymentsystem.payment_document.constants;

import lombok.Getter;

@Getter
public enum PaymentType {
    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card"),
    BANK_TRANSFER("Bank Transfer"),
    CASH("Cash"),
    PIX("PIX"),
    BOLETO("Boleto"),
    DEPOSIT("Deposit");

    private final String displayName;

    PaymentType(String displayName) {
        this.displayName = displayName;
    }

}
