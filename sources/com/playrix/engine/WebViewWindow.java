package com.playrix.engine;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.engine.LifeCycleActivity;
import java.util.concurrent.atomic.AtomicBoolean;

public class WebViewWindow {
    public static final String TAG = "WebViewWindow ";
    public static final AtomicBoolean isAvailable = new AtomicBoolean(false);
    public final long instanceId;
    public boolean isPaused = false;
    public final LifeCycleActivity.ILifecycleCallbacks lifecycleHandler = new LifeCycleActivity.ILifecycleCallbacks() {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            if (WebViewWindow.this.webView != null && !WebViewWindow.this.isPaused) {
                boolean unused = WebViewWindow.this.isPaused = true;
                WebViewWindow.this.webView.onPause();
            }
        }

        public boolean onActivityResult(int i, int i2, Intent intent) {
            return false;
        }

        public void onActivityResumed(Activity activity) {
            if (WebViewWindow.this.webView != null && WebViewWindow.this.isPaused) {
                boolean unused = WebViewWindow.this.isPaused = false;
                WebViewWindow.this.webView.onResume();
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onLowMemory() {
        }

        public void onNewIntent(Intent intent) {
        }
    };
    public final LocalFile localFile = new LocalFile();
    public WebView webView;
    public EngineActivity webViewActivity;

    public class JavaScriptInterface {
        public JavaScriptInterface() {
        }

        @JavascriptInterface
        public void postMessage(final String str) {
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    WebViewWindow.onScriptMessage(WebViewWindow.this.instanceId, str);
                }
            });
        }
    }

    public static class LocalFile {
        public byte[] fileData;
        public Uri fileUrl;

        public LocalFile() {
            this.fileUrl = null;
            this.fileData = null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized android.webkit.WebResourceResponse get(android.net.Uri r5) {
            /*
                r4 = this;
                monitor-enter(r4)
                android.net.Uri r0 = r4.fileUrl     // Catch:{ all -> 0x0042 }
                r1 = 0
                if (r0 == 0) goto L_0x0040
                byte[] r0 = r4.fileData     // Catch:{ all -> 0x0042 }
                if (r0 != 0) goto L_0x000b
                goto L_0x0040
            L_0x000b:
                android.net.Uri r0 = r4.fileUrl     // Catch:{ all -> 0x0042 }
                java.lang.String r0 = r0.getScheme()     // Catch:{ all -> 0x0042 }
                java.lang.String r2 = r5.getScheme()     // Catch:{ all -> 0x0042 }
                boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0042 }
                if (r0 == 0) goto L_0x003e
                android.net.Uri r0 = r4.fileUrl     // Catch:{ all -> 0x0042 }
                java.lang.String r0 = r0.getPath()     // Catch:{ all -> 0x0042 }
                java.lang.String r5 = r5.getPath()     // Catch:{ all -> 0x0042 }
                boolean r5 = r0.equals(r5)     // Catch:{ all -> 0x0042 }
                if (r5 != 0) goto L_0x002c
                goto L_0x003e
            L_0x002c:
                android.webkit.WebResourceResponse r5 = new android.webkit.WebResourceResponse     // Catch:{ all -> 0x0042 }
                java.lang.String r0 = "text/html"
                java.lang.String r1 = "utf-8"
                java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0042 }
                byte[] r3 = r4.fileData     // Catch:{ all -> 0x0042 }
                r2.<init>(r3)     // Catch:{ all -> 0x0042 }
                r5.<init>(r0, r1, r2)     // Catch:{ all -> 0x0042 }
                monitor-exit(r4)
                return r5
            L_0x003e:
                monitor-exit(r4)
                return r1
            L_0x0040:
                monitor-exit(r4)
                return r1
            L_0x0042:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.WebViewWindow.LocalFile.get(android.net.Uri):android.webkit.WebResourceResponse");
        }

        public synchronized void set(String str, byte[] bArr) {
            this.fileUrl = null;
            this.fileData = null;
            if (!(str == null || bArr == null || bArr.length == 0)) {
                Uri parse = Uri.parse(str);
                if (!(parse.getScheme() == null || parse.getPath() == null)) {
                    this.fileUrl = parse;
                    this.fileData = bArr;
                }
            }
        }
    }

    public class WebViewClientImpl extends WebViewClient {
        public WebViewClientImpl() {
        }

        public void onPageFinished(WebView webView, final String str) {
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    WebViewWindow.onPageLoadFinished(WebViewWindow.this.instanceId, str);
                }
            });
        }

        public void onPageStarted(WebView webView, final String str, Bitmap bitmap) {
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    WebViewWindow.onPageLoadStarted(WebViewWindow.this.instanceId, str);
                }
            });
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            WebViewWindow.this.reportError(str);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return WebViewWindow.this.localFile.get(Uri.parse(str));
        }

        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            WebViewWindow.this.reportError(webResourceError.getDescription().toString());
        }

        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return WebViewWindow.this.localFile.get(webResourceRequest.getUrl());
        }
    }

    public WebViewWindow(long j) {
        this.instanceId = j;
    }

    public static void checkAvailability() {
        try {
            new WebView(Engine.getContext());
            isAvailable.set(true);
        } catch (Exception unused) {
            isAvailable.set(false);
        }
    }

    /* access modifiers changed from: private */
    public WebView createWebView(EngineActivity engineActivity, String str, byte[] bArr) {
        WebView webView2 = new WebView(engineActivity);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setCacheMode(-1);
        webView2.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webView2.getSettings().setAllowFileAccess(true);
        webView2.setWebViewClient(new WebViewClientImpl());
        this.localFile.set(str, bArr);
        webView2.loadUrl(str);
        return webView2;
    }

    /* access modifiers changed from: private */
    public void destroyWebView() {
        EngineActivity engineActivity;
        if (this.webView != null) {
            synchronized (this) {
                engineActivity = this.webViewActivity;
                this.webViewActivity = null;
            }
            if (engineActivity != null) {
                try {
                    engineActivity.GetParentFramelayout().removeView(this.webView);
                } catch (Exception e) {
                    GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("WebViewWindow Error close: "));
                }
            }
            this.webView.destroy();
            this.webView = null;
            if (engineActivity != null) {
                engineActivity.unregisterActivityLifecycleCallbacks(this.lifecycleHandler);
            }
        }
    }

    private EngineActivity getActivity() {
        EngineActivity engineActivity;
        synchronized (this) {
            engineActivity = this.webViewActivity;
        }
        return engineActivity;
    }

    public static boolean isAvailable() {
        return isAvailable.get();
    }

    public static ViewGroup.LayoutParams makeLayoutParams(EngineActivity engineActivity, boolean z, float f, float f2, float f3, float f4) {
        if (z) {
            return new FrameLayout.LayoutParams(-1, -1);
        }
        int surfaceHeight = engineActivity.getGLView().getSurfaceHeight();
        float resolutionScaleW = Engine.getResolutionScaleW();
        float resolutionScaleH = Engine.getResolutionScaleH();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) ((f2 - f) / resolutionScaleW), (int) ((f4 - f3) / resolutionScaleH));
        layoutParams.leftMargin = (int) (f / resolutionScaleW);
        layoutParams.topMargin = (int) ((((float) surfaceHeight) - f4) / resolutionScaleH);
        return layoutParams;
    }

    public static native void onError(long j, String str);

    public static native void onPageLoadFinished(long j, String str);

    public static native void onPageLoadStarted(long j, String str);

    public static native void onScriptMessage(long j, String str);

    /* access modifiers changed from: private */
    public void reportError(final String str) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                WebViewWindow.onError(WebViewWindow.this.instanceId, str);
            }
        });
    }

    public void close() {
        EngineActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    WebViewWindow.this.destroyWebView();
                }
            });
        }
    }

    public void evaluateJavascript(final String str) {
        EngineActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (WebViewWindow.this.webView != null) {
                        WebViewWindow.this.webView.evaluateJavascript(str, (ValueCallback) null);
                    }
                }
            });
        }
    }

    public void hide() {
        EngineActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (WebViewWindow.this.webView != null) {
                        WebViewWindow.this.webView.setVisibility(8);
                    }
                }
            });
        }
    }

    public void open(String str, String str2, byte[] bArr, boolean z, boolean z2, int i, float f, float f2, float f3, float f4) {
        EngineActivity activity = Engine.getActivity();
        if (activity != null) {
            final EngineActivity engineActivity = activity;
            final String str3 = str;
            final byte[] bArr2 = bArr;
            final String str4 = str2;
            final boolean z3 = z2;
            final int i2 = i;
            final boolean z4 = z;
            final float f5 = f;
            final float f6 = f2;
            final float f7 = f3;
            final float f8 = f4;
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (WebViewWindow.this.webView == null) {
                        try {
                            WebView unused = WebViewWindow.this.webView = WebViewWindow.this.createWebView(engineActivity, str3, bArr2);
                            if (str4 != null && !str4.isEmpty()) {
                                WebViewWindow.this.webView.addJavascriptInterface(new JavaScriptInterface(), str4);
                            }
                            if (z3) {
                                WebViewWindow.this.webView.setVisibility(8);
                            }
                            WebViewWindow.this.webView.setBackgroundColor(i2);
                            engineActivity.GetParentFramelayout().addView(WebViewWindow.this.webView, WebViewWindow.makeLayoutParams(engineActivity, z4, f5, f6, f7, f8));
                            synchronized (this) {
                                EngineActivity unused2 = WebViewWindow.this.webViewActivity = engineActivity;
                            }
                            engineActivity.registerActivityLifecycleCallbacks(WebViewWindow.this.lifecycleHandler);
                            boolean unused3 = WebViewWindow.this.isPaused = engineActivity.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED;
                            if (WebViewWindow.this.isPaused) {
                                WebViewWindow.this.webView.onPause();
                            }
                        } catch (Exception e) {
                            WebViewWindow.this.destroyWebView();
                            WebViewWindow webViewWindow = WebViewWindow.this;
                            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Open exception: ");
                            outline24.append(e.toString());
                            webViewWindow.reportError(outline24.toString());
                        }
                    }
                }
            });
        }
    }

    public void setBackgroundColor(final int i) {
        EngineActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (WebViewWindow.this.webView != null) {
                        WebViewWindow.this.webView.setBackgroundColor(i);
                    }
                }
            });
        }
    }

    public void setFrame(boolean z, float f, float f2, float f3, float f4) {
        EngineActivity activity = getActivity();
        if (activity != null) {
            final EngineActivity engineActivity = activity;
            final boolean z2 = z;
            final float f5 = f;
            final float f6 = f2;
            final float f7 = f3;
            final float f8 = f4;
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (WebViewWindow.this.webView != null) {
                        WebViewWindow.this.webView.setLayoutParams(WebViewWindow.makeLayoutParams(engineActivity, z2, f5, f6, f7, f8));
                    }
                }
            });
        }
    }

    public void show() {
        EngineActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (WebViewWindow.this.webView != null) {
                        WebViewWindow.this.webView.setVisibility(0);
                    }
                }
            });
        }
    }
}
