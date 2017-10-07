package hg.hg_android_client.login.event;

public class AuthFailure {

    private String message;

    public AuthFailure(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
