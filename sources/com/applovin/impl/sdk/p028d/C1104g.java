package com.applovin.impl.sdk.p028d;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.g */
public class C1104g {

    /* renamed from: a */
    public final C1188m f1944a;

    /* renamed from: b */
    public final Map<String, Long> f1945b = new HashMap();

    public C1104g(C1188m mVar) {
        if (mVar != null) {
            this.f1944a = mVar;
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: e */
    private void m1769e() {
        try {
            this.f1944a.mo10953a(C1087d.f1834q, mo10763c().toString());
        } catch (Throwable th) {
            this.f1944a.mo10922B().mo11373b("GlobalStatsManager", "Unable to save stats", th);
        }
    }

    /* renamed from: a */
    public long mo10757a(C1103f fVar) {
        return mo10758a(fVar, 1);
    }

    /* renamed from: a */
    public long mo10758a(C1103f fVar, long j) {
        long longValue;
        synchronized (this.f1945b) {
            Long l = this.f1945b.get(fVar.mo10756a());
            if (l == null) {
                l = 0L;
            }
            longValue = l.longValue() + j;
            this.f1945b.put(fVar.mo10756a(), Long.valueOf(longValue));
        }
        m1769e();
        return longValue;
    }

    /* renamed from: a */
    public void mo10759a() {
        synchronized (this.f1945b) {
            this.f1945b.clear();
        }
        m1769e();
    }

    /* renamed from: b */
    public long mo10760b(C1103f fVar) {
        long longValue;
        synchronized (this.f1945b) {
            Long l = this.f1945b.get(fVar.mo10756a());
            if (l == null) {
                l = 0L;
            }
            longValue = l.longValue();
        }
        return longValue;
    }

    /* renamed from: b */
    public void mo10761b() {
        synchronized (this.f1945b) {
            for (C1103f a : C1103f.m1767b()) {
                this.f1945b.remove(a.mo10756a());
            }
            m1769e();
        }
    }

    /* renamed from: b */
    public void mo10762b(C1103f fVar, long j) {
        synchronized (this.f1945b) {
            this.f1945b.put(fVar.mo10756a(), Long.valueOf(j));
        }
        m1769e();
    }

    /* renamed from: c */
    public JSONObject mo10763c() throws JSONException {
        JSONObject jSONObject;
        synchronized (this.f1945b) {
            jSONObject = new JSONObject();
            for (Map.Entry next : this.f1945b.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
        }
        return jSONObject;
    }

    /* renamed from: c */
    public void mo10764c(C1103f fVar) {
        synchronized (this.f1945b) {
            this.f1945b.remove(fVar.mo10756a());
        }
        m1769e();
    }

    /* renamed from: d */
    public void mo10765d() {
        try {
            JSONObject jSONObject = new JSONObject((String) this.f1944a.mo10978b(C1087d.f1834q, JsonUtils.EMPTY_JSON));
            synchronized (this.f1945b) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        this.f1945b.put(next, Long.valueOf(jSONObject.getLong(next)));
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            this.f1944a.mo10922B().mo11373b("GlobalStatsManager", "Unable to load stats", th);
        }
    }
}
