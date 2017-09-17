package hg.hg_android_client.util;

import android.support.v4.app.Fragment;

import org.greenrobot.eventbus.EventBus;

public class LlevameFragment extends Fragment {

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

}
