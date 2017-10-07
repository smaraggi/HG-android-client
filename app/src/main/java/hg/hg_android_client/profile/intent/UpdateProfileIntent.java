package hg.hg_android_client.profile.intent;

import android.content.Context;
import android.content.Intent;

import hg.hg_android_client.model.User;
import hg.hg_android_client.profile.ProfileService;

public class UpdateProfileIntent extends Intent {

    public static final String ACTION = "hg.hg_android_client.UPDATE_PROFILE";

    public static final String KEY_USER = "USER";

    public UpdateProfileIntent(Context context, String token, User user) {
        super(context, ProfileService.class);
        setAction(ACTION);
        putExtra(KEY_USER, user);
        putExtra(ProfileService.KEY_TOKEN, token);
    }

}
