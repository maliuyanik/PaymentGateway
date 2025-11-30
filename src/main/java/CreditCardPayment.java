public class CreditCardIPayment extends BaseIPayment {
    private String cardNumber;
    private String cvv;

    public CreditCardIPayment(String cardNumber, String cvv){
        this.cardNumber = cardNumber;
        this.cvv = cvv;
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
    public void processPayment(double amount){
        System.out.println("Transaction ID:" + getPaymentID());
        System.out.println("Time:" + createdDate);
        System.out.println("Processing credit card payment of" + amount + "for card" +  getMaskedCardNumber());
        System.out.println("Status: Bank API contacted success.");
    }
}
