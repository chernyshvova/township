package com.applovin.impl.sdk.p028d;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.d.a */
public class C1093a {

    /* renamed from: a */
    public final String f1859a;

    /* renamed from: b */
    public final String f1860b;

    /* renamed from: c */
    public final Map<String, String> f1861c;

    /* renamed from: d */
    public final boolean f1862d;

    public C1093a(String str, String str2) {
        this(str, str2, (Map<String, String>) null, false);
    }

    public C1093a(String str, String str2, Map<String, String> map, boolean z) {
        this.f1859a = str;
        this.f1860b = str2;
        this.f1861c = map;
        this.f1862d = z;
    }

    /* renamed from: a */
    public String mo10710a() {
        return this.f1859a;
    }

    /* renamed from: b */
    public String mo10711b() {
        return this.f1860b;
    }

    /* renamed from: c */
    public Map<String, String> mo10712c() {
        return this.f1861c;
    }

    /* renamed from: d */
    public boolean mo10713d() {
        return this.f1862d;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AdEventPostback{url='");
        GeneratedOutlineSupport.outline33(outline24, this.f1859a, '\'', ", backupUrl='");
        GeneratedOutlineSupport.outline33(outline24, this.f1860b, '\'', ", headers='");
        outline24.append(this.f1861c);
        outline24.append('\'');
        outline24.append(", shouldFireInWebView='");
        outline24.append(this.f1862d);
        outline24.append('\'');
        outline24.append('}');
        return outline24.toString();
    }
}
