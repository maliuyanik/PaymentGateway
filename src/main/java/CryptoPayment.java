public class CryptoPayment extends BasePayment {
    private String walletAdress;
    private double limit;

    public CryptoPayment(ILogger logger, INetworkConnection networkConnection, String walletAdress, double limit) {
        super(logger, networkConnection);
        this.walletAdress = walletAdress;
        this.limit = limit;
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
