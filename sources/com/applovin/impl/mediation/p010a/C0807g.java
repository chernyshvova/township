package com.applovin.impl.mediation.p010a;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.C0951g;

/* renamed from: com.applovin.impl.mediation.a.g */
public class C0807g {

    /* renamed from: a */
    public final C0809h f612a;

    /* renamed from: b */
    public final String f613b;

    /* renamed from: c */
    public final String f614c;

    /* renamed from: d */
    public final String f615d;

    /* renamed from: e */
    public final String f616e;

    /* renamed from: com.applovin.impl.mediation.a.g$a */
    public interface C0808a {
        /* renamed from: a */
        void mo9940a(C0807g gVar);
    }

    public C0807g(C0809h hVar, C0951g gVar, String str, String str2) {
        String str3;
        this.f612a = hVar;
        this.f615d = str;
        this.f616e = str2;
        if (gVar != null) {
            this.f613b = gVar.mo10258h();
            str3 = gVar.mo10259i();
        } else {
            str3 = null;
            this.f613b = null;
        }
        this.f614c = str3;
    }

    /* renamed from: a */
    public static C0807g m760a(C0809h hVar, C0951g gVar, String str) {
        if (hVar == null) {
            throw new IllegalArgumentException("No spec specified");
        } else if (gVar != null) {
            return new C0807g(hVar, gVar, str, (String) null);
        } else {
            throw new IllegalArgumentException("No adapterWrapper specified");
        }
    }

    /* renamed from: a */
    public static C0807g m761a(C0809h hVar, String str) {
        return m762b(hVar, (C0951g) null, str);
    }

    /* renamed from: b */
    public static C0807g m762b(C0809h hVar, C0951g gVar, String str) {
        if (hVar != null) {
            return new C0807g(hVar, gVar, (String) null, str);
        }
        throw new IllegalArgumentException("No spec specified");
    }

    /* renamed from: a */
    public C0809h mo9934a() {
        return this.f612a;
    }

    /* renamed from: b */
    public String mo9935b() {
        return this.f613b;
    }

    /* renamed from: c */
    public String mo9936c() {
        return this.f614c;
    }

    /* renamed from: d */
    public String mo9937d() {
        return this.f615d;
    }

    /* renamed from: e */
    public String mo9938e() {
        return this.f616e;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("SignalCollectionResult{mSignalProviderSpec=");
        outline24.append(this.f612a);
        outline24.append(", mSdkVersion='");
        GeneratedOutlineSupport.outline33(outline24, this.f613b, '\'', ", mAdapterVersion='");
        GeneratedOutlineSupport.outline33(outline24, this.f614c, '\'', ", mSignalDataLength='");
        String str = this.f615d;
        outline24.append(str != null ? str.length() : 0);
        outline24.append('\'');
        outline24.append(", mErrorMessage=");
        outline24.append(this.f616e);
        outline24.append('}');
        return outline24.toString();
    }
}
