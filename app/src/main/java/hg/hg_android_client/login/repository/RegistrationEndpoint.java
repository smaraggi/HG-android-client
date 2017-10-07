package hg.hg_android_client.login.repository;

public interface RegistrationEndpoint {

    Response request(String username, String password, String usermail);

    class Response {
        private final boolean success;
        private final String errorMessage;

        public static Response success() {
            return new Response(true, null);
        }

        public static Response error(String message) {
            return new Response(false, message);
        }

        Response(boolean success, String errorMessage) {
            this.success = success;
            this.errorMessage = errorMessage;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

    }

}
