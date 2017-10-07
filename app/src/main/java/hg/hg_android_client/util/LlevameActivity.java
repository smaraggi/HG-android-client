package hg.hg_android_client.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import org.greenrobot.eventbus.EventBus;

import hg.hg_android_client.R;
import hg.hg_android_client.login.LoginActivity;

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

    protected void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
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

    protected void displayConfirmationDialog(
            String message,
            String buttonMessage,
            AlertDialog.OnClickListener handler) {
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle(message);
        dialog.setButton(AlertDialog.BUTTON_NEUTRAL, buttonMessage, handler);
        dialog.show();
    }

}
