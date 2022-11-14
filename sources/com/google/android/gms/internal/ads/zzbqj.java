package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbqj extends WebViewClient {
    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.doUpdateVisitedHistory(webView, str, z);
        }
    }

    @Nullable
    public abstract WebViewClient getDelegate();

    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onFormResubmission(webView, message, message2);
        }
    }

    public void onLoadResource(WebView webView, String str) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onLoadResource(webView, str);
        }
    }

    @RequiresApi(api = 23)
    public final void onPageCommitVisible(WebView webView, String str) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onPageCommitVisible(webView, str);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onPageFinished(webView, str);
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onPageStarted(webView, str, bitmap);
        }
    }

    @RequiresApi(api = 21)
    public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onReceivedClientCertRequest(webView, clientCertRequest);
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onReceivedError(webView, i, str, str2);
        }
    }

    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    @RequiresApi(api = 23)
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    public final void onReceivedLoginRequest(WebView webView, String str, @Nullable String str2, String str3) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @RequiresApi(api = 26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        WebViewClient delegate = getDelegate();
        if (delegate == null) {
            return false;
        }
        return delegate.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @RequiresApi(api = 27)
    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
        }
    }

    public final void onScaleChanged(WebView webView, float f, float f2) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onScaleChanged(webView, f, f2);
        }
    }

    public final void onTooManyRedirects(WebView webView, Message message, Message message2) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onTooManyRedirects(webView, message, message2);
        }
    }

    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    @RequiresApi(api = 21)
    @Nullable
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient delegate = getDelegate();
        if (delegate == null) {
            return null;
        }
        return delegate.shouldInterceptRequest(webView, webResourceRequest);
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient delegate = getDelegate();
        if (delegate == null) {
            return false;
        }
        return delegate.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @RequiresApi(api = 24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient delegate = getDelegate();
        if (delegate == null) {
            return false;
        }
        return delegate.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @RequiresApi(api = 23)
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        WebViewClient delegate = getDelegate();
        if (delegate != null) {
            delegate.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    @Nullable
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebViewClient delegate = getDelegate();
        if (delegate == null) {
            return null;
        }
        return delegate.shouldInterceptRequest(webView, str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebViewClient delegate = getDelegate();
        if (delegate == null) {
            return false;
        }
        return delegate.shouldOverrideUrlLoading(webView, str);
    }
}
