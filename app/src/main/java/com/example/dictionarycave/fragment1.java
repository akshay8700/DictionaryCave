package com.example.dictionarycave;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
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

public class fragment1 extends Fragment {

    SwipeRefreshLayout swipeRefreshLayout;
    WebView webView1;

    public fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_fragment1, container, false);

        // Swipe to refresh
        swipeRefreshLayout = myView.findViewById(R.id.swipeRefresh);

        getWebView(myView);

        return myView;
    }

    public void getWebView(View view) {
        webView1 = view.findViewById(R.id.webView1);
        String url = "https://www.oxfordlearnersdictionaries.com/definition/english/happiness?q=happiness";
        webView1.loadUrl(url);

        // Swipe to refresh
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView1.loadUrl(url);
            }
        });

        webView1.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                //Swipe to refresh
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        WebSettings webSettings = webView1.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Progress bar for webpage loading
        webView1.setWebChromeClient(new WebChromeClient() {
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
