package com.applovin.impl.mediation;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.mediation.p010a.C0806f;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.GraphRequest;
import com.facebook.applinks.FacebookAppLinkResolver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.f */
public class C0949f {

    /* renamed from: a */
    public final C1188m f1119a;

    /* renamed from: b */
    public final C1314v f1120b;

    /* renamed from: c */
    public final Object f1121c = new Object();

    /* renamed from: d */
    public final Map<String, Class<? extends MaxAdapter>> f1122d = new HashMap();

    /* renamed from: e */
    public final Set<String> f1123e = new HashSet();

    /* renamed from: f */
    public final Object f1124f = new Object();

    /* renamed from: g */
    public final Set<C0950a> f1125g = new HashSet();

    /* renamed from: com.applovin.impl.mediation.f$a */
    public static class C0950a {

        /* renamed from: a */
        public final String f1126a;

        /* renamed from: b */
        public final String f1127b;

        /* renamed from: c */
        public final MaxAdFormat f1128c;

        /* renamed from: d */
        public final JSONObject f1129d;

        public C0950a(String str, String str2, @Nullable C0801a aVar, C1188m mVar) {
            this.f1126a = str;
            this.f1127b = str2;
            JSONObject jSONObject = new JSONObject();
            this.f1129d = jSONObject;
            JsonUtils.putString(jSONObject, FacebookAppLinkResolver.APP_LINK_TARGET_CLASS_KEY, str);
            JsonUtils.putString(this.f1129d, "operation", str2);
            if (aVar != null) {
                this.f1128c = aVar.getFormat();
                if (aVar.getFormat() != null) {
                    JsonUtils.putString(this.f1129d, GraphRequest.FORMAT_PARAM, aVar.getFormat().getLabel());
                    return;
                }
                return;
            }
            this.f1128c = null;
        }

        /* renamed from: a */
        public JSONObject mo10240a() {
            return this.f1129d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0950a.class != obj.getClass()) {
                return false;
            }
            C0950a aVar = (C0950a) obj;
            if (!this.f1126a.equals(aVar.f1126a) || !this.f1127b.equals(aVar.f1127b)) {
                return false;
            }
            MaxAdFormat maxAdFormat = this.f1128c;
            MaxAdFormat maxAdFormat2 = aVar.f1128c;
            return maxAdFormat == null ? maxAdFormat2 == null : maxAdFormat.equals(maxAdFormat2);
        }

        public int hashCode() {
            int outline4 = GeneratedOutlineSupport.outline4(this.f1127b, this.f1126a.hashCode() * 31, 31);
            MaxAdFormat maxAdFormat = this.f1128c;
            return outline4 + (maxAdFormat != null ? maxAdFormat.hashCode() : 0);
        }

        public String toString() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("DisabledAdapterInfo{className='");
            GeneratedOutlineSupport.outline33(outline24, this.f1126a, '\'', ", operationTag='");
            GeneratedOutlineSupport.outline33(outline24, this.f1127b, '\'', ", format=");
            outline24.append(this.f1128c);
            outline24.append('}');
            return outline24.toString();
        }
    }

    public C0949f(C1188m mVar) {
        if (mVar != null) {
            this.f1119a = mVar;
            this.f1120b = mVar.mo10922B();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: a */
    private C0951g m1265a(C0806f fVar, Class<? extends MaxAdapter> cls) {
        try {
            return new C0951g(fVar, (MediationAdapterBase) cls.getConstructor(new Class[]{AppLovinSdk.class}).newInstance(new Object[]{this.f1119a.mo10944Y()}), this.f1119a);
        } catch (Throwable th) {
            C1314v.m2659c("MediationAdapterManager", "Failed to load adapter: " + fVar, th);
            return null;
        }
    }

    /* renamed from: a */
    private Class<? extends MaxAdapter> m1266a(String str) {
        Class<MaxAdapter> cls = MaxAdapter.class;
        try {
            Class<?> cls2 = Class.forName(str);
            if (cls.isAssignableFrom(cls2)) {
                return cls2.asSubclass(cls);
            }
            C1314v.m2663i("MediationAdapterManager", str + " error: not an instance of '" + cls.getName() + "'.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public C0951g mo10235a(C0806f fVar) {
        Class<? extends MaxAdapter> cls;
        if (fVar != null) {
            String P = fVar.mo9898P();
            String O = fVar.mo9897O();
            if (TextUtils.isEmpty(P)) {
                C1314v vVar = this.f1120b;
                vVar.mo11376e("MediationAdapterManager", "No adapter name provided for " + O + ", not loading the adapter ");
                return null;
            } else if (TextUtils.isEmpty(O)) {
                C1314v vVar2 = this.f1120b;
                vVar2.mo11376e("MediationAdapterManager", "Unable to find default className for '" + P + "'");
                return null;
            } else {
                synchronized (this.f1121c) {
                    if (!this.f1123e.contains(O)) {
                        if (this.f1122d.containsKey(O)) {
                            cls = this.f1122d.get(O);
                        } else {
                            cls = m1266a(O);
                            if (cls == null) {
                                this.f1123e.add(O);
                                return null;
                            }
                        }
                        C0951g a = m1265a(fVar, cls);
                        if (a != null) {
                            C1314v vVar3 = this.f1120b;
                            vVar3.mo11372b("MediationAdapterManager", "Loaded " + P);
                            this.f1122d.put(O, cls);
                            return a;
                        }
                        C1314v vVar4 = this.f1120b;
                        vVar4.mo11376e("MediationAdapterManager", "Failed to load " + P);
                        this.f1123e.add(O);
                        return null;
                    }
                    C1314v vVar5 = this.f1120b;
                    vVar5.mo11372b("MediationAdapterManager", "Not attempting to load " + P + " due to prior errors");
                    return null;
                }
            }
        } else {
            throw new IllegalArgumentException("No adapter spec specified");
        }
    }

    /* renamed from: a */
    public Collection<String> mo10236a() {
        Set unmodifiableSet;
        synchronized (this.f1121c) {
            HashSet hashSet = new HashSet(this.f1122d.size());
            for (Class<? extends MaxAdapter> name : this.f1122d.values()) {
                hashSet.add(name.getName());
            }
            unmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        return unmodifiableSet;
    }

    /* renamed from: a */
    public void mo10237a(String str, String str2, @Nullable C0801a aVar) {
        synchronized (this.f1124f) {
            C1314v B = this.f1119a.mo10922B();
            B.mo11376e("MediationAdapterManager", "Adding " + str + " to list of disabled adapters.");
            this.f1125g.add(new C0950a(str, str2, aVar, this.f1119a));
        }
    }

    /* renamed from: b */
    public Collection<String> mo10238b() {
        Set<T> unmodifiableSet;
        synchronized (this.f1121c) {
            unmodifiableSet = Collections.unmodifiableSet(this.f1123e);
        }
        return unmodifiableSet;
    }

    /* renamed from: c */
    public Collection<JSONObject> mo10239c() {
        ArrayList arrayList;
        synchronized (this.f1124f) {
            arrayList = new ArrayList(this.f1125g.size());
            for (C0950a a : this.f1125g) {
                arrayList.add(a.mo10240a());
            }
        }
        return arrayList;
    }
}
