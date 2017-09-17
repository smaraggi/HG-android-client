package hg.hg_android_client.util;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

public class LlevameActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        dismissDialog();
    }

    protected void showDialog(String title, String message) {
        dismissDialog();
        progressDialog = ProgressDialog.show(this, title, message);
    }

    protected void dismissDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

}
