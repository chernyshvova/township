package com.applovin.impl.sdk.p028d;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.network.C1217c;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.p029e.C1157u;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.c */
public class C1095c {

    /* renamed from: a */
    public final C1188m f1896a;

    /* renamed from: b */
    public final C1314v f1897b;

    /* renamed from: c */
    public final Object f1898c = new Object();

    /* renamed from: d */
    public final C1100c f1899d = new C1100c();

    /* renamed from: com.applovin.impl.sdk.d.c$a */
    public static class C1098a {

        /* renamed from: a */
        public final C1188m f1902a;

        /* renamed from: b */
        public final JSONObject f1903b;

        public C1098a(String str, String str2, String str3, C1188m mVar) {
            JSONObject jSONObject = new JSONObject();
            this.f1903b = jSONObject;
            this.f1902a = mVar;
            JsonUtils.putString(jSONObject, "pk", str);
            JsonUtils.putLong(this.f1903b, "ts", System.currentTimeMillis());
            if (StringUtils.isValidString(str2)) {
                JsonUtils.putString(this.f1903b, "sk1", str2);
            }
            if (StringUtils.isValidString(str3)) {
                JsonUtils.putString(this.f1903b, "sk2", str3);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String m1727a() throws OutOfMemoryError {
            return this.f1903b.toString();
        }

        /* renamed from: a */
        public void mo10721a(String str, long j) {
            mo10723b(str, JsonUtils.getLong(this.f1903b, str, 0) + j);
        }

        /* renamed from: a */
        public void mo10722a(String str, String str2) {
            JSONArray jSONArray = JsonUtils.getJSONArray(this.f1903b, str, new JSONArray());
            jSONArray.put(str2);
            JsonUtils.putJsonArray(this.f1903b, str, jSONArray);
        }

        /* renamed from: b */
        public void mo10723b(String str, long j) {
            JsonUtils.putLong(this.f1903b, str, j);
        }

        public String toString() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("AdEventStats{stats='");
            outline24.append(this.f1903b);
            outline24.append('\'');
            outline24.append('}');
            return outline24.toString();
        }
    }

    /* renamed from: com.applovin.impl.sdk.d.c$b */
    public class C1099b {

        /* renamed from: b */
        public final AppLovinAdBase f1905b;

        /* renamed from: c */
        public final C1095c f1906c;

        public C1099b(AppLovinAdBase appLovinAdBase, C1095c cVar) {
            this.f1905b = appLovinAdBase;
            this.f1906c = cVar;
        }

        /* renamed from: a */
        public C1099b mo10725a(C1094b bVar) {
            this.f1906c.m1707a(bVar, 1, this.f1905b);
            return this;
        }

        /* renamed from: a */
        public C1099b mo10726a(C1094b bVar, long j) {
            this.f1906c.m1714b(bVar, j, this.f1905b);
            return this;
        }

        /* renamed from: a */
        public C1099b mo10727a(C1094b bVar, String str) {
            this.f1906c.m1708a(bVar, str, this.f1905b);
            return this;
        }

        /* renamed from: a */
        public void mo10728a() {
            this.f1906c.m1720e();
        }
    }

    /* renamed from: com.applovin.impl.sdk.d.c$c */
    public class C1100c extends LinkedHashMap<String, C1098a> {
        public C1100c() {
        }

        public boolean removeEldestEntry(Map.Entry<String, C1098a> entry) {
            return size() > ((Integer) C1095c.this.f1896a.mo10946a(C1085b.f1784eg)).intValue();
        }
    }

    public C1095c(C1188m mVar) {
        this.f1896a = mVar;
        this.f1897b = mVar.mo10922B();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1707a(C1094b bVar, long j, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase != null && bVar != null && ((Boolean) this.f1896a.mo10946a(C1085b.f1781ed)).booleanValue()) {
            synchronized (this.f1898c) {
                m1712b(appLovinAdBase).mo10721a(((Boolean) this.f1896a.mo10946a(C1085b.f1785eh)).booleanValue() ? bVar.mo10716b() : bVar.mo10715a(), j);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1708a(C1094b bVar, String str, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase != null && bVar != null && ((Boolean) this.f1896a.mo10946a(C1085b.f1781ed)).booleanValue()) {
            synchronized (this.f1899d) {
                m1712b(appLovinAdBase).mo10722a(((Boolean) this.f1896a.mo10946a(C1085b.f1785eh)).booleanValue() ? bVar.mo10716b() : bVar.mo10715a(), str);
            }
        }
    }

    /* renamed from: a */
    private void m1711a(JSONObject jSONObject) {
        C10961 r0 = new C1157u<Object>(C1217c.m2223a(this.f1896a).mo11127a(m1717c()).mo11137c(m1719d()).mo11128a(C1264h.m2527e(this.f1896a)).mo11133b("POST").mo11129a(jSONObject).mo11139d(((Boolean) this.f1896a.mo10946a(C1085b.f1755eD)).booleanValue()).mo11132b(((Integer) this.f1896a.mo10946a(C1085b.f1782ee)).intValue()).mo11125a(((Integer) this.f1896a.mo10946a(C1085b.f1783ef)).intValue()).mo11131a(), this.f1896a) {
            /* renamed from: a */
            public void mo10008a(int i, String str, Object obj) {
                C1314v a = C1095c.this.f1897b;
                a.mo11376e("AdEventStatsManager", "Failed to submitted ad stats: " + i);
            }

            /* renamed from: a */
            public void mo10010a(Object obj, int i) {
                C1314v a = C1095c.this.f1897b;
                a.mo11372b("AdEventStatsManager", "Ad stats submitted: " + i);
            }
        };
        r0.mo10853a(C1085b.f1570aZ);
        r0.mo10855b(C1085b.f1622ba);
        this.f1896a.mo10938S().mo10829a((C1109a) r0, C1140o.C1142a.BACKGROUND);
    }

    /* renamed from: b */
    private C1098a m1712b(AppLovinAdBase appLovinAdBase) {
        C1098a aVar;
        synchronized (this.f1898c) {
            String primaryKey = appLovinAdBase.getPrimaryKey();
            aVar = (C1098a) this.f1899d.get(primaryKey);
            if (aVar == null) {
                C1098a aVar2 = new C1098a(primaryKey, appLovinAdBase.getSecondaryKey1(), appLovinAdBase.getSecondaryKey2(), this.f1896a);
                this.f1899d.put(primaryKey, aVar2);
                aVar = aVar2;
            }
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1714b(C1094b bVar, long j, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase != null && bVar != null && ((Boolean) this.f1896a.mo10946a(C1085b.f1781ed)).booleanValue()) {
            synchronized (this.f1898c) {
                m1712b(appLovinAdBase).mo10723b(((Boolean) this.f1896a.mo10946a(C1085b.f1785eh)).booleanValue() ? bVar.mo10716b() : bVar.mo10715a(), j);
            }
        }
    }

    /* renamed from: c */
    private String m1717c() {
        return C1264h.m2514a("2.0/s", this.f1896a);
    }

    /* renamed from: d */
    private String m1719d() {
        return C1264h.m2524b("2.0/s", this.f1896a);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m1720e() {
        if (((Boolean) this.f1896a.mo10946a(C1085b.f1781ed)).booleanValue()) {
            this.f1896a.mo10938S().mo10833b().execute(new Runnable() {
                public void run() {
                    HashSet hashSet;
                    synchronized (C1095c.this.f1898c) {
                        hashSet = new HashSet(C1095c.this.f1899d.size());
                        for (C1098a aVar : C1095c.this.f1899d.values()) {
                            try {
                                hashSet.add(aVar.m1727a());
                            } catch (OutOfMemoryError e) {
                                C1314v a = C1095c.this.f1897b;
                                a.mo11373b("AdEventStatsManager", "Failed to serialize " + aVar + " due to OOM error", e);
                                C1095c.this.mo10719b();
                            }
                        }
                    }
                    C1095c.this.f1896a.mo10953a(C1087d.f1839v, hashSet);
                }
            });
        }
    }

    /* renamed from: a */
    public C1099b mo10717a(AppLovinAdBase appLovinAdBase) {
        return new C1099b(appLovinAdBase, this);
    }

    /* renamed from: a */
    public void mo10718a() {
        if (((Boolean) this.f1896a.mo10946a(C1085b.f1781ed)).booleanValue()) {
            Set<String> set = (Set) this.f1896a.mo10978b(C1087d.f1839v, new HashSet(0));
            this.f1896a.mo10982b(C1087d.f1839v);
            if (set == null || set.isEmpty()) {
                this.f1897b.mo11372b("AdEventStatsManager", "No serialized ad events found");
                return;
            }
            C1314v vVar = this.f1897b;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("De-serializing ");
            outline24.append(set.size());
            outline24.append(" stat ad events");
            vVar.mo11372b("AdEventStatsManager", outline24.toString());
            JSONArray jSONArray = new JSONArray();
            for (String str : set) {
                try {
                    jSONArray.put(new JSONObject(str));
                } catch (JSONException e) {
                    C1314v vVar2 = this.f1897b;
                    vVar2.mo11373b("AdEventStatsManager", "Failed to parse: " + str, e);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("stats", jSONArray);
                m1711a(jSONObject);
            } catch (JSONException e2) {
                this.f1897b.mo11373b("AdEventStatsManager", "Failed to create stats to submit", e2);
            }
        }
    }

    /* renamed from: b */
    public void mo10719b() {
        synchronized (this.f1898c) {
            this.f1897b.mo11372b("AdEventStatsManager", "Clearing ad stats...");
            this.f1899d.clear();
        }
    }
}
