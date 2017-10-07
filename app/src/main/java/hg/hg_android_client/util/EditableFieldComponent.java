package hg.hg_android_client.util;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import hg.hg_android_client.R;

public class EditableFieldComponent {

    private View component;

    public EditableFieldComponent(View parent, int id) {
        this.component = parent.findViewById(id);
    }

    public void setLabel(String label) {
        ((TextView) component.findViewById(R.id.label)).setText(label);
    }

    public void setText(String text) {
        ((EditText) component.findViewById(R.id.edit_field)).setText(text);
    }

    public String getText() {
        return ((EditText) component.findViewById(R.id.edit_field)).getText().toString();
    }

}
