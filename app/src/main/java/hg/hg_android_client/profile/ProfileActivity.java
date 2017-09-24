package hg.hg_android_client.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import hg.hg_android_client.R;
import hg.hg_android_client.profile.event.UpdateSuccess;
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
        UiReader reader = new UiReader(this);
        View parent = findViewById(R.id.profile_parent);

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

        for (int i = 0; i < id.length; i++) {
            EditableFieldComponent component = new EditableFieldComponent(parent, id[i]);
            component.setLabel(reader.readString(labels[i]));
        }
    }

    private void initializeFragments() {
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUpdateSuccess(UpdateSuccess event) {

    }

}
