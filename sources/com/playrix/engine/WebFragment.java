package com.playrix.engine;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.applovin.impl.sdk.utils.Utils;
import java.lang.ref.WeakReference;

@SuppressLint({"SetJavaScriptEnabled"})
public class WebFragment extends Fragment {
    public static final int DefaultLayout;
    public static final int DefaultPageWidth = 1024;
    public static final int HTML_VIEW_ID = 10101010;
    public static final boolean USE_DEFAULT_DELEGATE_WHEN_UNSPECIFIED = true;
    public static String currentURL = "http://www.playrix.com";
    public static String data = null;
    public static boolean handleHtmlUrls = false;
    public static int htmlLayoutId = 0;
    public static int htmlPageWidth = 1024;
    public static IWebFragment iface;
    public static WeakReference<EngineActivity> mActivity;
    public static WeakReference<FrameLayout> mHtmlLayout;
    public static WeakReference<WebFragment> mWebFragment;
    public static WebViewClient webViewClientDelegate;

    /* renamed from: wv */
    public WebView f3612wv;

    public interface IWebFragment {
        void OnCreateView(View view);
    }

    public class WebViewClientDelegate extends WebViewClient {
        public WebViewClientDelegate() {
        }

        private boolean processOverrideUrlLoading(WebView webView, Uri uri) {
            String scheme;
            if (uri == null || (scheme = uri.getScheme()) == null) {
                return false;
            }
            boolean equals = scheme.equals(Utils.PLAY_STORE_SCHEME);
            boolean equals2 = scheme.equals("amzn");
            boolean equals3 = scheme.equals("http");
            if (!equals && !equals2 && (!equals3 || WebFragment.handleHtmlUrls)) {
                return false;
            }
            try {
                webView.getContext().startActivity(new Intent("android.intent.action.VIEW", uri));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return false;
            }
            try {
                return processOverrideUrlLoading(webView, Uri.parse(str));
            } catch (Exception unused) {
                return false;
            }
        }

        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null) {
                return false;
            }
            return processOverrideUrlLoading(webView, webResourceRequest.getUrl());
        }
    }

    static {
        int i = C3204R.layout.html_layout;
        DefaultLayout = i;
        htmlLayoutId = i;
    }

    public static void Hide() {
        WeakReference<EngineActivity> weakReference = mActivity;
        EngineActivity engineActivity = weakReference != null ? (EngineActivity) weakReference.get() : null;
        if (engineActivity != null) {
            WebFragment webFragment = getWebFragment();
            if (webFragment != null) {
                engineActivity.getSupportFragmentManager().beginTransaction().remove(webFragment).commit();
            }
            WeakReference<FrameLayout> weakReference2 = mHtmlLayout;
            FrameLayout frameLayout = weakReference2 != null ? (FrameLayout) weakReference2.get() : null;
            if (frameLayout != null) {
                engineActivity.GetParentFramelayout().removeView(frameLayout);
            }
        }
        mHtmlLayout = null;
        mWebFragment = null;
        webViewClientDelegate = null;
        data = null;
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                Engine.nativeDisableInput(false);
            }
        });
    }

    public static boolean IsShown() {
        WebFragment webFragment = getWebFragment();
        return webFragment != null && webFragment.isVisible();
    }

    public static void Show(EngineActivity engineActivity, String str) {
        htmlLayoutId = DefaultLayout;
        htmlPageWidth = 1024;
        iface = null;
        data = null;
        ShowInternal(engineActivity, str);
    }

    public static void ShowInternal(EngineActivity engineActivity, String str) {
        FrameLayout frameLayout = new FrameLayout(engineActivity);
        frameLayout.setId(HTML_VIEW_ID);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        engineActivity.GetParentFramelayout().addView(frameLayout);
        WebFragment webFragment = new WebFragment();
        mActivity = new WeakReference<>(engineActivity);
        currentURL = str;
        FragmentTransaction beginTransaction = engineActivity.getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(HTML_VIEW_ID, webFragment);
        beginTransaction.commit();
        mWebFragment = new WeakReference<>(webFragment);
        mHtmlLayout = new WeakReference<>(frameLayout);
    }

    public static WebFragment getWebFragment() {
        WeakReference<WebFragment> weakReference = mWebFragment;
        if (weakReference != null) {
            return (WebFragment) weakReference.get();
        }
        return null;
    }

    public static boolean onBackPressed() {
        if (getWebFragment() == null) {
            return false;
        }
        Hide();
        return true;
    }

    public static void setHandleHtmlUrls(boolean z) {
        handleHtmlUrls = z;
    }

    public static void setWebViewClientDelegate(WebViewClient webViewClient) {
        webViewClientDelegate = webViewClient;
    }

    public static void showUI(final String str) {
        final EngineActivity activity = Engine.getActivity();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                WebFragment.Show(EngineActivity.this, str);
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(htmlLayoutId, viewGroup, false);
        IWebFragment iWebFragment = iface;
        if (iWebFragment != null) {
            iWebFragment.OnCreateView(inflate);
        }
        if (currentURL != null) {
            WebView webView = (WebView) inflate.findViewById(C3204R.C3206id.webview);
            this.f3612wv = webView;
            webView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    WebFragment.this.f3612wv.setInitialScale((WebFragment.this.f3612wv.getWidth() * 100) / WebFragment.htmlPageWidth);
                }
            });
            this.f3612wv.getSettings().setJavaScriptEnabled(true);
            this.f3612wv.getSettings().setCacheMode(2);
            this.f3612wv.setVerticalScrollBarEnabled(false);
            if (webViewClientDelegate == null) {
                webViewClientDelegate = new WebViewClientDelegate();
            }
            this.f3612wv.setWebViewClient(webViewClientDelegate);
            String str = data;
            if (str != null) {
                this.f3612wv.loadDataWithBaseURL(currentURL, str, "text/html", (String) null, (String) null);
            } else {
                this.f3612wv.loadUrl(currentURL);
            }
        }
        inflate.findViewById(C3204R.C3206id.back_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (WebFragment.getWebFragment() != null) {
                    WebFragment.Hide();
                }
            }
        });
        inflate.setFocusableInTouchMode(true);
        inflate.requestFocus();
        return inflate;
    }

    public static void Show(EngineActivity engineActivity, String str, int i, int i2, IWebFragment iWebFragment) {
        htmlLayoutId = i;
        htmlPageWidth = i2;
        iface = iWebFragment;
        data = null;
        ShowInternal(engineActivity, str);
    }

    public static void Show(EngineActivity engineActivity, String str, String str2, int i, int i2, IWebFragment iWebFragment) {
        htmlLayoutId = i;
        htmlPageWidth = i2;
        iface = iWebFragment;
        data = str2;
        ShowInternal(engineActivity, str);
    }
}
