package hg.hg_android_client.login.repository;

import android.content.SharedPreferences;

public class SharedPreferencesTokenRepository implements TokenRepository {

    private SharedPreferences preferences;

    public SharedPreferencesTokenRepository(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public String getToken() {
        // TODO: Implement
        return "12345678";
    }

    @Override
    public void updateToken(String token) {
        // TODO: Implement
    }

}
