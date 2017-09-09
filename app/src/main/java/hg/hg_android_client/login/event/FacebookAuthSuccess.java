package hg.hg_android_client.login.event;

public class FacebookAuthSuccess {

    private final String token;
    private final String userId;

    public FacebookAuthSuccess(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

}
