package hg.hg_android_client.login.intent;

import android.content.Context;
import android.content.Intent;

import hg.hg_android_client.login.IdentityService;

public class LoginIntent  extends Intent {

    public static final String ACTION = "hg.hg_android_client.APPLICATION_LOGIN";

    public static final String KEY_USERNAME = "USER_ID";
    public static final String KEY_PASSWORD = "TOKEN";

    public LoginIntent(Context context, String username, String password) {
        super(context, IdentityService.class);

        setAction(ACTION);

        putExtra(KEY_USERNAME, username);
        putExtra(KEY_PASSWORD, password);
    }

}
