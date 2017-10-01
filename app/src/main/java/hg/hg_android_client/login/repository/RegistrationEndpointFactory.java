package hg.hg_android_client.login.repository;

public class RegistrationEndpointFactory {

    public RegistrationEndpoint getEndpoint() {
        return new MockRegistrationEndpoint();
    }

}
