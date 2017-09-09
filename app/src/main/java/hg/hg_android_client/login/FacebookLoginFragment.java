package hg.hg_android_client.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import hg.hg_android_client.R;
import hg.hg_android_client.login.event.FacebookAuthSuccess;
import hg.hg_android_client.login.intent.FacebookAuthenticationIntent;

public class FacebookLoginFragment extends Fragment implements FacebookCallback<LoginResult> {

    private ProgressDialog authenticationProgress;
    private CallbackManager callbackManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        View view = inflater.inflate(R.layout.fragment_facebook_login, container, false);

        LoginButton facebookLoginButton = findButton(view);
        initializeButton(facebookLoginButton);

        return view;
    }

    private LoginButton findButton(View parentView) {
        return (LoginButton) parentView.findViewById(R.id.facebook_login_button);
    }

    private void initializeButton(LoginButton button) {
        button.setFragment(this);
        button.registerCallback(callbackManager, this);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        Context context = getContext();

        authenticationProgress = ProgressDialog.show(
                context,
                context.getResources().getString(R.string.login_progress_title),
                context.getResources().getString(R.string.login_progress_message));

        FacebookAuthenticationIntent intent =
                new FacebookAuthenticationIntent(
                        context.getApplicationContext(),
                        loginResult.getAccessToken().getUserId(),
                        loginResult.getAccessToken().getToken());

        context.startService(intent);
    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onError(FacebookException error) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFacebookAuthSuccessEvent(FacebookAuthSuccess event) {
        authenticationProgress.dismiss();
    }

}
