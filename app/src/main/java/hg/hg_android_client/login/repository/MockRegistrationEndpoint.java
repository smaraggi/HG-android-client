package hg.hg_android_client.login.repository;

public class MockRegistrationEndpoint implements RegistrationEndpoint {

    @Override
    public Response request(String username, String password, String usermail) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        return new RegistrationEndpoint.Response(true);
    }

}
