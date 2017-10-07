package hg.hg_android_client.util;

import android.content.Context;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    public Properties load(Context context, String filename) {
        Properties properties = new Properties();
        try {
            properties.load(context.getAssets().open(filename));
        } catch (IOException e) {
        }
        return properties;
    }


}
