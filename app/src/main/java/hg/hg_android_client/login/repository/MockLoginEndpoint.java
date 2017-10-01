package hg.hg_android_client.login.repository;

public class MockLoginEndpoint implements LoginEndpoint {

    @Override
    public Response login(String username, String password) {
        return new LoginEndpoint.Response(true, "12345678");
    }

}
