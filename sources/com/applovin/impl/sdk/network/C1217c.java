package com.applovin.impl.sdk.network;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p027c.C1085b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.c */
public class C1217c<T> {

    /* renamed from: a */
    public String f2288a;

    /* renamed from: b */
    public String f2289b;

    /* renamed from: c */
    public Map<String, String> f2290c;

    /* renamed from: d */
    public Map<String, String> f2291d;

    /* renamed from: e */
    public final JSONObject f2292e;

    /* renamed from: f */
    public String f2293f;

    /* renamed from: g */
    public final T f2294g;

    /* renamed from: h */
    public final int f2295h;

    /* renamed from: i */
    public int f2296i;

    /* renamed from: j */
    public final int f2297j;

    /* renamed from: k */
    public final int f2298k;

    /* renamed from: l */
    public final boolean f2299l;

    /* renamed from: m */
    public final boolean f2300m;

    /* renamed from: n */
    public final boolean f2301n;

    /* renamed from: o */
    public final boolean f2302o;

    /* renamed from: p */
    public final boolean f2303p;

    /* renamed from: com.applovin.impl.sdk.network.c$a */
    public static class C1218a<T> {

        /* renamed from: a */
        public String f2304a;

        /* renamed from: b */
        public String f2305b;

        /* renamed from: c */
        public String f2306c;

        /* renamed from: d */
        public Map<String, String> f2307d;

        /* renamed from: e */
        public Map<String, String> f2308e;

        /* renamed from: f */
        public JSONObject f2309f;

        /* renamed from: g */
        public T f2310g;

        /* renamed from: h */
        public int f2311h = 1;

        /* renamed from: i */
        public int f2312i;

        /* renamed from: j */
        public int f2313j;

        /* renamed from: k */
        public boolean f2314k;

        /* renamed from: l */
        public boolean f2315l;

        /* renamed from: m */
        public boolean f2316m;

        /* renamed from: n */
        public boolean f2317n;

        /* renamed from: o */
        public boolean f2318o;

        public C1218a(C1188m mVar) {
            this.f2312i = ((Integer) mVar.mo10946a(C1085b.f1665cR)).intValue();
            this.f2313j = ((Integer) mVar.mo10946a(C1085b.f1664cQ)).intValue();
            this.f2315l = ((Boolean) mVar.mo10946a(C1085b.f1663cP)).booleanValue();
            this.f2316m = ((Boolean) mVar.mo10946a(C1085b.f1797et)).booleanValue();
            this.f2317n = ((Boolean) mVar.mo10946a(C1085b.f1802ey)).booleanValue();
            this.f2307d = new HashMap();
        }

        /* renamed from: a */
        public C1218a<T> mo11125a(int i) {
            this.f2311h = i;
            return this;
        }

        /* renamed from: a */
        public C1218a<T> mo11126a(T t) {
            this.f2310g = t;
            return this;
        }

        /* renamed from: a */
        public C1218a<T> mo11127a(String str) {
            this.f2305b = str;
            return this;
        }

        /* renamed from: a */
        public C1218a<T> mo11128a(Map<String, String> map) {
            this.f2307d = map;
            return this;
        }

        /* renamed from: a */
        public C1218a<T> mo11129a(JSONObject jSONObject) {
            this.f2309f = jSONObject;
            return this;
        }

        /* renamed from: a */
        public C1218a<T> mo11130a(boolean z) {
            this.f2314k = z;
            return this;
        }

        /* renamed from: a */
        public C1217c<T> mo11131a() {
            return new C1217c<>(this);
        }

        /* renamed from: b */
        public C1218a<T> mo11132b(int i) {
            this.f2312i = i;
            return this;
        }

        /* renamed from: b */
        public C1218a<T> mo11133b(String str) {
            this.f2304a = str;
            return this;
        }

        /* renamed from: b */
        public C1218a<T> mo11134b(Map<String, String> map) {
            this.f2308e = map;
            return this;
        }

        /* renamed from: b */
        public C1218a<T> mo11135b(boolean z) {
            this.f2315l = z;
            return this;
        }

        /* renamed from: c */
        public C1218a<T> mo11136c(int i) {
            this.f2313j = i;
            return this;
        }

        /* renamed from: c */
        public C1218a<T> mo11137c(String str) {
            this.f2306c = str;
            return this;
        }

        /* renamed from: c */
        public C1218a<T> mo11138c(boolean z) {
            this.f2316m = z;
            return this;
        }

        /* renamed from: d */
        public C1218a<T> mo11139d(boolean z) {
            this.f2317n = z;
            return this;
        }

        /* renamed from: e */
        public C1218a<T> mo11140e(boolean z) {
            this.f2318o = z;
            return this;
        }
    }

    public C1217c(C1218a<T> aVar) {
        this.f2288a = aVar.f2305b;
        this.f2289b = aVar.f2304a;
        this.f2290c = aVar.f2307d;
        this.f2291d = aVar.f2308e;
        this.f2292e = aVar.f2309f;
        this.f2293f = aVar.f2306c;
        this.f2294g = aVar.f2310g;
        int i = aVar.f2311h;
        this.f2295h = i;
        this.f2296i = i;
        this.f2297j = aVar.f2312i;
        this.f2298k = aVar.f2313j;
        this.f2299l = aVar.f2314k;
        this.f2300m = aVar.f2315l;
        this.f2301n = aVar.f2316m;
        this.f2302o = aVar.f2317n;
        this.f2303p = aVar.f2318o;
    }

    /* renamed from: a */
    public static <T> C1218a<T> m2223a(C1188m mVar) {
        return new C1218a<>(mVar);
    }

    /* renamed from: a */
    public String mo11103a() {
        return this.f2288a;
    }

    /* renamed from: a */
    public void mo11104a(int i) {
        this.f2296i = i;
    }

    /* renamed from: a */
    public void mo11105a(String str) {
        this.f2288a = str;
    }

    /* renamed from: b */
    public String mo11106b() {
        return this.f2289b;
    }

    /* renamed from: b */
    public void mo11107b(String str) {
        this.f2289b = str;
    }

    /* renamed from: c */
    public Map<String, String> mo11108c() {
        return this.f2290c;
    }

    /* renamed from: d */
    public Map<String, String> mo11109d() {
        return this.f2291d;
    }

    /* renamed from: e */
    public JSONObject mo11110e() {
        return this.f2292e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1217c)) {
            return false;
        }
        C1217c cVar = (C1217c) obj;
        String str = this.f2288a;
        if (str == null ? cVar.f2288a != null : !str.equals(cVar.f2288a)) {
            return false;
        }
        Map<String, String> map = this.f2290c;
        if (map == null ? cVar.f2290c != null : !map.equals(cVar.f2290c)) {
            return false;
        }
        Map<String, String> map2 = this.f2291d;
        if (map2 == null ? cVar.f2291d != null : !map2.equals(cVar.f2291d)) {
            return false;
        }
        String str2 = this.f2293f;
        if (str2 == null ? cVar.f2293f != null : !str2.equals(cVar.f2293f)) {
            return false;
        }
        String str3 = this.f2289b;
        if (str3 == null ? cVar.f2289b != null : !str3.equals(cVar.f2289b)) {
            return false;
        }
        JSONObject jSONObject = this.f2292e;
        if (jSONObject == null ? cVar.f2292e != null : !jSONObject.equals(cVar.f2292e)) {
            return false;
        }
        T t = this.f2294g;
        if (t == null ? cVar.f2294g == null : t.equals(cVar.f2294g)) {
            return this.f2295h == cVar.f2295h && this.f2296i == cVar.f2296i && this.f2297j == cVar.f2297j && this.f2298k == cVar.f2298k && this.f2299l == cVar.f2299l && this.f2300m == cVar.f2300m && this.f2301n == cVar.f2301n && this.f2302o == cVar.f2302o && this.f2303p == cVar.f2303p;
        }
        return false;
    }

    /* renamed from: f */
    public String mo11112f() {
        return this.f2293f;
    }

    /* renamed from: g */
    public T mo11113g() {
        return this.f2294g;
    }

    /* renamed from: h */
    public int mo11114h() {
        return this.f2296i;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f2288a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2293f;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2289b;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        T t = this.f2294g;
        if (t != null) {
            i = t.hashCode();
        }
        int i2 = ((((((((((((((((((hashCode4 + i) * 31) + this.f2295h) * 31) + this.f2296i) * 31) + this.f2297j) * 31) + this.f2298k) * 31) + (this.f2299l ? 1 : 0)) * 31) + (this.f2300m ? 1 : 0)) * 31) + (this.f2301n ? 1 : 0)) * 31) + (this.f2302o ? 1 : 0)) * 31) + (this.f2303p ? 1 : 0);
        Map<String, String> map = this.f2290c;
        if (map != null) {
            i2 = (i2 * 31) + map.hashCode();
        }
        Map<String, String> map2 = this.f2291d;
        if (map2 != null) {
            i2 = (i2 * 31) + map2.hashCode();
        }
        JSONObject jSONObject = this.f2292e;
        if (jSONObject == null) {
            return i2;
        }
        char[] charArray = jSONObject.toString().toCharArray();
        Arrays.sort(charArray);
        return (i2 * 31) + new String(charArray).hashCode();
    }

    /* renamed from: i */
    public int mo11116i() {
        return this.f2295h - this.f2296i;
    }

    /* renamed from: j */
    public int mo11117j() {
        return this.f2297j;
    }

    /* renamed from: k */
    public int mo11118k() {
        return this.f2298k;
    }

    /* renamed from: l */
    public boolean mo11119l() {
        return this.f2299l;
    }

    /* renamed from: m */
    public boolean mo11120m() {
        return this.f2300m;
    }

    /* renamed from: n */
    public boolean mo11121n() {
        return this.f2301n;
    }

    /* renamed from: o */
    public boolean mo11122o() {
        return this.f2302o;
    }

    /* renamed from: p */
    public boolean mo11123p() {
        return this.f2303p;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("HttpRequest {endpoint=");
        outline24.append(this.f2288a);
        outline24.append(", backupEndpoint=");
        outline24.append(this.f2293f);
        outline24.append(", httpMethod=");
        outline24.append(this.f2289b);
        outline24.append(", httpHeaders=");
        outline24.append(this.f2291d);
        outline24.append(", body=");
        outline24.append(this.f2292e);
        outline24.append(", emptyResponse=");
        outline24.append(this.f2294g);
        outline24.append(", initialRetryAttempts=");
        outline24.append(this.f2295h);
        outline24.append(", retryAttemptsLeft=");
        outline24.append(this.f2296i);
        outline24.append(", timeoutMillis=");
        outline24.append(this.f2297j);
        outline24.append(", retryDelayMillis=");
        outline24.append(this.f2298k);
        outline24.append(", exponentialRetries=");
        outline24.append(this.f2299l);
        outline24.append(", retryOnAllErrors=");
        outline24.append(this.f2300m);
        outline24.append(", encodingEnabled=");
        outline24.append(this.f2301n);
        outline24.append(", gzipBodyEncoding=");
        outline24.append(this.f2302o);
        outline24.append(", trackConnectionSpeed=");
        outline24.append(this.f2303p);
        outline24.append('}');
        return outline24.toString();
    }
}
