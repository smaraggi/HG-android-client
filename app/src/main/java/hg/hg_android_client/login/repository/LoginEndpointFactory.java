package hg.hg_android_client.login.repository;

public class LoginEndpointFactory {

    public LoginEndpoint getEndpoint() {
        return new MockLoginEndpoint();
    }

}
