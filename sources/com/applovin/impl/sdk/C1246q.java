package com.applovin.impl.sdk;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.applovin.impl.sdk.q */
public class C1246q {

    /* renamed from: a */
    public final String f2400a = UUID.randomUUID().toString();

    /* renamed from: b */
    public final String f2401b;

    /* renamed from: c */
    public final Map<String, Object> f2402c;

    /* renamed from: d */
    public final long f2403d;

    public C1246q(String str, Map<String, String> map, Map<String, Object> map2) {
        this.f2401b = str;
        HashMap hashMap = new HashMap();
        this.f2402c = hashMap;
        hashMap.putAll(map);
        this.f2402c.put("applovin_sdk_super_properties", map2);
        this.f2403d = System.currentTimeMillis();
    }

    /* renamed from: a */
    public String mo11231a() {
        return this.f2401b;
    }

    /* renamed from: b */
    public Map<String, Object> mo11232b() {
        return this.f2402c;
    }

    /* renamed from: c */
    public long mo11233c() {
        return this.f2403d;
    }

    /* renamed from: d */
    public String mo11234d() {
        return this.f2400a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1246q.class != obj.getClass()) {
            return false;
        }
        C1246q qVar = (C1246q) obj;
        if (this.f2403d != qVar.f2403d) {
            return false;
        }
        String str = this.f2401b;
        if (str == null ? qVar.f2401b != null : !str.equals(qVar.f2401b)) {
            return false;
        }
        Map<String, Object> map = this.f2402c;
        if (map == null ? qVar.f2402c != null : !map.equals(qVar.f2402c)) {
            return false;
        }
        String str2 = this.f2400a;
        String str3 = qVar.f2400a;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
    }

    public int hashCode() {
        String str = this.f2401b;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, Object> map = this.f2402c;
        int hashCode2 = map != null ? map.hashCode() : 0;
        long j = this.f2403d;
        int i2 = (((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.f2400a;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Event{name='");
        GeneratedOutlineSupport.outline33(outline24, this.f2401b, '\'', ", id='");
        GeneratedOutlineSupport.outline33(outline24, this.f2400a, '\'', ", creationTimestampMillis=");
        outline24.append(this.f2403d);
        outline24.append(", parameters=");
        outline24.append(this.f2402c);
        outline24.append('}');
        return outline24.toString();
    }
}
