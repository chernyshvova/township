package com.applovin.impl.sdk.p027c;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import com.facebook.appevents.codeless.CodelessMatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.c.c */
public class C1086c {

    /* renamed from: a */
    public final C1188m f1807a;

    /* renamed from: b */
    public final C1314v f1808b;

    /* renamed from: c */
    public final Context f1809c;

    /* renamed from: d */
    public final SharedPreferences f1810d;

    /* renamed from: e */
    public final Map<String, Object> f1811e = new HashMap();

    /* renamed from: f */
    public final Object f1812f = new Object();

    /* renamed from: g */
    public Map<String, Object> f1813g;

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|3|4|5|7) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1086c(com.applovin.impl.sdk.C1188m r4) {
        /*
            r3 = this;
            r3.<init>()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r3.f1811e = r0
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r3.f1812f = r0
            r3.f1807a = r4
            com.applovin.impl.sdk.v r0 = r4.mo10922B()
            r3.f1808b = r0
            android.content.Context r0 = r4.mo10932L()
            r3.f1809c = r0
            java.lang.String r1 = "com.applovin.sdk.1"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            r3.f1810d = r0
            java.lang.Class<com.applovin.impl.sdk.c.b> r0 = com.applovin.impl.sdk.p027c.C1085b.class
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x003a }
            java.lang.Class.forName(r0)     // Catch:{ all -> 0x003a }
            java.lang.Class<com.applovin.impl.sdk.c.a> r0 = com.applovin.impl.sdk.p027c.C1084a.class
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x003a }
            java.lang.Class.forName(r0)     // Catch:{ all -> 0x003a }
        L_0x003a:
            com.applovin.sdk.AppLovinSdkSettings r0 = r4.mo10999p()     // Catch:{ all -> 0x0058 }
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x0058 }
            java.lang.String r1 = "localSettings"
            java.lang.reflect.Field r0 = com.applovin.impl.sdk.utils.Utils.getField(r0, r1)     // Catch:{ all -> 0x0058 }
            r1 = 1
            r0.setAccessible(r1)     // Catch:{ all -> 0x0058 }
            com.applovin.sdk.AppLovinSdkSettings r4 = r4.mo10999p()     // Catch:{ all -> 0x0058 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0058 }
            java.util.HashMap r4 = (java.util.HashMap) r4     // Catch:{ all -> 0x0058 }
            r3.f1813g = r4     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r3.mo10683b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p027c.C1086c.<init>(com.applovin.impl.sdk.m):void");
    }

    /* renamed from: a */
    public static Object m1653a(String str, JSONObject jSONObject, Object obj) throws JSONException {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("SDK Error: unknown value type: ");
        outline24.append(obj.getClass());
        throw new RuntimeException(outline24.toString());
    }

    /* renamed from: e */
    private String m1654e() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("com.applovin.sdk.");
        outline24.append(Utils.shortenKey(this.f1807a.mo11010z()));
        outline24.append(CodelessMatcher.CURRENT_CLASS_NAME);
        return outline24.toString();
    }

    /* renamed from: a */
    public <T> C1085b<T> mo10677a(String str, C1085b<T> bVar) {
        synchronized (this.f1812f) {
            for (C1085b<T> next : C1085b.m1649c()) {
                if (next.mo10674a().equals(str)) {
                    return next;
                }
            }
            return bVar;
        }
    }

    /* renamed from: a */
    public <T> T mo10678a(C1085b<T> bVar) {
        if (bVar != null) {
            synchronized (this.f1812f) {
                Object obj = this.f1811e.get(bVar.mo10674a());
                if (obj == null) {
                    T b = bVar.mo10675b();
                    return b;
                }
                T a = bVar.mo10673a(obj);
                return a;
            }
        }
        throw new IllegalArgumentException("No setting type specified");
    }

    /* renamed from: a */
    public void mo10679a() {
        String e = m1654e();
        synchronized (this.f1812f) {
            SharedPreferences.Editor edit = this.f1810d.edit();
            for (C1085b next : C1085b.m1649c()) {
                Object obj = this.f1811e.get(next.mo10674a());
                if (obj != null) {
                    this.f1807a.mo10959a(e + next.mo10674a(), obj, edit);
                }
            }
            edit.apply();
        }
    }

    /* renamed from: a */
    public <T> void mo10680a(C1085b<?> bVar, Object obj) {
        if (bVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        } else if (obj != null) {
            synchronized (this.f1812f) {
                this.f1811e.put(bVar.mo10674a(), obj);
            }
        } else {
            throw new IllegalArgumentException("No new value specified");
        }
    }

    /* renamed from: a */
    public void mo10681a(JSONObject jSONObject) {
        C1314v vVar;
        String str;
        String str2;
        synchronized (this.f1812f) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && next.length() > 0) {
                    try {
                        C1085b<Long> a = mo10677a(next, (C1085b) null);
                        if (a != null) {
                            this.f1811e.put(a.mo10674a(), m1653a(next, jSONObject, a.mo10675b()));
                            if (a == C1085b.f1799ev) {
                                this.f1811e.put(C1085b.f1800ew.mo10674a(), Long.valueOf(System.currentTimeMillis()));
                            }
                        }
                    } catch (JSONException e) {
                        th = e;
                        vVar = this.f1808b;
                        str = "SettingsManager";
                        str2 = "Unable to parse JSON settingsValues array";
                        vVar.mo11373b(str, str2, th);
                    } catch (Throwable th) {
                        th = th;
                        vVar = this.f1808b;
                        str = "SettingsManager";
                        str2 = "Unable to convert setting object ";
                        vVar.mo11373b(str, str2, th);
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.applovin.impl.sdk.c.b<java.lang.String>, com.applovin.impl.sdk.c.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> mo10682b(com.applovin.impl.sdk.p027c.C1085b<java.lang.String> r1) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.mo10678a(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.util.List r1 = com.applovin.impl.sdk.utils.CollectionUtils.explode(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p027c.C1086c.mo10682b(com.applovin.impl.sdk.c.b):java.util.List");
    }

    /* renamed from: b */
    public void mo10683b() {
        String e = m1654e();
        synchronized (this.f1812f) {
            for (C1085b next : C1085b.m1649c()) {
                try {
                    Object a = this.f1807a.mo10948a(e + next.mo10674a(), null, next.mo10675b().getClass(), this.f1810d);
                    if (a != null) {
                        this.f1811e.put(next.mo10674a(), a);
                    }
                } catch (Exception e2) {
                    C1314v vVar = this.f1808b;
                    vVar.mo11373b("SettingsManager", "Unable to load \"" + next.mo10674a() + "\"", e2);
                }
            }
        }
    }

    /* renamed from: c */
    public List<MaxAdFormat> mo10684c(C1085b<String> bVar) {
        ArrayList arrayList = new ArrayList(6);
        for (String formatFromString : mo10682b(bVar)) {
            arrayList.add(MaxAdFormat.formatFromString(formatFromString));
        }
        return arrayList;
    }

    /* renamed from: c */
    public void mo10685c() {
        synchronized (this.f1812f) {
            this.f1811e.clear();
        }
        this.f1807a.mo10951a(this.f1810d);
    }

    /* renamed from: d */
    public boolean mo10686d() {
        return this.f1807a.mo10999p().isVerboseLoggingEnabled() || ((Boolean) mo10678a(C1085b.f1576ah)).booleanValue();
    }
}
