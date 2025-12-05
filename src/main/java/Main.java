import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //dependencies
        ILogger myLogger = new ConsoleLogger();
        INetworkConnection myNetwork = new MockNetworkAdapter();

        //polymorphism, constructor injection
        List<IPaymentProcessor> paymentQueue = new ArrayList<>();

        //batch processing polymorphism
        paymentQueue.add(new CreditCardPayment("1234567891234567", "123", 2000.0, myLogger, myNetwork));


        System.out.println("--- Batch Processing Started ---\n");
        for(IPaymentProcessor payment : paymentQueue){
            PaymentStatus result = payment.processPayment(150.0);
            if(result != PaymentStatus.SUCCESS){
                System.out.println("ATTENTION: Process has been failed " + result.getDescription());
            }
        }
        System.out.println("------------------------------");
    }
}