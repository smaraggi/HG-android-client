package hg.hg_android_client.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hg.hg_android_client.R;
import hg.hg_android_client.util.UiReader;

public class DriverProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        View view = inflater.inflate(R.layout.fragment_driver_profile, container, false);
        initializeComponents(view);
        return view;
    }

    private void initializeComponents(View parent) {
        View patentContainer = parent.findViewById(R.id.patent);
        View carmodContainer = parent.findViewById(R.id.carmodel);

        updateTextView(patentContainer, R.id.label, R.string.profile_patent);
        updateTextView(carmodContainer, R.id.label, R.string.profile_carmodel);
    }

    private void updateTextView(View container, int id, int stringId) {
        TextView textview = (TextView) container.findViewById(id);
        textview.setText(getResources().getString(stringId));
    }

    public String getPatent() {
        return getComponentField(R.id.patent);
    }

    public String getCarModel() {
        return getComponentField(R.id.carmodel);
    }

    public String getComponentField(int id) {
        View container = getView().findViewById(id);
        UiReader reader = new UiReader(container);
        return reader.readEditText(R.id.edit_field);
    }

}
