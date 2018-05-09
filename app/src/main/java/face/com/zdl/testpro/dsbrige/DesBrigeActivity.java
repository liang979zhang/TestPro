package face.com.zdl.testpro.dsbrige;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import face.com.zdl.testpro.R;
import wendu.dsbridge.DWebView;

public class DesBrigeActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    DWebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_des_brige);
        ButterKnife.bind(this);

        DWebView.setWebContentsDebuggingEnabled(true);
        webview.addJavascriptObject(new JsApi(), null);
//        webview.addJavascriptObject(new JsEchoApi(),"echo");
        webview.loadUrl("file:///android_asset/brige.html");
    }
}
