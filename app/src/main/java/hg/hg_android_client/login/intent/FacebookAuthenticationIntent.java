package hg.hg_android_client.login.intent;

import android.content.Context;
import android.content.Intent;

import hg.hg_android_client.login.AuthenticationService;

public class FacebookAuthenticationIntent extends Intent {

    public static final String ACTION = "hg.hg_android_client.FACEBOOK_LOGIN";

    public static final String KEY_USER_ID = "USER_ID";
    public static final String KEY_TOKEN = "TOKEN";

    public FacebookAuthenticationIntent(Context context, String userId, String token) {
        super(context, AuthenticationService.class);
        putExtra(KEY_USER_ID, userId);
        putExtra(KEY_TOKEN, token);
        setAction(ACTION);
    }

}
