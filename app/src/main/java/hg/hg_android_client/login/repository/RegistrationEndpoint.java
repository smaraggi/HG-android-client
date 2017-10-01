package hg.hg_android_client.login.repository;

public interface RegistrationEndpoint {

    Response request(String username, String password, String usermail);

    class Response {
        private final boolean success;

        Response(boolean success) {
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
        }

    }

}
