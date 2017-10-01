package hg.hg_android_client.model;

import java.io.Serializable;
import java.util.Date;

public class Passenger extends User implements Serializable {
    private final CreditCard creditCard;

    public Passenger(
            String firstName,
            String lastName,
            String location,
            String birthdate,
            CreditCard creditCard) {
        super(firstName, lastName, location, birthdate, Role.PASSENGER);
        this.creditCard = creditCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

}
