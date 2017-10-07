package hg.hg_android_client.login.event;

public class RegistrationFailed {

    private String errorMessage;

    public RegistrationFailed(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
