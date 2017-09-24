package hg.hg_android_client.model;

import java.util.Date;

public class Passenger extends User {
    private final CreditCard creditCard;

    protected Passenger(
            String firstName,
            String lastName,
            String location,
            Date birthdate,
            CreditCard creditCard) {
        super(firstName, lastName, location, birthdate, Role.PASSENGER);
        this.creditCard = creditCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

}
