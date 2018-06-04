package com.example.joseantonio.secondwebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wv1 = (WebView)findViewById(R.id.wv1);

        String url = getIntent().getStringExtra("url");
        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl("https://" + url);
    }

    // Method for Close button
    public void Close(View view){
        finish();
    }
}
