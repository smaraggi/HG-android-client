package hg.hg_android_client.profile.intent;

import android.content.Context;
import android.content.Intent;

import hg.hg_android_client.profile.ProfileService;

public class RetrieveProfileIntent extends Intent {

    public static final String ACTION = "hg.hg_android_client.RETRIEVE_PROFILE";

    public RetrieveProfileIntent(Context context, String token) {
        super(context, ProfileService.class);
        setAction(ACTION);
        putExtra(ProfileService.KEY_TOKEN, token);
    }

}
