package hg.hg_android_client.login.repository;

public interface LoginEndpoint {

    Response login(String username, String password);

    class Response {
        private boolean success;
        private String token;
        private String errorMessage;

        public static Response success(String token) {
            return new Response(true, token, null);
        }

        public static Response error(String message) {
            return new Response(false, null, message);
        }

        private Response(boolean success, String token, String errorMessage) {
            this.success = success;
            this.token = token;
            this.errorMessage = errorMessage;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getToken() {
            return token;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

    }

}
