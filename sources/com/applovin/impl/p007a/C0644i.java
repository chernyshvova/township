package com.applovin.impl.p007a;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.C1310q;
import com.applovin.impl.sdk.utils.StringUtils;

/* renamed from: com.applovin.impl.a.i */
public class C0644i {

    /* renamed from: a */
    public String f138a;

    /* renamed from: b */
    public String f139b;

    /* renamed from: a */
    public static C0644i m135a(C1310q qVar, C0644i iVar, C1188m mVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            if (iVar == null) {
                try {
                    iVar = new C0644i();
                } catch (Throwable th) {
                    mVar.mo10922B().mo11373b("VastSystemInfo", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (!StringUtils.isValidString(iVar.f138a)) {
                String c = qVar.mo11353c();
                if (StringUtils.isValidString(c)) {
                    iVar.f138a = c;
                }
            }
            if (!StringUtils.isValidString(iVar.f139b)) {
                String str = qVar.mo11351b().get("version");
                if (StringUtils.isValidString(str)) {
                    iVar.f139b = str;
                }
            }
            return iVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public String mo9385a() {
        return this.f138a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0644i)) {
            return false;
        }
        C0644i iVar = (C0644i) obj;
        String str = this.f138a;
        if (str == null ? iVar.f138a != null : !str.equals(iVar.f138a)) {
            return false;
        }
        String str2 = this.f139b;
        String str3 = iVar.f139b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.f138a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f139b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("VastSystemInfo{name='");
        GeneratedOutlineSupport.outline33(outline24, this.f138a, '\'', ", version='");
        outline24.append(this.f139b);
        outline24.append('\'');
        outline24.append('}');
        return outline24.toString();
    }
}
