package hg.hg_android_client.login.repository;

import android.content.SharedPreferences;

public class SharedPreferencesTokenRepository implements TokenRepository {

    private SharedPreferences preferences;

    private static final String KEY_TOKEN = "TOKEN";

    public SharedPreferencesTokenRepository(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public String getToken() {
        return preferences.getString(KEY_TOKEN, null);
    }

    @Override
    public void updateToken(String token) {
        preferences.edit().putString(KEY_TOKEN, token).commit();
    }

}
