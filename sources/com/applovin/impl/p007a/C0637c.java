package com.applovin.impl.p007a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.C1310q;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.a.c */
public class C0637c {

    /* renamed from: a */
    public final List<C0636b> f96a;

    public C0637c(List<C0636b> list) {
        this.f96a = list;
    }

    @Nullable
    /* renamed from: a */
    public static C0637c m109a(C1310q qVar, @Nullable C0637c cVar, C0639e eVar, C1188m mVar) {
        List list;
        if (cVar != null) {
            try {
                list = cVar.mo9352a();
            } catch (Throwable th) {
                mVar.mo10922B().mo11373b("VastAdVerifications", "Error occurred while initializing", th);
                return null;
            }
        } else {
            list = new ArrayList();
        }
        for (C1310q a : qVar.mo11349a("Verification")) {
            C0636b a2 = C0636b.m104a(a, eVar, mVar);
            if (a2 != null) {
                list.add(a2);
            }
        }
        return new C0637c(list);
    }

    /* renamed from: a */
    public List<C0636b> mo9352a() {
        return this.f96a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0637c)) {
            return false;
        }
        return this.f96a.equals(((C0637c) obj).f96a);
    }

    public int hashCode() {
        return this.f96a.hashCode();
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("VastAdVerification{verifications='");
        outline24.append(this.f96a);
        outline24.append('\'');
        outline24.append('}');
        return outline24.toString();
    }
}
