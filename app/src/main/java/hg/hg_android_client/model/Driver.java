package hg.hg_android_client.model;

import java.io.Serializable;
import java.util.Date;

public class Driver extends User implements Serializable {

    private final Car car;

    public Driver(
            String firstName,
            String lastName,
            String location,
            String birthdate,
            Car car) {
        super(firstName, lastName, location, birthdate, Role.DRIVER);
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    @Override
    protected boolean additionalsComplete() {
        return car != null &&
               isNotNullOrEmpty(car.getModel()) &&
               isNotNullOrEmpty(car.getPatent());
    }
}
