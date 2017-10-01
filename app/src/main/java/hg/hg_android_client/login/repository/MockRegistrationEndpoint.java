package hg.hg_android_client.login.repository;

public class MockRegistrationEndpoint implements RegistrationEndpoint {

    @Override
    public Response request(String username, String password, String usermail) {
        return new RegistrationEndpoint.Response(true);
    }

}
