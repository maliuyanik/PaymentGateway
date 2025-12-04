import java.io.FileNotFoundException;
import java.util.logging.Logger;

public class CreditCardPayment extends BasePayment {
    private String cardNumber;
    private String cvv;
    private double limit;

    public CreditCardPayment(String cardNumber, String cvv, double limit, ILogger logger, INetworkConnection networkConnection) throws CreditCardPaymentDenied{
        super(logger, networkConnection);
        try{
            if(cardNumber != null && cvv != null){
                this.cardNumber = cardNumber;
                this.cvv = cvv;
            }
        }catch(CreditCardPaymentDenied e){
            throw new CreditCardPaymentDenied();
        }
        finally {
            this.limit = limit;
        }
    }

    public String getCvv() {
        return cvv;
    }
    //encapsulation for car number
    public String getMaskedCardNumber() {
        if(cardNumber != null && cardNumber.length() == 16){
            String lastFourDigits = cardNumber.substring(cardNumber.length() - 4);
            return "**** **** ****" + lastFourDigits;
        }
        else return "Invalid Card";
    }
//polymorphism for credit card transaction
    @Override
    public PaymentStatus processPayment(double amount){
        logger.log("Transaction ID:" + getPaymentID());
        logger.log("Time:" + createdDate);
        logger.log("Processing credit card payment of" + amount + "for card" +  getMaskedCardNumber());
        if(amount > limit){
            logger.log("FAILURE: Limit exceeded. (Limit: " + limit + ")");
            return PaymentStatus.INSUFFICIENT_BALANCE;
        }
        if(!networkConnection.isConnected()){
            logger.log("NETWORK CONNECTION ISSUE");
            return PaymentStatus.NETWORK_ERROR;
        }
        logger.log("SUCCESS: Payment processed.");
        return PaymentStatus.SUCCESS;
    }

    public void cardLimit(){

    }
}
