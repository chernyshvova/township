package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.mediation.p012c.C0867c;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.utils.C1259d;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppLovinSdk {
    public static final String TAG = "AppLovinSdk";
    public static final String VERSION = getVersion();
    public static final int VERSION_CODE = getVersionCode();
    public static final Map<String, AppLovinSdk> sdkInstances = new HashMap();
    public static final Object sdkInstancesLock = new Object();
    public final C1188m coreSdk;

    public interface SdkInitializationListener {
        void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration);
    }

    /* renamed from: com.applovin.sdk.AppLovinSdk$a */
    public static class C1366a extends AppLovinSdkSettings {
        public C1366a(Context context) {
            super(context);
        }
    }

    public AppLovinSdk(C1188m mVar) {
        this.coreSdk = mVar;
    }

    /* renamed from: a */
    public static AppLovinSdk m2712a(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (appLovinSdkSettings == null) {
            throw new IllegalArgumentException("No userSettings specified");
        } else if (context != null) {
            synchronized (sdkInstancesLock) {
                if (sdkInstances.containsKey(str)) {
                    AppLovinSdk appLovinSdk = sdkInstances.get(str);
                    return appLovinSdk;
                }
                if (!TextUtils.isEmpty(str) && str.contains(File.separator)) {
                    C1314v.m2663i(TAG, "\n**************************************************\nINVALID SDK KEY: " + str + "\n**************************************************\n");
                    if (!sdkInstances.isEmpty()) {
                        AppLovinSdk next = sdkInstances.values().iterator().next();
                        return next;
                    }
                    str = str.replace(File.separator, "");
                }
                if (sdkInstances.isEmpty()) {
                    String arrays = Arrays.toString(Arrays.copyOf(new Throwable().getStackTrace(), 5));
                    C1314v.m2661g(TAG, "AppLovinSdk.getInstance()\n" + arrays);
                }
                C1188m mVar = new C1188m();
                mVar.mo10958a(str, appLovinSdkSettings, context);
                AppLovinSdk appLovinSdk2 = new AppLovinSdk(mVar);
                mVar.mo10956a(appLovinSdk2);
                sdkInstances.put(str, appLovinSdk2);
                return appLovinSdk2;
            }
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    /* renamed from: a */
    public static List<AppLovinSdk> m2713a() {
        return new ArrayList(sdkInstances.values());
    }

    public static AppLovinSdk getInstance(Context context) {
        return getInstance(new C1366a(context), context);
    }

    public static AppLovinSdk getInstance(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (context != null) {
            return getInstance(C1259d.m2494a(context).mo11272a("applovin.sdk.key", ""), appLovinSdkSettings, context);
        }
        throw new IllegalArgumentException("No context specified");
    }

    public static AppLovinSdk getInstance(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        return m2712a(str, appLovinSdkSettings, context);
    }

    public static String getVersion() {
        return "11.1.0";
    }

    public static int getVersionCode() {
        return 11010099;
    }

    public static void initializeSdk(Context context) {
        initializeSdk(context, (SdkInitializationListener) null);
    }

    public static void initializeSdk(Context context, SdkInitializationListener sdkInitializationListener) {
        if (context != null) {
            AppLovinSdk instance = getInstance(context);
            if (instance != null) {
                instance.initializeSdk(sdkInitializationListener);
            } else {
                C1314v.m2663i(TAG, "Unable to initialize AppLovin SDK: SDK object not created");
            }
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    public static void reinitializeAll(Boolean bool, Boolean bool2, Boolean bool3) {
        synchronized (sdkInstancesLock) {
            for (AppLovinSdk next : sdkInstances.values()) {
                next.coreSdk.mo10981b();
                next.coreSdk.mo10992i();
                if (bool != null) {
                    C1314v B = next.coreSdk.mo10922B();
                    B.mo11374c(TAG, "Toggled 'huc' to " + bool);
                    next.getEventService().trackEvent("huc", CollectionUtils.map("value", bool.toString()));
                }
                if (bool2 != null) {
                    C1314v B2 = next.coreSdk.mo10922B();
                    B2.mo11374c(TAG, "Toggled 'aru' to " + bool2);
                    next.getEventService().trackEvent("aru", CollectionUtils.map("value", bool2.toString()));
                }
                if (bool3 != null) {
                    C1314v B3 = next.coreSdk.mo10922B();
                    B3.mo11374c(TAG, "Toggled 'dns' to " + bool3);
                    next.getEventService().trackEvent("dns", CollectionUtils.map("value", bool3.toString()));
                }
            }
        }
    }

    public AppLovinAdService getAdService() {
        return this.coreSdk.mo11005u();
    }

    public List<MaxMediatedNetworkInfo> getAvailableMediatedNetworks() {
        JSONArray a = C0867c.m937a(this.coreSdk);
        ArrayList arrayList = new ArrayList(a.length());
        for (int i = 0; i < a.length(); i++) {
            arrayList.add(new MaxMediatedNetworkInfoImpl(JsonUtils.getJSONObject(a, i, (JSONObject) null)));
        }
        return arrayList;
    }

    public AppLovinSdkConfiguration getConfiguration() {
        return this.coreSdk.mo11002s();
    }

    public AppLovinEventService getEventService() {
        return this.coreSdk.mo11007w();
    }

    public String getMediationProvider() {
        return this.coreSdk.mo11003t();
    }

    public AppLovinPostbackService getPostbackService() {
        return this.coreSdk.mo10943X();
    }

    public String getSdkKey() {
        return this.coreSdk.mo11010z();
    }

    public AppLovinSdkSettings getSettings() {
        return this.coreSdk.mo10999p();
    }

    public AppLovinTargetingData getTargetingData() {
        return this.coreSdk.mo11001r();
    }

    public String getUserIdentifier() {
        return this.coreSdk.mo10996m();
    }

    public AppLovinUserSegment getUserSegment() {
        return this.coreSdk.mo11000q();
    }

    public AppLovinUserService getUserService() {
        return this.coreSdk.mo11008x();
    }

    public AppLovinVariableService getVariableService() {
        return this.coreSdk.mo11009y();
    }

    public boolean hasCriticalErrors() {
        return this.coreSdk.mo10921A();
    }

    public void initializeSdk() {
    }

    public void initializeSdk(SdkInitializationListener sdkInitializationListener) {
        this.coreSdk.mo10955a(sdkInitializationListener);
    }

    public boolean isEnabled() {
        return this.coreSdk.mo10987d();
    }

    public boolean isInitialized() {
        return this.coreSdk.mo10987d();
    }

    public void setMediationProvider(String str) {
        this.coreSdk.mo10985c(str);
    }

    public void setPluginVersion(String str) {
        this.coreSdk.mo10957a(str);
    }

    public void setUserIdentifier(String str) {
        this.coreSdk.mo10983b(str);
    }

    public void showMediationDebugger() {
        this.coreSdk.mo10995l();
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinSdk{sdkKey='");
        outline24.append(getSdkKey());
        outline24.append("', isEnabled=");
        outline24.append(isEnabled());
        outline24.append(", isFirstSession=");
        outline24.append(this.coreSdk.mo10935P());
        outline24.append('}');
        return outline24.toString();
    }
}
