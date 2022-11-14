package com.applovin.impl.sdk.p026b;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.b.c */
public class C1082c {

    /* renamed from: a */
    public final String f1483a;

    /* renamed from: b */
    public Map<String, String> f1484b;

    public C1082c(String str, Map<String, String> map) {
        this.f1483a = str;
        this.f1484b = map;
    }

    /* renamed from: a */
    public static C1082c m1637a(String str) {
        return m1638a(str, (Map<String, String>) null);
    }

    /* renamed from: a */
    public static C1082c m1638a(String str, Map<String, String> map) {
        return new C1082c(str, map);
    }

    /* renamed from: a */
    public Map<String, String> mo10666a() {
        return this.f1484b;
    }

    /* renamed from: b */
    public String mo10667b() {
        return this.f1483a;
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("PendingReward{result='");
        GeneratedOutlineSupport.outline33(outline24, this.f1483a, '\'', "params='");
        outline24.append(this.f1484b);
        outline24.append('\'');
        outline24.append('}');
        return outline24.toString();
    }
}
