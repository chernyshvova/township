package com.unity3d.services.ads.operation;

import com.unity3d.services.core.request.ISDKMetricSender;
import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;
import com.unity3d.services.core.webview.bridge.WebViewBridgeSharedObjectStore;
import com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocationSingleThreadedExecutor;
import java.util.concurrent.ExecutorService;

public abstract class AdModule<T extends IWebViewSharedObject, T2> extends WebViewBridgeSharedObjectStore<T> implements IAdModule<T, T2> {
    public ExecutorService _executorService = WebViewBridgeInvocationSingleThreadedExecutor.getInstance().getExecutorService();
    public ISDKMetricSender _sdkMetricSender;

    public AdModule(ISDKMetricSender iSDKMetricSender) {
        this._sdkMetricSender = iSDKMetricSender;
    }

    public ISDKMetricSender getMetricSender() {
        return this._sdkMetricSender;
    }
}
