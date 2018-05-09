package face.com.zdl.testpro.dsbrige;

import android.webkit.JavascriptInterface;

import org.json.JSONException;

import wendu.dsbridge.CompletionHandler;

/**
 * Created by 89667 on 2018/5/9.
 */

class JsEchoApi {

    @JavascriptInterface
    public Object syn(Object args) throws JSONException {
        return  args;
    }

    @JavascriptInterface
    public void asyn(Object args,CompletionHandler handler){
        handler.complete(args);
    }
}
