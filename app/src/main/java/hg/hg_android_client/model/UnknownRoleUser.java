package hg.hg_android_client.model;

public class UnknownRoleUser extends User {

    public UnknownRoleUser(String firstName, String lastName, String location, String birthdate) {
        super(firstName, lastName, location, birthdate, Role.UNKNOWN);
    }

    @Override
    protected boolean additionalsComplete() {
        return false;
    }
}
