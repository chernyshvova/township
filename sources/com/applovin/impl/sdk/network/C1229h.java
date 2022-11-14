package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.network.C1217c;
import com.applovin.impl.sdk.p027c.C1085b;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.h */
public class C1229h<T> extends C1217c {

    /* renamed from: a */
    public String f2357a;

    /* renamed from: b */
    public boolean f2358b;

    /* renamed from: com.applovin.impl.sdk.network.h$a */
    public static class C1230a<T> extends C1217c.C1218a<T> {

        /* renamed from: p */
        public String f2359p;

        /* renamed from: q */
        public boolean f2360q;

        public C1230a(C1188m mVar) {
            super(mVar);
            this.f2311h = ((Integer) mVar.mo10946a(C1085b.f1660cM)).intValue();
            this.f2312i = ((Integer) mVar.mo10946a(C1085b.f1659cL)).intValue();
            this.f2313j = ((Integer) mVar.mo10946a(C1085b.f1664cQ)).intValue();
        }

        /* renamed from: b */
        public C1230a mo11126a(T t) {
            this.f2310g = t;
            return this;
        }

        /* renamed from: b */
        public C1230a mo11129a(JSONObject jSONObject) {
            this.f2309f = jSONObject;
            return this;
        }

        /* renamed from: b */
        public C1229h<T> mo11131a() {
            return new C1229h<>(this);
        }

        /* renamed from: c */
        public C1230a mo11128a(Map<String, String> map) {
            this.f2307d = map;
            return this;
        }

        /* renamed from: d */
        public C1230a mo11125a(int i) {
            this.f2311h = i;
            return this;
        }

        /* renamed from: d */
        public C1230a mo11127a(String str) {
            this.f2305b = str;
            return this;
        }

        /* renamed from: d */
        public C1230a mo11134b(Map<String, String> map) {
            this.f2308e = map;
            return this;
        }

        /* renamed from: e */
        public C1230a mo11132b(int i) {
            this.f2312i = i;
            return this;
        }

        /* renamed from: e */
        public C1230a mo11137c(String str) {
            this.f2306c = str;
            return this;
        }

        /* renamed from: f */
        public C1230a mo11136c(int i) {
            this.f2313j = i;
            return this;
        }

        /* renamed from: f */
        public C1230a mo11133b(String str) {
            this.f2304a = str;
            return this;
        }

        /* renamed from: f */
        public C1230a mo11138c(boolean z) {
            this.f2316m = z;
            return this;
        }

        /* renamed from: g */
        public C1230a mo11193g(String str) {
            this.f2359p = str;
            return this;
        }

        /* renamed from: g */
        public C1230a mo11139d(boolean z) {
            this.f2317n = z;
            return this;
        }

        /* renamed from: h */
        public C1230a mo11195h(boolean z) {
            this.f2360q = z;
            return this;
        }
    }

    public C1229h(C1230a aVar) {
        super(aVar);
        this.f2357a = aVar.f2359p;
        this.f2358b = aVar.f2360q;
    }

    /* renamed from: b */
    public static C1230a m2326b(C1188m mVar) {
        return new C1230a(mVar);
    }

    /* renamed from: q */
    public boolean mo11178q() {
        return this.f2357a != null;
    }

    /* renamed from: r */
    public String mo11179r() {
        return this.f2357a;
    }

    /* renamed from: s */
    public boolean mo11180s() {
        return this.f2358b;
    }
}
