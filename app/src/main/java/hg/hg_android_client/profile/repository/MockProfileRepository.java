package hg.hg_android_client.profile.repository;

import java.util.Date;

import hg.hg_android_client.model.CreditCard;
import hg.hg_android_client.model.Passenger;
import hg.hg_android_client.model.User;

public class MockProfileRepository implements ProfileRepository {

    @Override
    public User retrieve(String token) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        CreditCard card = new CreditCard("4444333322221111", "123", "12/17");
        return new Passenger("", "", "", "18/05/92", card);
    }

    @Override
    public User retrieveCached() {
        CreditCard card = new CreditCard("4444333322221111", "123", "12/17");
        return new Passenger("foo", "bar", "inet", "18/05/92", card);
    }

    @Override
    public User update(String token, User user) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        return user;
    }

}
