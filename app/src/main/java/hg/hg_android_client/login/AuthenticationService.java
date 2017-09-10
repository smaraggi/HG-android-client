package hg.hg_android_client.login;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import org.greenrobot.eventbus.EventBus;

import hg.hg_android_client.login.event.FacebookAuthSuccess;
import hg.hg_android_client.login.intent.FacebookAuthenticationIntent;

public class AuthenticationService extends IntentService {

    private static final String SERVICE_NAME = "LlevameAuthService";

    public AuthenticationService() {
        super(SERVICE_NAME);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action = intent.getAction();

        switch(action) {
            case FacebookAuthenticationIntent.ACTION:
                handleFacebookAuthentication(intent);
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

}
