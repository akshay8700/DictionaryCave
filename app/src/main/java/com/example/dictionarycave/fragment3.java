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

public class fragment3 extends Fragment {

    public SwipeRefreshLayout swipeRefreshLayout;
    WebView webView3;

    public fragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_fragment3, container, false);

        // swipe to refresh
        swipeRefreshLayout = myView.findViewById(R.id.swipeRefresh3);
        getWebView(myView);
        return myView;
    }

    public void getWebView(View view) {

        webView3 = view.findViewById(R.id.webView3);
        String url = "https://www.collinsdictionary.com/dictionary/english/happiness";
        webView3.loadUrl(url);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView3.loadUrl(url);
            }
        });

        webView3.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        WebSettings webSettings = webView3.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Progress bar for webpage loading
        webView3.setWebChromeClient(new WebChromeClient() {
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