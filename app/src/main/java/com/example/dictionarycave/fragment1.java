package com.example.dictionarycave;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class fragment1 extends Fragment {

    WebView webView1;

    public fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_fragment1, container, false);
        getWebView(myView);
        return myView;
    }

    public void getWebView(View view) {
        webView1 = view.findViewById(R.id.webView1);
        String url = "https://www.oxfordlearnersdictionaries.com/definition/english/happiness?q=happiness";
        webView1.loadUrl(url);
        webView1.setWebViewClient(new WebViewClient());

        WebSettings webSettings = webView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
