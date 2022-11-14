package com.applovin.impl.p007a;

import android.net.Uri;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.C1310q;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.a.d */
public class C0638d {

    /* renamed from: a */
    public int f97a;

    /* renamed from: b */
    public int f98b;

    /* renamed from: c */
    public Uri f99c;

    /* renamed from: d */
    public C0642h f100d;

    /* renamed from: e */
    public Set<C0645j> f101e = new HashSet();

    /* renamed from: f */
    public Map<String, Set<C0645j>> f102f = new HashMap();

    /* renamed from: a */
    public static C0638d m111a(C1310q qVar, C0638d dVar, C0639e eVar, C1188m mVar) {
        C1310q b;
        if (qVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            if (dVar == null) {
                try {
                    dVar = new C0638d();
                } catch (Throwable th) {
                    mVar.mo10922B().mo11373b("VastCompanionAd", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (dVar.f97a == 0 && dVar.f98b == 0) {
                int parseInt = StringUtils.parseInt(qVar.mo11351b().get("width"));
                int parseInt2 = StringUtils.parseInt(qVar.mo11351b().get("height"));
                if (parseInt > 0 && parseInt2 > 0) {
                    dVar.f97a = parseInt;
                    dVar.f98b = parseInt2;
                }
            }
            dVar.f100d = C0642h.m128a(qVar, dVar.f100d, mVar);
            if (dVar.f99c == null && (b = qVar.mo11350b("CompanionClickThrough")) != null) {
                String c = b.mo11353c();
                if (StringUtils.isValidString(c)) {
                    dVar.f99c = Uri.parse(c);
                }
            }
            C0647l.m152a(qVar.mo11349a("CompanionClickTracking"), dVar.f101e, eVar, mVar);
            C0647l.m151a(qVar, dVar.f102f, eVar, mVar);
            return dVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public Uri mo9356a() {
        return this.f99c;
    }

    /* renamed from: b */
    public C0642h mo9357b() {
        return this.f100d;
    }

    /* renamed from: c */
    public Set<C0645j> mo9358c() {
        return this.f101e;
    }

    /* renamed from: d */
    public Map<String, Set<C0645j>> mo9359d() {
        return this.f102f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0638d)) {
            return false;
        }
        C0638d dVar = (C0638d) obj;
        if (this.f97a != dVar.f97a || this.f98b != dVar.f98b) {
            return false;
        }
        Uri uri = this.f99c;
        if (uri == null ? dVar.f99c != null : !uri.equals(dVar.f99c)) {
            return false;
        }
        C0642h hVar = this.f100d;
        if (hVar == null ? dVar.f100d != null : !hVar.equals(dVar.f100d)) {
            return false;
        }
        Set<C0645j> set = this.f101e;
        if (set == null ? dVar.f101e != null : !set.equals(dVar.f101e)) {
            return false;
        }
        Map<String, Set<C0645j>> map = this.f102f;
        Map<String, Set<C0645j>> map2 = dVar.f102f;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        int i = ((this.f97a * 31) + this.f98b) * 31;
        Uri uri = this.f99c;
        int i2 = 0;
        int hashCode = (i + (uri != null ? uri.hashCode() : 0)) * 31;
        C0642h hVar = this.f100d;
        int hashCode2 = (hashCode + (hVar != null ? hVar.hashCode() : 0)) * 31;
        Set<C0645j> set = this.f101e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<C0645j>> map = this.f102f;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("VastCompanionAd{width=");
        outline24.append(this.f97a);
        outline24.append(", height=");
        outline24.append(this.f98b);
        outline24.append(", destinationUri=");
        outline24.append(this.f99c);
        outline24.append(", nonVideoResource=");
        outline24.append(this.f100d);
        outline24.append(", clickTrackers=");
        outline24.append(this.f101e);
        outline24.append(", eventTrackers=");
        outline24.append(this.f102f);
        outline24.append('}');
        return outline24.toString();
    }
}
