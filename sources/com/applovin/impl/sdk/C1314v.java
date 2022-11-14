package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.C1301k;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.helpshift.logger.Logger;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.v */
public class C1314v {

    /* renamed from: a */
    public final C1188m f2573a;

    public C1314v(final C1188m mVar) {
        this.f2573a = mVar;
        if (!mVar.mo10988e()) {
            m2656a("SDK Session Begin");
            mVar.mo10972aj().registerReceiver(new AppLovinBroadcastManager.Receiver() {
                public void onReceive(Context context, Intent intent, @Nullable Map<String, Object> map) {
                    C1314v.this.m2656a("SDK Session End");
                    mVar.mo10972aj().unregisterReceiver(this);
                }
            }, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2656a(String str) {
        C1301k kVar = new C1301k();
        kVar.mo11316a().mo11322a(str).mo11316a();
        m2660f(AppLovinSdk.TAG, kVar.toString());
    }

    /* renamed from: a */
    private void m2657a(String str, String str2, boolean z) {
        int intValue;
        if (StringUtils.isValidString(str2) && (intValue = ((Integer) this.f2573a.mo10946a(C1085b.f1586ar)).intValue()) > 0) {
            int length = str2.length();
            int i = ((length + intValue) - 1) / intValue;
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2 * intValue;
                String substring = str2.substring(i3, Math.min(length, i3 + intValue));
                if (z) {
                    Log.d(str, substring);
                } else {
                    mo11372b(str, substring);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m2658a() {
        return this.f2573a.mo10931K().mo10686d();
    }

    /* renamed from: c */
    public static void m2659c(String str, String str2, Throwable th) {
        Log.e(AppLovinSdk.TAG, "[" + str + "] " + str2, th);
    }

    /* renamed from: f */
    public static void m2660f(String str, String str2) {
        Log.d(AppLovinSdk.TAG, "[" + str + "] " + str2);
    }

    /* renamed from: g */
    public static void m2661g(String str, String str2) {
        Log.i(AppLovinSdk.TAG, "[" + str + "] " + str2);
    }

    /* renamed from: h */
    public static void m2662h(String str, String str2) {
        Log.w(AppLovinSdk.TAG, "[" + str + "] " + str2);
    }

    /* renamed from: i */
    public static void m2663i(String str, String str2) {
        m2659c(str, str2, (Throwable) null);
    }

    /* renamed from: j */
    private void m2664j(String str, String str2) {
    }

    /* renamed from: a */
    public void mo11370a(String str, String str2) {
        if (m2658a()) {
            m2657a(str, str2, false);
        }
    }

    /* renamed from: a */
    public void mo11371a(String str, String str2, Throwable th) {
        if (m2658a()) {
            String str3 = "[" + str + "] " + str2;
            Log.w(AppLovinSdk.TAG, str3, th);
            m2664j(Logger.WARN, str3);
        }
    }

    /* renamed from: b */
    public void mo11372b(String str, String str2) {
        if (m2658a()) {
            String str3 = "[" + str + "] " + str2;
            Log.d(AppLovinSdk.TAG, str3);
            m2664j(Logger.DEBUG, str3);
        }
    }

    /* renamed from: b */
    public void mo11373b(String str, String str2, Throwable th) {
        if (m2658a()) {
            String str3 = "[" + str + "] " + str2;
            Log.e(AppLovinSdk.TAG, str3, th);
            m2664j(Logger.ERROR, str3 + " : " + th);
        }
    }

    /* renamed from: c */
    public void mo11374c(String str, String str2) {
        if (m2658a()) {
            String str3 = "[" + str + "] " + str2;
            Log.i(AppLovinSdk.TAG, str3);
            m2664j("INFO", str3);
        }
    }

    /* renamed from: d */
    public void mo11375d(String str, String str2) {
        mo11371a(str, str2, (Throwable) null);
    }

    /* renamed from: e */
    public void mo11376e(String str, String str2) {
        mo11373b(str, str2, (Throwable) null);
    }
}
