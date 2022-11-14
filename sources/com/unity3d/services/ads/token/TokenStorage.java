package com.unity3d.services.ads.token;

import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;

public class TokenStorage {
    public static int _accessCounter = 0;
    public static boolean _peekMode = false;
    public static ConcurrentLinkedQueue<String> _queue;

    public static synchronized void appendTokens(JSONArray jSONArray) throws JSONException {
        synchronized (TokenStorage.class) {
            if (_queue == null) {
                _queue = new ConcurrentLinkedQueue<>();
                _accessCounter = 0;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                _queue.add(jSONArray.getString(i));
            }
        }
    }

    public static synchronized void createTokens(JSONArray jSONArray) throws JSONException {
        synchronized (TokenStorage.class) {
            _queue = new ConcurrentLinkedQueue<>();
            _accessCounter = 0;
            for (int i = 0; i < jSONArray.length(); i++) {
                _queue.add(jSONArray.getString(i));
            }
        }
    }

    public static synchronized void deleteTokens() {
        synchronized (TokenStorage.class) {
            _queue = null;
            _accessCounter = 0;
        }
    }

    public static synchronized String getToken() {
        synchronized (TokenStorage.class) {
            if (_queue == null) {
                return null;
            }
            if (_queue.isEmpty()) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.QUEUE_EMPTY, new Object[0]);
                return null;
            } else if (_peekMode) {
                WebViewApp currentApp = WebViewApp.getCurrentApp();
                WebViewEventCategory webViewEventCategory = WebViewEventCategory.TOKEN;
                TokenEvent tokenEvent = TokenEvent.TOKEN_ACCESS;
                int i = _accessCounter;
                _accessCounter = i + 1;
                currentApp.sendEvent(webViewEventCategory, tokenEvent, Integer.valueOf(i));
                String peek = _queue.peek();
                return peek;
            } else {
                WebViewApp currentApp2 = WebViewApp.getCurrentApp();
                WebViewEventCategory webViewEventCategory2 = WebViewEventCategory.TOKEN;
                TokenEvent tokenEvent2 = TokenEvent.TOKEN_ACCESS;
                int i2 = _accessCounter;
                _accessCounter = i2 + 1;
                currentApp2.sendEvent(webViewEventCategory2, tokenEvent2, Integer.valueOf(i2));
                String poll = _queue.poll();
                return poll;
            }
        }
    }

    public static synchronized void setPeekMode(boolean z) {
        synchronized (TokenStorage.class) {
            _peekMode = z;
        }
    }
}
