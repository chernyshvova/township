package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.p027c.C1088e;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.sdk.utils.o */
public final class C1306o {

    /* renamed from: a */
    public final C1188m f2553a;
    @Nullable

    /* renamed from: b */
    public String f2554b;

    /* renamed from: c */
    public final String f2555c;

    /* renamed from: d */
    public final String f2556d;

    public C1306o(C1188m mVar) {
        this.f2553a = mVar;
        this.f2555c = m2622a(C1087d.f1824g, (String) C1088e.m1673b(C1087d.f1823f, null, mVar.mo10932L()));
        this.f2556d = m2622a(C1087d.f1825h, (String) mVar.mo10946a(C1085b.f1572ad));
        mo11339a(m2624d());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.applovin.impl.sdk.c.d, com.applovin.impl.sdk.c.d<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m2622a(com.applovin.impl.sdk.p027c.C1087d<java.lang.String> r3, java.lang.String r4) {
        /*
            r2 = this;
            com.applovin.impl.sdk.m r0 = r2.f2553a
            android.content.Context r0 = r0.mo10932L()
            r1 = 0
            java.lang.Object r0 = com.applovin.impl.sdk.p027c.C1088e.m1673b(r3, r1, (android.content.Context) r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r0)
            if (r1 == 0) goto L_0x0014
            return r0
        L_0x0014:
            boolean r0 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r4)
            if (r0 == 0) goto L_0x001b
            goto L_0x0029
        L_0x001b:
            java.util.UUID r4 = java.util.UUID.randomUUID()
            java.lang.String r4 = r4.toString()
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r4 = r4.toLowerCase(r0)
        L_0x0029:
            com.applovin.impl.sdk.m r0 = r2.f2553a
            android.content.Context r0 = r0.mo10932L()
            com.applovin.impl.sdk.p027c.C1088e.m1671a(r3, r4, (android.content.Context) r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.C1306o.m2622a(com.applovin.impl.sdk.c.d, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static String m2623a(C1188m mVar) {
        String str = (String) mVar.mo10947a(C1087d.f1826i);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String valueOf = String.valueOf(((int) (Math.random() * 100.0d)) + 1);
        mVar.mo10953a(C1087d.f1826i, valueOf);
        return valueOf;
    }

    /* renamed from: d */
    private String m2624d() {
        if (!((Boolean) this.f2553a.mo10946a(C1085b.f1751dz)).booleanValue()) {
            this.f2553a.mo10982b(C1087d.f1822e);
        }
        String str = (String) this.f2553a.mo10947a(C1087d.f1822e);
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        C1314v B = this.f2553a.mo10922B();
        B.mo11372b(AppLovinSdk.TAG, "Using identifier (" + str + ") from previous session");
        return str;
    }

    /* renamed from: a */
    public String mo11338a() {
        return this.f2554b;
    }

    /* renamed from: a */
    public void mo11339a(@Nullable String str) {
        if (((Boolean) this.f2553a.mo10946a(C1085b.f1751dz)).booleanValue()) {
            this.f2553a.mo10953a(C1087d.f1822e, str);
        }
        this.f2554b = str;
        Bundle bundle = new Bundle();
        bundle.putString("user_id", StringUtils.emptyIfNull(str));
        bundle.putString("applovin_random_token", mo11341c());
        this.f2553a.mo10969ag().mo10893a(bundle, "user_info");
    }

    /* renamed from: b */
    public String mo11340b() {
        return this.f2555c;
    }

    /* renamed from: c */
    public String mo11341c() {
        return this.f2556d;
    }
}
