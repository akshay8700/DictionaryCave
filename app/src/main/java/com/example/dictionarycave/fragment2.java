package com.example.dictionarycave;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class fragment2 extends Fragment {

    public SwipeRefreshLayout swipeRefreshLayout;
    WebView webView2;

    public fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_fragment2, container, false);

        // Swipe to refresh
        swipeRefreshLayout = myView.findViewById(R.id.swipeRefresh2);

        getWebView(myView);
        return myView;
    }

    public void getWebView(View view) {
        webView2 = view.findViewById(R.id.webView2);
        String url = "https://dict.hinkhoj.com/shabdkhoj.php?word=happiness&ie=UTF-8";
        webView2.loadUrl(url);
        webView2.setWebViewClient(new WebViewClient());

        WebSettings webSettings = webView2.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Progress bar for webpage loading
        webView2.setWebChromeClient(new WebChromeClient() {
            private ProgressDialog mProgress;

            @Override
            public void onProgressChanged(WebView view, int progress) {
                if (mProgress == null) {
                    mProgress = new ProgressDialog(getActivity());
                    mProgress.show();
                }
                mProgress.setMessage("Loading... " + String.valueOf(progress) + "%");
                if (progress == 100) {
                    mProgress.dismiss();
                    mProgress = null;
                }
            }
        });
    }
}