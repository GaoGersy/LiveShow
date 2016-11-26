package com.gersion.pictureshow.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gersion.pictureshow.R;
import com.gersion.pictureshow.base.BaseActivity;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.ui.activity
 * @待完成
 * @创建时间 2016/11/26
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class WeChatActivity extends BaseActivity {


    private WebView mWebView;
    private String mUrl;

    @Override
    protected int setResourceId() {
        return R.layout.activity_wechat;
    }

    @Override
    protected void initView() {
        initProgressDialog();
        mWebView = (WebView) findViewById(R.id.webview);
        WebSettings settings = mWebView.getSettings();
        settings.setDefaultFontSize(15);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);



    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");
        mWebView.loadUrl(mUrl);
    }

    @Override
    protected void initEvent() {
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mProgressDialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mProgressDialog.dismiss();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                mProgressDialog.dismiss();
            }
        });
    }


}
