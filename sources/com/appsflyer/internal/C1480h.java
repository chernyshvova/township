package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.appsflyer.internal.h */
public abstract class C1480h {
    @Nullable
    public String AFInAppEventParameterName;
    public final Map<String, Object> AFInAppEventType;
    @Nullable
    public Map<String, Object> AFKeystoreWrapper;
    public String AFLogger$LogLevel;
    public String AFVersionDeclaration;
    public String AppsFlyer2dXConversionCallback;
    public byte[] getLevel;
    public String init;
    public final boolean onAppOpenAttributionNative;
    public int onDeepLinkingNative;
    public boolean onInstallConversionDataLoadedNative;
    public String onInstallConversionFailureNative;
    @Nullable
    public Application valueOf;
    @Nullable
    public AppsFlyerRequestListener values;

    public C1480h() {
        this((String) null, (String) null, (Boolean) null, (Context) null);
    }

    public final boolean AFInAppEventType() {
        return this.onInstallConversionDataLoadedNative;
    }

    public final C1480h AFKeystoreWrapper(Map<String, ?> map) {
        this.AFInAppEventType.putAll(map);
        return this;
    }

    public final Map<String, Object> valueOf() {
        return this.AFInAppEventType;
    }

    public C1480h values(String str) {
        this.onInstallConversionFailureNative = str;
        return this;
    }

    public C1480h(@Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable Context context) {
        this.AFInAppEventType = new HashMap();
        this.AFVersionDeclaration = str;
        this.onInstallConversionFailureNative = str2;
        this.onAppOpenAttributionNative = bool != null ? bool.booleanValue() : true;
        if (context != null) {
            this.valueOf = (Application) context.getApplicationContext();
        }
    }

    @NonNull
    public final String AFInAppEventType(String str) {
        String AFInAppEventParameterName2 = C1387af.AFInAppEventParameterName().AFInAppEventParameterName((Context) this.valueOf);
        return AFInAppEventParameterName2 != null ? Uri.parse(str).buildUpon().appendQueryParameter("channel", AFInAppEventParameterName2).build().toString() : str;
    }

    public final boolean AFKeystoreWrapper() {
        return this.onAppOpenAttributionNative;
    }

    public final byte[] values() {
        return this.getLevel;
    }
}
