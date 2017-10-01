package hg.hg_android_client.login.event;

public class AuthSuccess {

    private String token;

    public AuthSuccess(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
