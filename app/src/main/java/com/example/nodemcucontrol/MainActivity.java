package com.example.nodemcucontrol;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;

public class MainActivity extends Activity {
    private static final String DEVICE_URL = "http://192.168.4.1/";
    private WebView webView;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.rgb(17, 17, 17));

        LinearLayout bar = new LinearLayout(this);
        bar.setOrientation(LinearLayout.HORIZONTAL);
        bar.setGravity(Gravity.CENTER_VERTICAL);
        bar.setPadding(16, 10, 16, 10);
        bar.setBackgroundColor(Color.rgb(25, 25, 25));

        status = new TextView(this);
        status.setText("NodeMCU સાથે કનેક્ટ થઈ રહ્યું છે...");
        status.setTextColor(Color.WHITE);
        status.setTextSize(14);
        bar.addView(status, new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));

        Button reload = new Button(this);
        reload.setText("ફરી જોડો");
        reload.setOnClickListener(v -> webView.loadUrl(DEVICE_URL));
        bar.addView(reload);

        root.addView(bar, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        webView = new WebView(this);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_NEVER_ALLOW);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
                status.setText("કનેક્ટ થઈ રહ્યું છે...");
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                status.setText("NodeMCU Control");
            }
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request,
                                        android.webkit.WebResourceError error) {
                if (request.isForMainFrame()) {
                    status.setText("કનેક્શન નથી. NODEMCU_CONTROL Wi-Fi જોડો.");
                }
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
        root.addView(webView, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1));

        setContentView(root);
        webView.loadUrl(DEVICE_URL);
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) webView.goBack();
        else super.onBackPressed();
    }
}
