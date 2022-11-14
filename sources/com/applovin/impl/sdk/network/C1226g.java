package com.applovin.impl.sdk.network;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.g */
public class C1226g {

    /* renamed from: a */
    public String f2335a;

    /* renamed from: b */
    public String f2336b;

    /* renamed from: c */
    public String f2337c;

    /* renamed from: d */
    public String f2338d;

    /* renamed from: e */
    public Map<String, String> f2339e;

    /* renamed from: f */
    public Map<String, String> f2340f;

    /* renamed from: g */
    public Map<String, Object> f2341g;

    /* renamed from: h */
    public boolean f2342h;

    /* renamed from: i */
    public boolean f2343i;

    /* renamed from: j */
    public boolean f2344j;

    /* renamed from: k */
    public String f2345k;

    /* renamed from: l */
    public int f2346l;

    /* renamed from: com.applovin.impl.sdk.network.g$a */
    public static class C1228a {

        /* renamed from: a */
        public String f2347a;

        /* renamed from: b */
        public String f2348b;

        /* renamed from: c */
        public String f2349c;

        /* renamed from: d */
        public String f2350d;

        /* renamed from: e */
        public Map<String, String> f2351e;

        /* renamed from: f */
        public Map<String, String> f2352f;

        /* renamed from: g */
        public Map<String, Object> f2353g;

        /* renamed from: h */
        public boolean f2354h;

        /* renamed from: i */
        public boolean f2355i;

        /* renamed from: j */
        public boolean f2356j;

        /* renamed from: a */
        public C1228a mo11167a(String str) {
            this.f2347a = str;
            return this;
        }

        /* renamed from: a */
        public C1228a mo11168a(Map<String, String> map) {
            this.f2351e = map;
            return this;
        }

        /* renamed from: a */
        public C1228a mo11169a(boolean z) {
            this.f2354h = z;
            return this;
        }

        /* renamed from: a */
        public C1226g mo11170a() {
            return new C1226g(this);
        }

        /* renamed from: b */
        public C1228a mo11171b(String str) {
            this.f2348b = str;
            return this;
        }

        /* renamed from: b */
        public C1228a mo11172b(Map<String, String> map) {
            this.f2352f = map;
            return this;
        }

        /* renamed from: b */
        public C1228a mo11173b(boolean z) {
            this.f2355i = z;
            return this;
        }

        /* renamed from: c */
        public C1228a mo11174c(String str) {
            this.f2349c = str;
            return this;
        }

        /* renamed from: c */
        public C1228a mo11175c(Map<String, Object> map) {
            this.f2353g = map;
            return this;
        }

        /* renamed from: c */
        public C1228a mo11176c(boolean z) {
            this.f2356j = z;
            return this;
        }

        /* renamed from: d */
        public C1228a mo11177d(String str) {
            this.f2350d = str;
            return this;
        }
    }

    public C1226g(C1228a aVar) {
        this.f2335a = UUID.randomUUID().toString();
        this.f2336b = aVar.f2348b;
        this.f2337c = aVar.f2349c;
        this.f2338d = aVar.f2350d;
        this.f2339e = aVar.f2351e;
        this.f2340f = aVar.f2352f;
        this.f2341g = aVar.f2353g;
        this.f2342h = aVar.f2354h;
        this.f2343i = aVar.f2355i;
        this.f2344j = aVar.f2356j;
        this.f2345k = aVar.f2347a;
        this.f2346l = 0;
    }

    public C1226g(JSONObject jSONObject, C1188m mVar) throws Exception {
        String string = JsonUtils.getString(jSONObject, "uniqueId", UUID.randomUUID().toString());
        String string2 = JsonUtils.getString(jSONObject, "communicatorRequestId", "");
        JsonUtils.getString(jSONObject, "httpMethod", "");
        String string3 = jSONObject.getString("targetUrl");
        String string4 = JsonUtils.getString(jSONObject, "backupUrl", "");
        int i = jSONObject.getInt("attemptNumber");
        Map<String, String> synchronizedMap = JsonUtils.valueExists(jSONObject, "parameters") ? Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("parameters"))) : new HashMap<>(0);
        Map<String, String> synchronizedMap2 = JsonUtils.valueExists(jSONObject, "httpHeaders") ? Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("httpHeaders"))) : new HashMap<>(0);
        Map<String, Object> synchronizedMap3 = JsonUtils.valueExists(jSONObject, "requestBody") ? Collections.synchronizedMap(JsonUtils.toStringObjectMap(jSONObject.getJSONObject("requestBody"))) : new HashMap<>(0);
        this.f2335a = string;
        this.f2345k = string2;
        this.f2337c = string3;
        this.f2338d = string4;
        this.f2339e = synchronizedMap;
        this.f2340f = synchronizedMap2;
        this.f2341g = synchronizedMap3;
        this.f2342h = jSONObject.optBoolean("isEncodingEnabled", false);
        this.f2343i = jSONObject.optBoolean("gzipBodyEncoding", false);
        this.f2344j = jSONObject.optBoolean("shouldFireInWebView", false);
        this.f2346l = i;
    }

    /* renamed from: o */
    public static C1228a m2290o() {
        return new C1228a();
    }

    /* renamed from: a */
    public String mo11150a() {
        return this.f2336b;
    }

    /* renamed from: b */
    public String mo11151b() {
        return this.f2337c;
    }

    /* renamed from: c */
    public String mo11152c() {
        return this.f2338d;
    }

    /* renamed from: d */
    public Map<String, String> mo11153d() {
        return this.f2339e;
    }

    /* renamed from: e */
    public Map<String, String> mo11154e() {
        return this.f2340f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1226g.class != obj.getClass()) {
            return false;
        }
        return this.f2335a.equals(((C1226g) obj).f2335a);
    }

    /* renamed from: f */
    public Map<String, Object> mo11156f() {
        return this.f2341g;
    }

    /* renamed from: g */
    public boolean mo11157g() {
        return this.f2342h;
    }

    /* renamed from: h */
    public boolean mo11158h() {
        return this.f2343i;
    }

    public int hashCode() {
        return this.f2335a.hashCode();
    }

    /* renamed from: i */
    public boolean mo11160i() {
        return this.f2344j;
    }

    /* renamed from: j */
    public String mo11161j() {
        return this.f2345k;
    }

    /* renamed from: k */
    public int mo11162k() {
        return this.f2346l;
    }

    /* renamed from: l */
    public void mo11163l() {
        this.f2346l++;
    }

    /* renamed from: m */
    public void mo11164m() {
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.f2339e;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("postback_ts", String.valueOf(System.currentTimeMillis()));
        this.f2339e = hashMap;
    }

    /* renamed from: n */
    public JSONObject mo11165n() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uniqueId", this.f2335a);
        jSONObject.put("communicatorRequestId", this.f2345k);
        jSONObject.put("httpMethod", this.f2336b);
        jSONObject.put("targetUrl", this.f2337c);
        jSONObject.put("backupUrl", this.f2338d);
        jSONObject.put("isEncodingEnabled", this.f2342h);
        jSONObject.put("gzipBodyEncoding", this.f2343i);
        jSONObject.put("attemptNumber", this.f2346l);
        if (this.f2339e != null) {
            jSONObject.put("parameters", new JSONObject(this.f2339e));
        }
        if (this.f2340f != null) {
            jSONObject.put("httpHeaders", new JSONObject(this.f2340f));
        }
        if (this.f2341g != null) {
            jSONObject.put("requestBody", new JSONObject(this.f2341g));
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("PostbackRequest{uniqueId='");
        GeneratedOutlineSupport.outline33(outline24, this.f2335a, '\'', ", communicatorRequestId='");
        GeneratedOutlineSupport.outline33(outline24, this.f2345k, '\'', ", httpMethod='");
        GeneratedOutlineSupport.outline33(outline24, this.f2336b, '\'', ", targetUrl='");
        GeneratedOutlineSupport.outline33(outline24, this.f2337c, '\'', ", backupUrl='");
        GeneratedOutlineSupport.outline33(outline24, this.f2338d, '\'', ", attemptNumber=");
        outline24.append(this.f2346l);
        outline24.append(", isEncodingEnabled=");
        outline24.append(this.f2342h);
        outline24.append(", isGzipBodyEncoding=");
        outline24.append(this.f2343i);
        outline24.append('}');
        return outline24.toString();
    }
}
