package hg.hg_android_client.profile.repository;

import java.util.Date;

import hg.hg_android_client.model.Car;
import hg.hg_android_client.model.CreditCard;
import hg.hg_android_client.model.Driver;
import hg.hg_android_client.model.Passenger;
import hg.hg_android_client.model.UnknownRoleUser;
import hg.hg_android_client.model.User;

public class MockProfileRepository implements ProfileRepository {

    @Override
    public User retrieve(String token) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        if ("111111111111".equals(token)) {
            Car car = new Car("patent", "model");
            return new Driver("adrian", "barreal", "Argentina", "18/05/92", car);
        } else if ("222222222222".equals(token)) {
            return new UnknownRoleUser("incomplete", "profile", "", "");
        } else if ("333333333333".equals(token)) {
            CreditCard card = new CreditCard("4444333322221111", "123", "12/17");
            return new Passenger("foo", "bar", "inet", "09/09/1992", card);
        } else {
            return null;
        }
    }

    @Override
    public User retrieveCached() {
        CreditCard card = new CreditCard("4444333322221111", "123", "12/17");
        return new Passenger("", "bar", "inet", "18/05/92", card);
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
