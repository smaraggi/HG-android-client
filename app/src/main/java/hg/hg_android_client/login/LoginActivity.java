package hg.hg_android_client.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import hg.hg_android_client.R;
import hg.hg_android_client.login.event.AuthSuccess;
import hg.hg_android_client.login.event.DisplayLoginProgress;
import hg.hg_android_client.login.event.HideLoginProgress;
import hg.hg_android_client.login.intent.LoginIntent;
import hg.hg_android_client.util.LlevameActivity;
import hg.hg_android_client.util.UiReader;

public class LoginActivity extends LlevameActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    private void displayProgressDialog() {
        UiReader reader = new UiReader(this);
        showDialog(reader.readString(R.string.login_progress_title),
                   reader.readString(R.string.login_progress_message));
    }

    public void signupOnClick(View view) {
        Intent i = new Intent(getApplicationContext(), RegistrationActivity.class);
        startActivity(i);
    }

    public void loginOnClick(View view) {
        displayProgressDialog();

        UiReader reader = new UiReader(this);

        String username = reader.readEditText(R.id.person_username);
        String password = reader.readEditText(R.id.person_password);

        Intent i = new LoginIntent(this, username, password);
        this.startService(i);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDisplayLoginProgress(DisplayLoginProgress e) {
        displayProgressDialog();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHideLoginProgress(HideLoginProgress e) {
        dismissDialog();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAuthSuccess(AuthSuccess event) {
        dismissDialog();
    }

}
