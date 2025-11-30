import java.time.LocalDateTime;
import java.util.UUID;
abstract class BaseIPayment implements IPaymentProcessor {
    private final String paymentID;
    protected LocalDateTime createdDate;
//nobody can't create new BasePayment() object.
    public BaseIPayment() {
        this.paymentID = UUID.randomUUID().toString();
        this.createdDate = LocalDateTime.now();
    }

    public String getPaymentID() {
        return this.paymentID;
    }
}
