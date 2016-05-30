package pl.chom.lab9;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class ScriptInterface {

    private Activity parentActivity;

    ScriptInterface(Activity parentActivity) {
        this.parentActivity = parentActivity;
    }

    @JavascriptInterface
    void displayToast(String toastContent) {
        Toast.makeText(parentActivity.getApplicationContext(), toastContent, Toast.LENGTH_SHORT).show();
    }
}
