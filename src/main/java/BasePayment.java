import java.time.LocalDateTime;
import java.util.UUID;

abstract class BasePayment implements IPaymentProcessor {
    private final String paymentID;
    protected LocalDateTime createdDate;
    protected final ILogger logger;
    protected final INetworkConnection networkConnection;

//nobody can't create new BasePayment() object because this is an abstract class.
    public BasePayment(ILogger logger, INetworkConnection networkConnection) {
        this.paymentID = UUID.randomUUID().toString();
        this.createdDate = LocalDateTime.now();
        this.logger = logger;
        this.networkConnection = networkConnection;
    }

    public String getPaymentID() {
        return this.paymentID;
    }
}
