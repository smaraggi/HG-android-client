package hg.hg_android_client.login.intent;

import android.content.Context;
import android.content.Intent;

import hg.hg_android_client.login.IdentityService;

public class LogoutIntent extends Intent {

    public static final String ACTION = "hg.hg_android_client.APPLICATION_LOGOUT";

    public LogoutIntent(Context context) {
        super(context, IdentityService.class);
        setAction(ACTION);
    }

}
