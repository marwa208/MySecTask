package com.example.marwa.mysectask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_main);


        webview = (WebView) findViewById(R.id.webview);

        // تمكين جافا سكريبت في صفحة الويب
        webview.getSettings().setJavaScriptEnabled(true);

        // السماح بالتكبير وتصغير في الصفحة
        webview.getSettings().setBuiltInZoomControls(true);

        // تصغير صفحة الويب لتناسب شاشة الجوال
        //  webview.getSettings().setLoadWithOverviewMode(true);
        //   webview.getSettings().setUseWideViewPort(true);

        // فتح صفحة الويب المطلوبة .. اكتب رابط الصفحة التي تريد فتحها بالتطبيق بالاسفل
        webview.loadUrl("https://www.msn.com/ar-eg");

        // عرض شريط المعالجة والتقدم لصفحة الويب
        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                setProgress(progress * 100);
            }
        });

        // الاتصال بكلاس InsideWebViewClient
        webview.setWebViewClient(new InsideWebViewClient());

    }

    private class InsideWebViewClient extends WebViewClient {
        @Override
        // تمكين وعرض الصفحة داخل التطبيق نفسه دون الخروج لمتصفح خارجي
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }
    }
}
