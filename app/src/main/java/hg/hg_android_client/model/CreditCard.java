package hg.hg_android_client.model;

import java.io.Serializable;

public class CreditCard implements Serializable {
    private final String number;
    private final String securityCode;
    private final String expirationDate;

    public static CreditCard empty() {
        return new CreditCard("", "", "");
    }

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
