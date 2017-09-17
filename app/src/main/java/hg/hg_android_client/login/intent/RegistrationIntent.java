package hg.hg_android_client.login.intent;

import android.content.Context;
import android.content.Intent;

import hg.hg_android_client.login.IdentityService;

public class RegistrationIntent extends Intent {

    public static final String ACTION = "hg.hg_android_client.REGISTRATION";

    public static final String KEY_USERNAME = "USERNAME";
    public static final String KEY_PASSWORD = "PASSWORD";
    public static final String KEY_USERMAIL = "USERMAIL";

    public RegistrationIntent(
            Context context,
            String username,
            String password,
            String usermail) {

        super(context, IdentityService.class);

        setAction(ACTION);

        putExtra(KEY_USERNAME, username);
        putExtra(KEY_PASSWORD, password);
        putExtra(KEY_USERMAIL, usermail);
    }

}
