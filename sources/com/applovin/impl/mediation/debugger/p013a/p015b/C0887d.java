package com.applovin.impl.mediation.debugger.p013a.p015b;

import android.content.Context;
import com.applovin.impl.sdk.utils.C1263g;

/* renamed from: com.applovin.impl.mediation.debugger.a.b.d */
public class C0887d {

    /* renamed from: a */
    public final String f883a;

    /* renamed from: b */
    public final String f884b;

    /* renamed from: c */
    public final boolean f885c;

    public C0887d(String str, String str2, Context context) {
        this.f883a = str.replace("android.permission.", "");
        this.f884b = str2;
        this.f885c = C1263g.m2505a(str, context);
    }

    /* renamed from: a */
    public String mo10098a() {
        return this.f883a;
    }

    /* renamed from: b */
    public String mo10099b() {
        return this.f884b;
    }

    /* renamed from: c */
    public boolean mo10100c() {
        return this.f885c;
    }
}
