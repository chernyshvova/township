package com.vungle.warren.p037ui.view;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.Utility;
import com.google.gson.JsonObject;
import com.vungle.warren.BuildConfig;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.omsdk.WebViewObserver;
import com.vungle.warren.p037ui.presenter.MRAIDAdPresenter;
import com.vungle.warren.p037ui.view.WebViewAPI;

/* renamed from: com.vungle.warren.ui.view.VungleWebClient */
public class VungleWebClient extends WebViewClient implements WebViewAPI {
    public static final String TAG = VungleWebClient.class.getSimpleName();
    public WebViewAPI.MRAIDDelegate MRAIDDelegate;
    public Advertisement advertisement;
    public boolean collectConsent;
    public WebViewAPI.WebClientErrorHandler errorHandler;
    public String gdprAccept;
    public String gdprBody;
    public String gdprDeny;
    public String gdprTitle;
    public Boolean isViewable;
    public WebView loadedWebView;
    public Placement placement;
    public boolean ready;
    @Nullable
    public WebViewObserver webViewObserver;

    @RequiresApi(29)
    /* renamed from: com.vungle.warren.ui.view.VungleWebClient$VungleWebViewRenderProcessClient */
    public static class VungleWebViewRenderProcessClient extends WebViewRenderProcessClient {
        public WebViewAPI.WebClientErrorHandler errorHandler;

        public VungleWebViewRenderProcessClient(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
            this.errorHandler = webClientErrorHandler;
        }

        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        }

        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            String str = VungleWebClient.TAG;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("onRenderProcessUnresponsive(Title = ");
            outline24.append(webView.getTitle());
            outline24.append(", URL = ");
            outline24.append(webView.getOriginalUrl());
            outline24.append(", (webViewRenderProcess != null) = ");
            outline24.append(webViewRenderProcess != null);
            Log.w(str, outline24.toString());
            WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
            if (webClientErrorHandler != null) {
                webClientErrorHandler.onRenderProcessUnresponsive(webView, webViewRenderProcess);
            }
        }
    }

    public VungleWebClient(Advertisement advertisement2, Placement placement2) {
        this.advertisement = advertisement2;
        this.placement = placement2;
    }

    private void handleWebViewError(String str, String str2) {
        boolean isCriticalAsset = isCriticalAsset(str2);
        String outline17 = GeneratedOutlineSupport.outline17(str2, " ", str);
        WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
        if (webClientErrorHandler != null) {
            webClientErrorHandler.onReceivedError(outline17, isCriticalAsset);
        }
    }

    private boolean isCriticalAsset(String str) {
        Advertisement advertisement2;
        if (TextUtils.isEmpty(str) || (advertisement2 = this.advertisement) == null) {
            return false;
        }
        return advertisement2.getDownloadableUrls().containsValue(str);
    }

    private void runJavascriptOnWebView(@NonNull WebView webView, @NonNull String str) {
        webView.evaluateJavascript(str, (ValueCallback) null);
    }

    public void notifyPropertiesChange(boolean z) {
        if (this.loadedWebView != null) {
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("width", (Number) Integer.valueOf(this.loadedWebView.getWidth()));
            jsonObject2.addProperty("height", (Number) Integer.valueOf(this.loadedWebView.getHeight()));
            JsonObject jsonObject3 = new JsonObject();
            boolean z2 = false;
            jsonObject3.addProperty("x", (Number) 0);
            jsonObject3.addProperty("y", (Number) 0);
            jsonObject3.addProperty("width", (Number) Integer.valueOf(this.loadedWebView.getWidth()));
            jsonObject3.addProperty("height", (Number) Integer.valueOf(this.loadedWebView.getHeight()));
            JsonObject jsonObject4 = new JsonObject();
            jsonObject4.addProperty("sms", Boolean.FALSE);
            jsonObject4.addProperty("tel", Boolean.FALSE);
            jsonObject4.addProperty("calendar", Boolean.FALSE);
            jsonObject4.addProperty("storePicture", Boolean.FALSE);
            jsonObject4.addProperty("inlineVideo", Boolean.FALSE);
            jsonObject.members.put("maxSize", jsonObject2);
            jsonObject.members.put("screenSize", jsonObject2);
            jsonObject.members.put("defaultPosition", jsonObject3);
            jsonObject.members.put("currentPosition", jsonObject3);
            jsonObject.members.put("supports", jsonObject4);
            jsonObject.addProperty("placementType", this.advertisement.getTemplateType());
            Boolean bool = this.isViewable;
            if (bool != null) {
                jsonObject.addProperty("isViewable", bool);
            }
            jsonObject.addProperty("os", "android");
            jsonObject.addProperty("osVersion", Integer.toString(Build.VERSION.SDK_INT));
            jsonObject.addProperty("incentivized", Boolean.valueOf(this.placement.isIncentivized()));
            if (this.advertisement.getShowCloseDelay(this.placement.isIncentivized()) == 0) {
                z2 = true;
            }
            jsonObject.addProperty("enableBackImmediately", Boolean.valueOf(z2));
            jsonObject.addProperty("version", "1.0");
            if (this.collectConsent) {
                jsonObject.addProperty("consentRequired", Boolean.TRUE);
                jsonObject.addProperty("consentTitleText", this.gdprTitle);
                jsonObject.addProperty("consentBodyText", this.gdprBody);
                jsonObject.addProperty("consentAcceptButtonText", this.gdprAccept);
                jsonObject.addProperty("consentDenyButtonText", this.gdprDeny);
            } else {
                jsonObject.addProperty("consentRequired", Boolean.FALSE);
            }
            jsonObject.addProperty("sdkVersion", BuildConfig.VERSION_NAME);
            String str = TAG;
            Log.d(str, "loadJsjavascript:window.vungle.mraidBridge.notifyPropertiesChange(" + jsonObject + "," + z + ")");
            runJavascriptOnWebView(this.loadedWebView, "window.vungle.mraidBridge.notifyPropertiesChange(" + jsonObject + "," + z + ")");
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        int adType = this.advertisement.getAdType();
        if (adType == 0) {
            runJavascriptOnWebView(webView, "function actionClicked(action){Android.performAction(action);};");
        } else if (adType == 1) {
            this.loadedWebView = webView;
            webView.setVisibility(0);
            notifyPropertiesChange(true);
        } else {
            throw new IllegalArgumentException("Unknown Client Type!");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            webView.setWebViewRenderProcessClient(new VungleWebViewRenderProcessClient(this.errorHandler));
        }
        WebViewObserver webViewObserver2 = this.webViewObserver;
        if (webViewObserver2 != null) {
            webViewObserver2.onPageFinished(webView);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (Build.VERSION.SDK_INT < 23) {
            String str3 = TAG;
            Log.e(str3, "Error desc " + str);
            String str4 = TAG;
            Log.e(str4, "Error for URL " + str2);
            handleWebViewError(str, str2);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (Build.VERSION.SDK_INT >= 21) {
            String str = TAG;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Error desc ");
            outline24.append(webResourceResponse.getStatusCode());
            Log.e(str, outline24.toString());
            String str2 = TAG;
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Error for URL ");
            outline242.append(webResourceRequest.getUrl().toString());
            Log.e(str2, outline242.toString());
            handleWebViewError(String.valueOf(webResourceResponse.getStatusCode()), webResourceRequest.getUrl().toString());
        }
    }

    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        String str = TAG;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("onRenderProcessGone url: ");
        outline24.append(webView.getUrl());
        outline24.append(",  did crash: ");
        outline24.append(renderProcessGoneDetail.didCrash());
        Log.w(str, outline24.toString());
        this.loadedWebView = null;
        WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
        if (webClientErrorHandler != null) {
            return webClientErrorHandler.onWebRenderingProcessGone(webView, renderProcessGoneDetail.didCrash());
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public void setAdVisibility(boolean z) {
        this.isViewable = Boolean.valueOf(z);
        notifyPropertiesChange(false);
    }

    public void setConsentStatus(boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.collectConsent = z;
        this.gdprTitle = str;
        this.gdprBody = str2;
        this.gdprAccept = str3;
        this.gdprDeny = str4;
    }

    public void setErrorHandler(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
        this.errorHandler = webClientErrorHandler;
    }

    public void setMRAIDDelegate(WebViewAPI.MRAIDDelegate mRAIDDelegate) {
        this.MRAIDDelegate = mRAIDDelegate;
    }

    public void setWebViewObserver(WebViewObserver webViewObserver2) {
        this.webViewObserver = webViewObserver2;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = TAG;
        Log.d(str2, "MRAID Command " + str);
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "Invalid URL ");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse.getScheme() != null) {
            String scheme = parse.getScheme();
            if (scheme.equals("mraid")) {
                String host = parse.getHost();
                if (host == null) {
                    return false;
                }
                if ("propertiesChangeCompleted".equals(host) && !this.ready) {
                    JsonObject createMRAIDArgs = this.advertisement.createMRAIDArgs();
                    runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyReadyEvent(" + createMRAIDArgs + ")");
                    this.ready = true;
                } else if (this.MRAIDDelegate != null) {
                    JsonObject jsonObject = new JsonObject();
                    for (String next : parse.getQueryParameterNames()) {
                        jsonObject.addProperty(next, parse.getQueryParameter(next));
                    }
                    if (this.MRAIDDelegate.processCommand(host, jsonObject)) {
                        runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyCommandComplete()");
                    }
                }
                return true;
            } else if ("http".equalsIgnoreCase(scheme) || Utility.URL_SCHEME.equalsIgnoreCase(scheme)) {
                String str3 = TAG;
                Log.d(str3, "Open URL" + str);
                if (this.MRAIDDelegate != null) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("url", str);
                    this.MRAIDDelegate.processCommand(MRAIDAdPresenter.OPEN_NON_MRAID, jsonObject2);
                }
                return true;
            }
        }
        return false;
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (Build.VERSION.SDK_INT >= 23) {
            String str = TAG;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Error desc ");
            outline24.append(webResourceError.getDescription().toString());
            Log.e(str, outline24.toString());
            String str2 = TAG;
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Error for URL ");
            outline242.append(webResourceRequest.getUrl().toString());
            Log.e(str2, outline242.toString());
            handleWebViewError(webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }
}
