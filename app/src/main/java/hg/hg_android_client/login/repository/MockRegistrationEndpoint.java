package hg.hg_android_client.login.repository;

public class MockRegistrationEndpoint implements RegistrationEndpoint {

    @Override
    public Response request(String username, String password, String usermail) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        if ("regerror".equals(username)) {
            return RegistrationEndpoint.Response.error("Username already exists");
        } else {
            return RegistrationEndpoint.Response.success();
        }

    }

}
