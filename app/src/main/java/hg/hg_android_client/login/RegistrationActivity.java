package hg.hg_android_client.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import hg.hg_android_client.R;
import hg.hg_android_client.login.event.RegistrationFailed;
import hg.hg_android_client.login.event.RegistrationSuccess;
import hg.hg_android_client.login.intent.RegistrationIntent;
import hg.hg_android_client.util.LlevameActivity;
import hg.hg_android_client.util.UiReader;

public class RegistrationActivity extends LlevameActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void registerOnClick(View button) {
        hideKeyboard();

        UiReader reader = new UiReader(this);

        String username = reader.readEditText(R.id.person_username);
        String password = reader.readEditText(R.id.person_password);
        String usermail = reader.readEditText(R.id.person_email);

        showDialog(reader.readString(R.string.register_progress_title),
                   reader.readString(R.string.register_progress_message));

        Intent i = new RegistrationIntent(this, username, password, usermail);
        this.startService(i);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRegistrationSuccess(RegistrationSuccess event) {
        dismissDialog();
        String message = getResources().getString(R.string.registration_successful);
        String buttonMessage = getResources().getString(R.string.OK);

        DialogInterface.OnClickListener h = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
                Intent move = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(move);
            }
        };

        displayConfirmationDialog(message, buttonMessage, h);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRegistrationFailure(RegistrationFailed event) {
        dismissDialog();

        String message = getString(R.string.registration_failed);
        String btnmesg = getString(R.string.OK);

        displayConfirmationDialog(message, btnmesg, new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface d, int i) {
                d.dismiss();
            }
        });
    }

}
