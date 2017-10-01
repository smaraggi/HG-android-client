package hg.hg_android_client.login;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import hg.hg_android_client.login.event.AuthSuccess;
import hg.hg_android_client.login.event.FacebookAuthSuccess;
import hg.hg_android_client.login.event.RegistrationSuccess;
import hg.hg_android_client.login.intent.FacebookAuthenticationIntent;
import hg.hg_android_client.login.intent.LoginIntent;
import hg.hg_android_client.login.intent.RegistrationIntent;
import hg.hg_android_client.login.repository.LoginEndpoint;
import hg.hg_android_client.login.repository.LoginEndpointFactory;
import hg.hg_android_client.login.repository.RegistrationEndpoint;
import hg.hg_android_client.login.repository.RegistrationEndpointFactory;

public class IdentityService extends IntentService {

    private static final String SERVICE_NAME = "LlevameAuthService";

    public IdentityService() {
        super(SERVICE_NAME);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent == null) {
            return;
        }

        String action = intent.getAction();

        switch(action) {
            case FacebookAuthenticationIntent.ACTION:
                handleFacebookAuthentication(intent);
                break;
            case RegistrationIntent.ACTION:
                handleRegistration(intent);
                break;
            case LoginIntent.ACTION:
                handleApplicationLogin(intent);
                break;
            default:
                break;
        }
    }

    private void handleFacebookAuthentication(Intent intent) {
        String userId = intent.getStringExtra(FacebookAuthenticationIntent.KEY_USER_ID);
        String token  = intent.getStringExtra(FacebookAuthenticationIntent.KEY_TOKEN);

        /*
         * Send authentication event to application server;
         * should create user if it does not exist.
         */

        FacebookAuthSuccess e = new FacebookAuthSuccess(userId, token);
        EventBus.getDefault().post(e);
    }

    private void handleRegistration(Intent intent) {
        String username = intent.getStringExtra(RegistrationIntent.KEY_USERNAME);
        String password = intent.getStringExtra(RegistrationIntent.KEY_PASSWORD);
        String usermail = intent.getStringExtra(RegistrationIntent.KEY_USERMAIL);

        RegistrationEndpoint.Response response = new RegistrationEndpointFactory()
                .getEndpoint().request(username, password, usermail);

        if (response.isSuccess()) {
            RegistrationSuccess e = new RegistrationSuccess();
            EventBus.getDefault().post(e);
        } else {
            // TODO: Handle error case.
        }
    }

    private void handleApplicationLogin(Intent intent) {
        String username = intent.getStringExtra(LoginIntent.KEY_USERNAME);
        String password = intent.getStringExtra(LoginIntent.KEY_PASSWORD);

        LoginEndpoint.Response response = new LoginEndpointFactory()
                .getEndpoint().login(username, password);

        if (response.isSuccess()) {
            // TODO: Store session token.
            AuthSuccess e = new AuthSuccess(response.getToken());
            EventBus.getDefault().post(e);
        } else {
            // TODO: Handle error case.
        }
    }

}
