package pl.chom.lab9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url)
            {
                // Obvious next step is: document.forms[0].submit()
                view.loadUrl("javascript:" +
                        "document.getElementById(\"suma\").addEventListener(\"click\", function() {" +
                        "   scripts.displayToast(document.getElementById(\"result\").innerHTML);" +
                        "});");
            }
        });

        addJavaScriptInterface();

        webView.loadUrl("http://e-biuro.net/android9/");
    }

    private void addJavaScriptInterface() {
        ScriptInterface scripts = new ScriptInterface(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(scripts, "scripts");
    }
}
