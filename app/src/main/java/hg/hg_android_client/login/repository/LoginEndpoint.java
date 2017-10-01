package hg.hg_android_client.login.repository;

public interface LoginEndpoint {

    Response login(String username, String password);

    class Response {
        private boolean success;
        private String token;

        Response(boolean success, String token) {
            this.success = success;
            this.token = token;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getToken() {
            return token;
        }

    }

}
