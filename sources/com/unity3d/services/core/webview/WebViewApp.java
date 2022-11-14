package com.unity3d.services.core.webview;

import android.os.Build;
import android.os.ConditionVariable;
import android.os.Looper;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.unity3d.services.ads.api.AdUnit;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.InitializeThread;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.SDKMetrics;
import com.unity3d.services.core.webview.bridge.CallbackStatus;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import com.unity3d.services.core.webview.bridge.Invocation;
import com.unity3d.services.core.webview.bridge.NativeCallback;
import com.unity3d.services.core.webview.bridge.WebViewBridge;
import com.vungle.warren.model.Advertisement;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;

public class WebViewApp implements IWebViewBridgeInvoker {
    public static final int INVOKE_JS_CHARS_LENGTH = 22;
    public static ConditionVariable _conditionVariable;
    public static WebViewApp _currentApp;
    public static AtomicReference<Boolean> _initialized = new AtomicReference<>(Boolean.FALSE);
    public static AtomicReference<Integer> _webAppFailureCode = new AtomicReference<>();
    public static AtomicReference<String> _webAppFailureMessage = new AtomicReference<>();
    public Configuration _configuration;
    public HashMap<String, NativeCallback> _nativeCallbacks;
    public boolean _webAppLoaded;
    public WebView _webView;

    public class WebAppChromeClient extends WebChromeClient {
        public WebAppChromeClient() {
        }

        public void onConsoleMessage(String str, int i, String str2) {
            File file;
            try {
                file = new File(str2);
            } catch (Exception e) {
                DeviceLog.exception("Could not handle sourceId", e);
                file = null;
            }
            if (file != null) {
                file.getName();
            }
        }
    }

    public class WebAppClient extends WebViewClient {
        public WebAppClient() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            DeviceLog.debug("onPageFinished url: " + str);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webView != null) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("WEBVIEW_ERROR: ");
                outline24.append(webView.toString());
                DeviceLog.error(outline24.toString());
            }
            if (webResourceRequest != null) {
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("WEBVIEW_ERROR: ");
                outline242.append(webResourceRequest.toString());
                DeviceLog.error(outline242.toString());
            }
            if (webResourceError != null) {
                StringBuilder outline243 = GeneratedOutlineSupport.outline24("WEBVIEW_ERROR: ");
                outline243.append(webResourceError.toString());
                DeviceLog.error(outline243.toString());
            }
        }

        public boolean onRenderProcessGone(WebView webView, final RenderProcessGoneDetail renderProcessGoneDetail) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    if (AdUnit.getAdUnitActivity() != null) {
                        AdUnit.getAdUnitActivity().finish();
                    }
                    if (!(WebViewApp.getCurrentApp() == null || WebViewApp.getCurrentApp().getWebView() == null)) {
                        ViewUtilities.removeViewFromParent(WebViewApp.getCurrentApp().getWebView());
                    }
                    InitializeThread.reset();
                }
            });
            DeviceLog.error("UnityAds Sdk WebView onRenderProcessGone : " + renderProcessGoneDetail.toString());
            SDKMetrics.getInstance().sendEventWithTags("native_webview_render_process_gone", new HashMap<String, String>() {
                {
                    if (Build.VERSION.SDK_INT >= 26) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("");
                        outline24.append(renderProcessGoneDetail.didCrash());
                        put("dc", outline24.toString());
                        put("pae", "" + renderProcessGoneDetail.rendererPriorityAtExit());
                    }
                }
            });
            return true;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            DeviceLog.debug("Trying to load url: " + str);
            return false;
        }
    }

    public static boolean create(final Configuration configuration) throws IllegalThreadStateException {
        DeviceLog.entered();
        if (!Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        WebViewApp webViewApp = new WebViewApp(configuration);
                        String str = "?platform=android";
                        try {
                            if (configuration.getWebViewUrl() != null) {
                                str = str + "&origin=" + URLEncoder.encode(configuration.getWebViewUrl(), "UTF-8");
                            }
                        } catch (UnsupportedEncodingException e) {
                            DeviceLog.exception("Unsupported charset when encoding origin url", e);
                        }
                        try {
                            if (configuration.getWebViewVersion() != null) {
                                str = str + "&version=" + URLEncoder.encode(configuration.getWebViewVersion(), "UTF-8");
                            }
                        } catch (UnsupportedEncodingException e2) {
                            DeviceLog.exception("Unsupported charset when encoding webview version", e2);
                        }
                        WebView webView = webViewApp.getWebView();
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24(Advertisement.FILE_SCHEME);
                        outline24.append(SdkProperties.getLocalWebViewFile());
                        outline24.append(str);
                        webView.loadDataWithBaseURL(outline24.toString(), configuration.getWebViewData(), "text/html", "UTF-8", (String) null);
                        WebViewApp.setCurrentApp(webViewApp);
                    } catch (Exception unused) {
                        DeviceLog.error("Couldn't construct WebViewApp");
                        WebViewApp._conditionVariable.open();
                    }
                }
            });
            ConditionVariable conditionVariable = new ConditionVariable();
            _conditionVariable = conditionVariable;
            final boolean block = conditionVariable.block(configuration.getWebViewAppCreateTimeout());
            boolean z = true;
            final boolean z2 = getCurrentApp() != null;
            final boolean z3 = z2 && getCurrentApp().isWebAppInitialized();
            if (!block || !z2 || !z3) {
                z = false;
            }
            if (!z) {
                SDKMetrics.getInstance().sendEventWithTags("native_webview_creation_failed", new HashMap<String, String>() {
                    {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("");
                        outline24.append(!block);
                        put("wto", outline24.toString());
                        put("wad", "" + z2);
                        put("wai", "" + z3);
                    }
                });
            }
            return z;
        }
        throw new IllegalThreadStateException("Cannot call create() from main thread!");
    }

    public static WebViewApp getCurrentApp() {
        return _currentApp;
    }

    private void invokeJavascriptMethod(String str, String str2, JSONArray jSONArray) throws JSONException {
        String jSONArray2 = jSONArray.toString();
        String outline19 = GeneratedOutlineSupport.outline19(GeneratedOutlineSupport.outline23(jSONArray2.length() + str2.length() + str.length() + 22, "javascript:window.", str, CodelessMatcher.CURRENT_CLASS_NAME, str2), "(", jSONArray2, ");");
        DeviceLog.debug("Invoking javascript: " + outline19);
        getWebView().invokeJavascript(outline19);
    }

    public static void setCurrentApp(WebViewApp webViewApp) {
        _currentApp = webViewApp;
    }

    public void addCallback(NativeCallback nativeCallback) {
        if (this._nativeCallbacks == null) {
            this._nativeCallbacks = new HashMap<>();
        }
        synchronized (this._nativeCallbacks) {
            this._nativeCallbacks.put(nativeCallback.getId(), nativeCallback);
        }
    }

    public NativeCallback getCallback(String str) {
        NativeCallback nativeCallback;
        synchronized (this._nativeCallbacks) {
            nativeCallback = this._nativeCallbacks.get(str);
        }
        return nativeCallback;
    }

    public Configuration getConfiguration() {
        return this._configuration;
    }

    public int getWebAppFailureCode() {
        return _webAppFailureCode.get().intValue();
    }

    public String getWebAppFailureMessage() {
        return _webAppFailureMessage.get();
    }

    public WebView getWebView() {
        return this._webView;
    }

    public boolean invokeCallback(Invocation invocation) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("invokeBatchCallback ignored because web app is not loaded");
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        ArrayList<ArrayList<Object>> responses = invocation.getResponses();
        if (responses != null && !responses.isEmpty()) {
            Iterator<ArrayList<Object>> it = responses.iterator();
            while (it.hasNext()) {
                ArrayList next = it.next();
                Enum enumR = (Enum) next.get(1);
                Object[] objArr = (Object[]) next.get(2);
                Object[] copyOfRange = Arrays.copyOfRange(objArr, 1, objArr.length);
                ArrayList arrayList = new ArrayList();
                arrayList.add((String) objArr[0]);
                arrayList.add(((CallbackStatus) next.get(0)).toString());
                JSONArray jSONArray2 = new JSONArray();
                if (enumR != null) {
                    jSONArray2.put(enumR.name());
                }
                for (Object put : copyOfRange) {
                    jSONArray2.put(put);
                }
                arrayList.add(jSONArray2);
                JSONArray jSONArray3 = new JSONArray();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONArray.put(jSONArray3);
            }
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleCallback", jSONArray);
        } catch (Exception e) {
            DeviceLog.exception("Error while invoking batch response for WebView", e);
        }
        return true;
    }

    public boolean invokeMethod(String str, String str2, Method method, Object... objArr) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("invokeMethod ignored because web app is not loaded");
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(str);
        jSONArray.put(str2);
        if (method != null) {
            NativeCallback nativeCallback = new NativeCallback(method);
            addCallback(nativeCallback);
            jSONArray.put(nativeCallback.getId());
        } else {
            jSONArray.put((Object) null);
        }
        if (objArr != null) {
            for (Object put : objArr) {
                jSONArray.put(put);
            }
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleInvocation", jSONArray);
            return true;
        } catch (Exception e) {
            DeviceLog.exception("Error invoking javascript method", e);
            return false;
        }
    }

    public boolean isWebAppInitialized() {
        return _initialized.get().booleanValue();
    }

    public boolean isWebAppLoaded() {
        return this._webAppLoaded;
    }

    public void removeCallback(NativeCallback nativeCallback) {
        HashMap<String, NativeCallback> hashMap = this._nativeCallbacks;
        if (hashMap != null) {
            synchronized (hashMap) {
                this._nativeCallbacks.remove(nativeCallback.getId());
            }
        }
    }

    public void resetWebViewAppInitialization() {
        this._webAppLoaded = false;
        _webAppFailureCode.set(-1);
        _webAppFailureMessage.set("");
        _initialized.set(Boolean.FALSE);
    }

    public boolean sendEvent(Enum enumR, Enum enumR2, Object... objArr) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("sendEvent ignored because web app is not loaded");
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(enumR.name());
        jSONArray.put(enumR2.name());
        for (Object put : objArr) {
            jSONArray.put(put);
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleEvent", jSONArray);
            return true;
        } catch (Exception e) {
            DeviceLog.exception("Error while sending event to WebView", e);
            return false;
        }
    }

    public void setConfiguration(Configuration configuration) {
        this._configuration = configuration;
    }

    public void setWebAppFailureCode(int i) {
        _webAppFailureCode.set(Integer.valueOf(i));
    }

    public void setWebAppFailureMessage(String str) {
        _webAppFailureMessage.set(str);
    }

    public void setWebAppInitialized(boolean z) {
        _initialized.set(Boolean.valueOf(z));
        _conditionVariable.open();
    }

    public void setWebAppLoaded(boolean z) {
        this._webAppLoaded = z;
    }

    public void setWebView(WebView webView) {
        this._webView = webView;
    }

    public WebViewApp(Configuration configuration) {
        this._webAppLoaded = false;
        setConfiguration(configuration);
        WebViewBridge.setClassTable(getConfiguration().getWebAppApiClassList());
        WebView webView = new WebView(ClientProperties.getApplicationContext());
        this._webView = webView;
        webView.setWebViewClient(new WebAppClient());
        this._webView.setWebChromeClient(new WebAppChromeClient());
    }

    public WebViewApp() {
        this._webAppLoaded = false;
    }
}
