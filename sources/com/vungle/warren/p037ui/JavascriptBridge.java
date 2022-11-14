package com.vungle.warren.p037ui;

import android.util.Log;
import android.webkit.JavascriptInterface;

/* renamed from: com.vungle.warren.ui.JavascriptBridge */
public class JavascriptBridge {
    public MraidHandler handler;

    /* renamed from: com.vungle.warren.ui.JavascriptBridge$MraidHandler */
    public interface MraidHandler {
        public static final String CLOSE_ACTION = "close";
        public static final String DOWNLOAD_ACTION = "download";
        public static final String PRIVACY_ACTION = "privacy";

        void onMraidAction(String str);
    }

    public JavascriptBridge(MraidHandler mraidHandler) {
        this.handler = mraidHandler;
    }

    @JavascriptInterface
    public void performAction(String str) {
        Log.d("JavascriptBridge", "actionClicked(" + str + ")");
        this.handler.onMraidAction(str);
    }
}
