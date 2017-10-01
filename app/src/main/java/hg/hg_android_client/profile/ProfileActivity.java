package hg.hg_android_client.profile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import hg.hg_android_client.R;
import hg.hg_android_client.login.repository.TokenRepository;
import hg.hg_android_client.login.repository.TokenRepositoryFactory;
import hg.hg_android_client.model.CreditCard;
import hg.hg_android_client.model.Passenger;
import hg.hg_android_client.model.User;
import hg.hg_android_client.profile.event.UpdateSuccess;
import hg.hg_android_client.profile.intent.UpdateProfileIntent;
import hg.hg_android_client.profile.repository.ProfileRepository;
import hg.hg_android_client.profile.repository.ProfileRepositoryFactory;
import hg.hg_android_client.util.EditableFieldComponent;
import hg.hg_android_client.util.LlevameActivity;
import hg.hg_android_client.util.UiReader;

public class ProfileActivity extends LlevameActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initializeComponents();

        if (savedInstanceState == null) {
            initializeFragments();
        }
    }

    private void initializeComponents() {
        // TODO: Mark required fields that are missing.

        UiReader reader = new UiReader(this);
        View parent = findViewById(R.id.profile_parent);

        ProfileRepositoryFactory f = new ProfileRepositoryFactory();
        ProfileRepository r = f.getRepository();
        User user = r.retrieveCached();

        int[] id = {
                R.id.first_name,
                R.id.last_name,
                R.id.birthdate,
                R.id.location
        };

        int[] labels = {
                R.string.profile_name,
                R.string.profile_last_name,
                R.string.profile_birthdate,
                R.string.profile_location
        };

        String[] values = new String[4];
        if (user != null) {
            values[0] = user.getFirstName();
            values[1] = user.getLastName();
            values[2] = user.getBirthdate();
            values[3] = user.getLocation();
        }

        for (int i = 0; i < id.length; i++) {
            EditableFieldComponent component = new EditableFieldComponent(parent, id[i]);
            component.setLabel(reader.readString(labels[i]));
            if (values[i] != null) {
                component.setText(values[i]);
            }
        }
    }

    private void initializeFragments() {
        // TODO: Select from one fragment or the other depending on user.
        //       Grab user from repository, and depending on type fill fragment.
        NoneSelectedFragment fragment = new NoneSelectedFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }

    public void onDriverSelected(View view) {
        updateFragmentContainer(new DriverProfileFragment());
    }

    public void onPassengerSelected(View view) {
        updateFragmentContainer(new PassengerProfileFragment());
    }

    private void updateFragmentContainer(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    public void updateProfileOnClick(View view) {
        // TODO: Implement scrolling for profile activity.
        // TODO: Move to strings.
        hideKeyboard();
        showDialog("Updating Profile", "Please wait...");
        Intent i = new UpdateProfileIntent(this, getToken(), createUser());
        this.startService(i);
    }

    private String getToken() {
        TokenRepositoryFactory f = new TokenRepositoryFactory();
        TokenRepository r = f.getRepository(this.getApplicationContext());
        return r.getToken(); // TODO: Handle null case.
    }

    private User createUser() {
        // TODO: Implement;
        CreditCard creditCard = new CreditCard("1234", "123", "12/17");
        return new Passenger("bob", "mike", "somewhere", "18/05/92", creditCard);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUpdateSuccess(UpdateSuccess event) {
        dismissDialog();
        // TODO: Refactor, create strings in strings.xml.
        // TODO: Update data being displayed in the screen w/ new cached profile;
        //       May need to refactor code above for this.
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("Update Successful");
        dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

}
