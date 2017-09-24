package hg.hg_android_client.util;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class UiReader {

    private View context;

    public UiReader(View view) {
        this.context = view;
    }

    public UiReader(Fragment context) {
        this.context = context.getView();
    }

    public UiReader(AppCompatActivity context) {
        this.context = context.findViewById(android.R.id.content);
    }

    public String readEditText(int id) {
        EditText e = (EditText) context.findViewById(id);
        return e.getText().toString();
    }

    public String readString(int id) {
        return context.getResources().getString(id);
    }

}
