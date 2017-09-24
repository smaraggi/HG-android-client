package hg.hg_android_client.model;

public class CreditCard {
    private final String number;
    private final String securityCode;
    private final String expirationDate;

    public CreditCard(String number, String securityCode, String expirationDate) {
        this.number = number;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
    }

    public String getNumber() {
        return number;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

}
