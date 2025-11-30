public class CryptoPayment extends BasePayment {
    private String walletAdress;
    private double limit;

    public CryptoPayment(String walletAdress) {
        this.walletAdress = walletAdress;
    }

    @Override
    public PaymentStatus processPayment(double amount){
        logger.log("Transaction ID:" + getPaymentID());
        logger.log("Time:" + createdDate);
        logger.log("Processing crypto payment of "+ amount +" to wallet "+ walletAdress);
        logger.log("Status: Blockchain transaction verified.");
        if(amount > limit) return PaymentStatus.INSUFFICIENT_BALANCE;
        return PaymentStatus.SUCCESS;
    }


}
