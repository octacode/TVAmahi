package octacode.allblue.code.tvamahi;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

public class WebViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView browser = (WebView)findViewById(R.id.web_view);
        browser.loadUrl("https://github.com/octacode");
    }
}
