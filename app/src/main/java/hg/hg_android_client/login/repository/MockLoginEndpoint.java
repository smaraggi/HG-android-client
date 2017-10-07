package hg.hg_android_client.login.repository;

public class MockLoginEndpoint implements LoginEndpoint {

    @Override
    public Response login(String username, String password) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        if ("adrian".equals(username)) {
            return LoginEndpoint.Response.success("111111111111");
        } else if ("noprofile".equals(username)) {
            return LoginEndpoint.Response.success("222222222222");
        } else if ("foo".equals(username)) {
            return LoginEndpoint.Response.success("333333333333");
        } else {
            return LoginEndpoint.Response.error("Authentication failed");
        }
    }

}
