package com.applovin.impl.p007a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.C1310q;

/* renamed from: com.applovin.impl.a.g */
public class C0641g {

    /* renamed from: a */
    public final String f128a;

    /* renamed from: b */
    public final String f129b;

    public C0641g(String str, String str2) {
        this.f128a = str;
        this.f129b = str2;
    }

    @Nullable
    /* renamed from: a */
    public static C0641g m125a(C1310q qVar, C1188m mVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            try {
                return new C0641g(qVar.mo11351b().get("apiFramework"), qVar.mo11353c());
            } catch (Throwable th) {
                mVar.mo10922B().mo11373b("VastJavaScriptResource", "Error occurred while initializing", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public String mo9372a() {
        return this.f128a;
    }

    /* renamed from: b */
    public String mo9373b() {
        return this.f129b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0641g.class != obj.getClass()) {
            return false;
        }
        C0641g gVar = (C0641g) obj;
        String str = this.f128a;
        if (str == null ? gVar.f128a != null : !str.equals(gVar.f128a)) {
            return false;
        }
        String str2 = this.f129b;
        String str3 = gVar.f129b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.f128a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f129b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("VastJavaScriptResource{apiFramework='");
        GeneratedOutlineSupport.outline33(outline24, this.f128a, '\'', ", javascriptResourceUrl='");
        outline24.append(this.f129b);
        outline24.append('\'');
        outline24.append('}');
        return outline24.toString();
    }
}
