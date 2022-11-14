package com.applovin.impl.p007a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.C1310q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.a.b */
public class C0636b {

    /* renamed from: a */
    public final String f92a;

    /* renamed from: b */
    public final List<C0641g> f93b;

    /* renamed from: c */
    public final String f94c;

    /* renamed from: d */
    public final Set<C0645j> f95d;

    public C0636b(String str, List<C0641g> list, String str2, Set<C0645j> set) {
        this.f92a = str;
        this.f93b = list;
        this.f94c = str2;
        this.f95d = set;
    }

    @Nullable
    /* renamed from: a */
    public static C0636b m104a(C1310q qVar, C0639e eVar, C1188m mVar) {
        try {
            String str = qVar.mo11351b().get("vendor");
            C1310q c = qVar.mo11352c("VerificationParameters");
            String c2 = c != null ? c.mo11353c() : null;
            List<C1310q> a = qVar.mo11349a("JavaScriptResource");
            ArrayList arrayList = new ArrayList(a.size());
            for (C1310q a2 : a) {
                C0641g a3 = C0641g.m125a(a2, mVar);
                if (a3 != null) {
                    arrayList.add(a3);
                }
            }
            HashMap hashMap = new HashMap();
            C0647l.m151a(qVar, (Map<String, Set<C0645j>>) hashMap, eVar, mVar);
            return new C0636b(str, arrayList, c2, (Set) hashMap.get("verificationNotExecuted"));
        } catch (Throwable th) {
            mVar.mo10922B().mo11373b("VastAdVerification", "Error occurred while initializing", th);
            return null;
        }
    }

    /* renamed from: a */
    public String mo9345a() {
        return this.f92a;
    }

    /* renamed from: b */
    public List<C0641g> mo9346b() {
        return this.f93b;
    }

    /* renamed from: c */
    public String mo9347c() {
        return this.f94c;
    }

    /* renamed from: d */
    public Set<C0645j> mo9348d() {
        return this.f95d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0636b.class != obj.getClass()) {
            return false;
        }
        C0636b bVar = (C0636b) obj;
        String str = this.f92a;
        if (str == null ? bVar.f92a != null : !str.equals(bVar.f92a)) {
            return false;
        }
        List<C0641g> list = this.f93b;
        if (list == null ? bVar.f93b != null : !list.equals(bVar.f93b)) {
            return false;
        }
        String str2 = this.f94c;
        if (str2 == null ? bVar.f94c != null : !str2.equals(bVar.f94c)) {
            return false;
        }
        Set<C0645j> set = this.f95d;
        Set<C0645j> set2 = bVar.f95d;
        return set != null ? set.equals(set2) : set2 == null;
    }

    public int hashCode() {
        String str = this.f92a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<C0641g> list = this.f93b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f94c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set<C0645j> set = this.f95d;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode3 + i;
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("VastAdVerification{vendorId='");
        GeneratedOutlineSupport.outline33(outline24, this.f92a, '\'', "javascriptResources='");
        outline24.append(this.f93b);
        outline24.append('\'');
        outline24.append("verificationParameters='");
        GeneratedOutlineSupport.outline33(outline24, this.f94c, '\'', "errorEventTrackers='");
        outline24.append(this.f95d);
        outline24.append('\'');
        outline24.append('}');
        return outline24.toString();
    }
}
