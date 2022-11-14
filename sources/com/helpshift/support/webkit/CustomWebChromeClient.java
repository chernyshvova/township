package com.helpshift.support.webkit;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import androidx.core.view.ViewCompat;

public class CustomWebChromeClient extends WebChromeClient {
    public WebChromeClient.CustomViewCallback callback;
    public View customView;
    public final View decorView;
    public final ViewGroup fullScreenContainer;
    public final View webviewContentView;

    public CustomWebChromeClient(View view, View view2) {
        this.decorView = view;
        this.webviewContentView = view2;
        this.fullScreenContainer = (ViewGroup) view.findViewById(16908290);
    }

    private void disableFullScreen() {
        this.decorView.setSystemUiVisibility(this.decorView.getSystemUiVisibility() & -3 & -5 & -4097);
    }

    private void enableFullScreen() {
        this.decorView.setSystemUiVisibility(this.decorView.getSystemUiVisibility() | 2 | 4 | 4096);
    }

    public void onHideCustomView() {
        View view = this.customView;
        if (view != null) {
            view.setVisibility(8);
            this.fullScreenContainer.removeView(this.customView);
            this.customView = null;
            WebChromeClient.CustomViewCallback customViewCallback = this.callback;
            if (customViewCallback != null) {
                customViewCallback.onCustomViewHidden();
            }
            this.webviewContentView.setVisibility(0);
            disableFullScreen();
        }
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.customView != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        this.fullScreenContainer.addView(view);
        this.customView = view;
        view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.callback = customViewCallback;
        this.webviewContentView.setVisibility(8);
        enableFullScreen();
    }
}
