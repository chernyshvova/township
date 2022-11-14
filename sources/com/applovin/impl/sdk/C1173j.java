package com.applovin.impl.sdk;

import android.content.Context;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.p027c.C1088e;

/* renamed from: com.applovin.impl.sdk.j */
public class C1173j {

    /* renamed from: a */
    public static final C1174a f2122a = new C1174a("Age Restricted User", C1087d.f1829l);

    /* renamed from: b */
    public static final C1174a f2123b = new C1174a("Has User Consent", C1087d.f1828k);

    /* renamed from: c */
    public static final C1174a f2124c = new C1174a("\"Do Not Sell\"", C1087d.f1830m);

    /* renamed from: com.applovin.impl.sdk.j$a */
    public static class C1174a {

        /* renamed from: a */
        public final String f2125a;

        /* renamed from: b */
        public final C1087d<Boolean> f2126b;

        public C1174a(String str, C1087d<Boolean> dVar) {
            this.f2125a = str;
            this.f2126b = dVar;
        }

        /* renamed from: a */
        public Boolean mo10902a(Context context) {
            return (Boolean) C1088e.m1673b(this.f2126b, null, context);
        }

        /* renamed from: a */
        public String mo10903a() {
            return this.f2125a;
        }

        /* renamed from: b */
        public String mo10904b(Context context) {
            Boolean a = mo10902a(context);
            return a != null ? a.toString() : "No value set";
        }
    }

    /* renamed from: a */
    public static C1174a m2013a() {
        return f2122a;
    }

    /* renamed from: a */
    public static String m2014a(Context context) {
        return m2015a(f2122a, context) + m2015a(f2123b, context) + m2015a(f2124c, context);
    }

    /* renamed from: a */
    public static String m2015a(C1174a aVar, Context context) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("\n");
        outline24.append(aVar.f2125a);
        outline24.append(" - ");
        outline24.append(aVar.mo10904b(context));
        return outline24.toString();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.applovin.impl.sdk.c.d, java.lang.Object, com.applovin.impl.sdk.c.d<java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m2016a(com.applovin.impl.sdk.p027c.C1087d<java.lang.Boolean> r2, java.lang.Boolean r3, android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x001a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to update compliance value for key: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "AppLovinSdk"
            com.applovin.impl.sdk.C1314v.m2663i(r3, r2)
            return r0
        L_0x001a:
            r1 = 0
            java.lang.Object r1 = com.applovin.impl.sdk.p027c.C1088e.m1673b(r2, r1, (android.content.Context) r4)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            com.applovin.impl.sdk.p027c.C1088e.m1671a(r2, r3, (android.content.Context) r4)
            r2 = 1
            if (r1 == 0) goto L_0x002b
            if (r1 == r3) goto L_0x002a
            r0 = 1
        L_0x002a:
            return r0
        L_0x002b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1173j.m2016a(com.applovin.impl.sdk.c.d, java.lang.Boolean, android.content.Context):boolean");
    }

    /* renamed from: a */
    public static boolean m2017a(boolean z, Context context) {
        return m2016a(C1087d.f1829l, Boolean.valueOf(z), context);
    }

    /* renamed from: b */
    public static C1174a m2018b() {
        return f2123b;
    }

    /* renamed from: b */
    public static boolean m2019b(boolean z, Context context) {
        return m2016a(C1087d.f1828k, Boolean.valueOf(z), context);
    }

    /* renamed from: c */
    public static C1174a m2020c() {
        return f2124c;
    }

    /* renamed from: c */
    public static boolean m2021c(boolean z, Context context) {
        return m2016a(C1087d.f1830m, Boolean.valueOf(z), context);
    }
}
