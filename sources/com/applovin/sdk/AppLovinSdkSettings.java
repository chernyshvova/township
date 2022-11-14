package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppLovinSdkSettings {

    /* renamed from: a */
    public boolean f2715a;

    /* renamed from: b */
    public boolean f2716b;

    /* renamed from: c */
    public boolean f2717c;

    /* renamed from: d */
    public boolean f2718d;

    /* renamed from: e */
    public boolean f2719e;

    /* renamed from: f */
    public List<String> f2720f = Collections.emptyList();

    /* renamed from: g */
    public List<String> f2721g = Collections.emptyList();

    /* renamed from: h */
    public final Map<String, String> f2722h = new HashMap();

    /* renamed from: i */
    public final Object f2723i = new Object();
    public final Map<String, Object> localSettings = new HashMap();
    public final Map<String, String> metaData = new HashMap();

    public AppLovinSdkSettings(Context context) {
        this.f2715a = Utils.isVerboseLoggingEnabled(context);
        this.f2717c = true;
        this.f2718d = true;
        this.f2719e = true;
    }

    public Map<String, String> getExtraParameters() {
        HashMap hashMap;
        synchronized (this.f2723i) {
            hashMap = new HashMap(this.f2722h);
        }
        return hashMap;
    }

    public List<String> getInitializationAdUnitIds() {
        return this.f2721g;
    }

    public List<String> getTestDeviceAdvertisingIds() {
        return this.f2720f;
    }

    public boolean isCreativeDebuggerEnabled() {
        return this.f2717c;
    }

    public boolean isExceptionHandlerEnabled() {
        return this.f2718d;
    }

    public boolean isLocationCollectionEnabled() {
        return this.f2719e;
    }

    public boolean isMuted() {
        return this.f2716b;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.f2715a;
    }

    public void setCreativeDebuggerEnabled(boolean z) {
        this.f2717c = z;
    }

    public void setExceptionHandlerEnabled(boolean z) {
        this.f2718d = z;
    }

    public void setExtraParameter(String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str)) {
            C1314v.m2663i("AppLovinSdkSettings", "Failed to set extra parameter for null or empty key: " + str);
            return;
        }
        synchronized (this.f2723i) {
            this.f2722h.put(str, str2);
        }
    }

    public void setInitializationAdUnitIds(List<String> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String next : list) {
                if (StringUtils.isValidString(next) && next.length() > 0) {
                    if (next.length() == 16) {
                        arrayList.add(next);
                    } else {
                        C1314v.m2663i("AppLovinSdkSettings", "Unable to set initialization ad unit id (" + next + ") - please make sure it is in the format of XXXXXXXXXXXXXXXX");
                    }
                }
            }
            this.f2721g = arrayList;
            return;
        }
        this.f2721g = Collections.emptyList();
    }

    public void setLocationCollectionEnabled(boolean z) {
        this.f2719e = z;
    }

    public void setMuted(boolean z) {
        this.f2716b = z;
    }

    public void setTestDeviceAdvertisingIds(List<String> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String next : list) {
                if (next == null || next.length() != 36) {
                    C1314v.m2663i("AppLovinSdkSettings", "Unable to set test device advertising id (" + next + ") - please make sure it is in the format of xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
                } else {
                    arrayList.add(next);
                }
            }
            this.f2720f = arrayList;
            return;
        }
        this.f2720f = Collections.emptyList();
    }

    public void setVerboseLogging(boolean z) {
        if (Utils.isVerboseLoggingConfigured()) {
            C1314v.m2663i("AppLovinSdkSettings", "Ignoring setting of verbose logging - it is configured from Android manifest already.");
            if (Utils.isVerboseLoggingEnabled((Context) null) != z) {
                C1314v.m2663i("AppLovinSdkSettings", "Attempted to programmatically set verbose logging flag to value different from value configured in Android Manifest.");
                return;
            }
            return;
        }
        this.f2715a = z;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinSdkSettings{isVerboseLoggingEnabled=");
        outline24.append(this.f2715a);
        outline24.append(", muted=");
        outline24.append(this.f2716b);
        outline24.append(", testDeviceAdvertisingIds=");
        outline24.append(this.f2720f.toString());
        outline24.append(", initializationAdUnitIds=");
        outline24.append(this.f2721g.toString());
        outline24.append(", creativeDebuggerEnabled=");
        outline24.append(this.f2717c);
        outline24.append(", exceptionHandlerEnabled=");
        outline24.append(this.f2718d);
        outline24.append(", locationCollectionEnabled=");
        outline24.append(this.f2719e);
        outline24.append('}');
        return outline24.toString();
    }
}
