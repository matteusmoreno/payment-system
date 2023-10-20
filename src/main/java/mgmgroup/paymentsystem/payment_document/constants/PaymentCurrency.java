package mgmgroup.paymentsystem.payment_document.constants;

import lombok.Getter;

@Getter
public enum PaymentCurrency {
    USD("United States Dollar"),
    BRL("Brazilian Real"),
    IDR("Indonesian Rupiah"),
    EUR("Euro"),
    GBP("British Pound Sterling"),
    JPY("Japanese Yen"),
    CAD("Canadian Dollar"),
    AUD("Australian Dollar"),
    CHF("Swiss Franc"),
    CNY("Chinese Yuan"),
    INR("Indian Rupee"),
    MXN("Mexican Peso");


    private final String displayName;

    PaymentCurrency(String displayName) {
        this.displayName = displayName;
    }

}
