public class CryptoIPayment extends BaseIPayment {
    private String walletAdress;

    public CryptoIPayment(String walletAdress) {
        this.walletAdress = walletAdress;
    }

    @Override
    public void processPayment(double amount){
        System.out.println("Transaction ID:" + getPaymentID());
        System.out.println("Time:" + createdDate);
        System.out.println("Processing crypto payment of "+ amount +" to wallet "+ walletAdress);
        System.out.println("Status: Blockchain transaction verified.");

    }


}
