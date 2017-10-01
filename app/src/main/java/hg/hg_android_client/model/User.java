package hg.hg_android_client.model;

import java.io.Serializable;
import java.util.Date;

public abstract class User implements Serializable {
    private final String firstName;
    private final String lastName;
    private final String location;
    private final String birthdate;
    private final Role role;

    protected User(
            String firstName,
            String lastName,
            String location,
            String birthdate,
            Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.birthdate = birthdate;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLocation() {
        return location;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public Role getRole() {
        return role;
    }

    public enum Role {
        DRIVER, PASSENGER
    }

}
