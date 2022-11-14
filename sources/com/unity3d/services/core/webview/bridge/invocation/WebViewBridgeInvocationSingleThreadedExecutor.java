package com.unity3d.services.core.webview.bridge.invocation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebViewBridgeInvocationSingleThreadedExecutor {
    public static WebViewBridgeInvocationSingleThreadedExecutor instance;
    public ExecutorService _ExecutorService = Executors.newSingleThreadExecutor();

    public static WebViewBridgeInvocationSingleThreadedExecutor getInstance() {
        if (instance == null) {
            instance = new WebViewBridgeInvocationSingleThreadedExecutor();
        }
        return instance;
    }

    public ExecutorService getExecutorService() {
        return this._ExecutorService;
    }
}
