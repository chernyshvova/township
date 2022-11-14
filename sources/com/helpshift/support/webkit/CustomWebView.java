package com.helpshift.support.webkit;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class CustomWebView extends WebView {
    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            configureWebView();
        }
    }

    private void configureWebView() {
        getSettings().setJavaScriptEnabled(true);
    }
}
