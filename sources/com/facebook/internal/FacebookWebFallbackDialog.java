package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.facebook.internal.WebDialog;
import com.helpshift.support.fragments.SingleQuestionFragment;
import com.vungle.warren.log.LogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FacebookWebFallbackDialog.kt */
public final class FacebookWebFallbackDialog extends WebDialog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS = 1500;
    public static final String TAG;
    public boolean waitingForDialogToClose;

    /* compiled from: FacebookWebFallbackDialog.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FacebookWebFallbackDialog newInstance(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(str2, "expectedRedirectUrl");
            WebDialog.Companion companion = WebDialog.Companion;
            WebDialog.initDefaultTheme(context);
            return new FacebookWebFallbackDialog(context, str, str2, (DefaultConstructorMarker) null);
        }
    }

    static {
        String name = FacebookWebFallbackDialog.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "FacebookWebFallbackDialog::class.java.name");
        TAG = name;
    }

    public FacebookWebFallbackDialog(Context context, String str, String str2) {
        super(context, str);
        setExpectedRedirectUrl(str2);
    }

    public /* synthetic */ FacebookWebFallbackDialog(Context context, String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2);
    }

    /* renamed from: cancel$lambda-0  reason: not valid java name */
    public static final void m3614cancel$lambda0(FacebookWebFallbackDialog facebookWebFallbackDialog) {
        Intrinsics.checkNotNullParameter(facebookWebFallbackDialog, "this$0");
        super.cancel();
    }

    public static final FacebookWebFallbackDialog newInstance(Context context, String str, String str2) {
        return Companion.newInstance(context, str, str2);
    }

    public void cancel() {
        WebView webView = getWebView();
        if (!isPageFinished() || isListenerCalled() || webView == null || !webView.isShown()) {
            super.cancel();
        } else if (!this.waitingForDialogToClose) {
            this.waitingForDialogToClose = true;
            webView.loadUrl(Intrinsics.stringPlus(SingleQuestionFragment.JS_inlineScriptTag, "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();"));
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    FacebookWebFallbackDialog.m3614cancel$lambda0(FacebookWebFallbackDialog.this);
                }
            }, 1500);
        }
    }

    public Bundle parseResponseUri(String str) {
        Uri parse = Uri.parse(str);
        Utility utility = Utility.INSTANCE;
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
        String string = parseUrlQueryString.getString("bridge_args");
        parseUrlQueryString.remove("bridge_args");
        Utility utility2 = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                BundleJSONConverter bundleJSONConverter = BundleJSONConverter.INSTANCE;
                parseUrlQueryString.putBundle(NativeProtocol.EXTRA_PROTOCOL_BRIDGE_ARGS, BundleJSONConverter.convertToBundle(jSONObject));
            } catch (JSONException e) {
                Utility utility3 = Utility.INSTANCE;
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e);
            }
        }
        String string2 = parseUrlQueryString.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_RESULTS);
        parseUrlQueryString.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_RESULTS);
        Utility utility4 = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(string2)) {
            try {
                JSONObject jSONObject2 = new JSONObject(string2);
                BundleJSONConverter bundleJSONConverter2 = BundleJSONConverter.INSTANCE;
                parseUrlQueryString.putBundle(NativeProtocol.EXTRA_PROTOCOL_METHOD_RESULTS, BundleJSONConverter.convertToBundle(jSONObject2));
            } catch (JSONException e2) {
                Utility utility5 = Utility.INSTANCE;
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e2);
            }
        }
        parseUrlQueryString.remove("version");
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        parseUrlQueryString.putInt(NativeProtocol.EXTRA_PROTOCOL_VERSION, NativeProtocol.getLatestKnownVersion());
        return parseUrlQueryString;
    }
}
