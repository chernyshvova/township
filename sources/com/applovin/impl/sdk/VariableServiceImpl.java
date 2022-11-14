package com.applovin.impl.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1134m;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinVariableService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class VariableServiceImpl implements AppLovinVariableService {

    /* renamed from: a */
    public final C1188m f1288a;

    /* renamed from: b */
    public final AtomicBoolean f1289b = new AtomicBoolean();

    /* renamed from: c */
    public final AtomicBoolean f1290c = new AtomicBoolean();

    /* renamed from: d */
    public AppLovinVariableService.OnVariablesUpdateListener f1291d;

    /* renamed from: e */
    public Bundle f1292e;

    /* renamed from: f */
    public final Object f1293f = new Object();

    public VariableServiceImpl(C1188m mVar) {
        this.f1288a = mVar;
        String str = (String) mVar.mo10947a(C1087d.f1827j);
        if (StringUtils.isValidString(str)) {
            updateVariables(JsonUtils.deserialize(str));
        }
    }

    /* renamed from: a */
    private Object m1367a(String str, Object obj, Class<?> cls) {
        if (TextUtils.isEmpty(str)) {
            C1314v.m2663i("AppLovinVariableService", "Unable to retrieve variable value for empty name");
            return obj;
        }
        if (!this.f1288a.mo10987d()) {
            C1314v.m2662h(AppLovinSdk.TAG, "Attempted to retrieve variable before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        synchronized (this.f1293f) {
            if (this.f1292e == null) {
                C1314v.m2663i("AppLovinVariableService", "Unable to retrieve variable value for name \"" + str + "\". No variables returned by the server.");
                return obj;
            } else if (cls.equals(String.class)) {
                String string = this.f1292e.getString(str, (String) obj);
                return string;
            } else if (cls.equals(Boolean.class)) {
                Boolean valueOf = Boolean.valueOf(this.f1292e.getBoolean(str, ((Boolean) obj).booleanValue()));
                return valueOf;
            } else {
                throw new IllegalStateException("Unable to retrieve variable value for " + str);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1369a() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f1293f
            monitor-enter(r0)
            com.applovin.sdk.AppLovinVariableService$OnVariablesUpdateListener r1 = r4.f1291d     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x001f
            android.os.Bundle r1 = r4.f1292e     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x000c
            goto L_0x001f
        L_0x000c:
            android.os.Bundle r1 = r4.f1292e     // Catch:{ all -> 0x0021 }
            java.lang.Object r1 = r1.clone()     // Catch:{ all -> 0x0021 }
            android.os.Bundle r1 = (android.os.Bundle) r1     // Catch:{ all -> 0x0021 }
            r2 = 1
            com.applovin.impl.sdk.VariableServiceImpl$2 r3 = new com.applovin.impl.sdk.VariableServiceImpl$2     // Catch:{ all -> 0x0021 }
            r3.<init>(r1)     // Catch:{ all -> 0x0021 }
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThread(r2, r3)     // Catch:{ all -> 0x0021 }
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return
        L_0x0021:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.VariableServiceImpl.m1369a():void");
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return ((Boolean) m1367a(str, Boolean.valueOf(z), Boolean.class)).booleanValue();
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        return (String) m1367a(str, str2, String.class);
    }

    @Deprecated
    public void loadVariables() {
        String str;
        if (!this.f1288a.mo10987d()) {
            str = "The AppLovin SDK is waiting for the initial variables to be returned upon completing initialization.";
        } else if (this.f1289b.compareAndSet(false, true)) {
            this.f1288a.mo10938S().mo10829a((C1109a) new C1134m(this.f1288a, new C1134m.C1136a() {
                /* renamed from: a */
                public void mo10432a() {
                    VariableServiceImpl.this.f1289b.set(false);
                }
            }), C1140o.C1142a.BACKGROUND);
            return;
        } else {
            str = "Ignored explicit variables load. Service is already in the process of retrieving the latest set of variables.";
        }
        C1314v.m2663i("AppLovinVariableService", str);
    }

    @Deprecated
    public void setOnVariablesUpdateListener(AppLovinVariableService.OnVariablesUpdateListener onVariablesUpdateListener) {
        this.f1291d = onVariablesUpdateListener;
        synchronized (this.f1293f) {
            if (onVariablesUpdateListener != null) {
                if (this.f1292e != null && this.f1290c.compareAndSet(false, true)) {
                    this.f1288a.mo10922B().mo11372b("AppLovinVariableService", "Setting initial listener");
                    m1369a();
                }
            }
        }
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("VariableService{variables=");
        outline24.append(this.f1292e);
        outline24.append(", listener=");
        outline24.append(this.f1291d);
        outline24.append('}');
        return outline24.toString();
    }

    public void updateVariables(JSONObject jSONObject) {
        C1314v B = this.f1288a.mo10922B();
        B.mo11372b("AppLovinVariableService", "Updating variables: " + jSONObject + "...");
        synchronized (this.f1293f) {
            this.f1292e = JsonUtils.toBundle(jSONObject);
            m1369a();
            this.f1288a.mo10953a(C1087d.f1827j, jSONObject.toString());
        }
    }
}
