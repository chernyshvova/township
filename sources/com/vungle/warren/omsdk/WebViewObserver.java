package com.vungle.warren.omsdk;

import android.webkit.WebView;
import androidx.annotation.NonNull;

public interface WebViewObserver {
    void onPageFinished(@NonNull WebView webView);
}
