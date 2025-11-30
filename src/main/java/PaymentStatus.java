public enum PaymentStatus {
    SUCCESS("Transaction Successful"),
    INSUFFICIENT_BALANCE("Declined: Balance or Limit not enaugh"),
    NETWORK_ERROR("Failed: Connection time out"),
    SYSTEM_ERROR("Internal system error");

    private final String description;
    PaymentStatus(String description) { this.description = description; }
    public String getDescription() { return description; }

}
