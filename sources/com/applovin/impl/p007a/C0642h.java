package com.applovin.impl.p007a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.C1310q;
import com.applovin.impl.sdk.utils.StringUtils;

/* renamed from: com.applovin.impl.a.h */
public class C0642h {

    /* renamed from: a */
    public C0643a f130a;

    /* renamed from: b */
    public Uri f131b;

    /* renamed from: c */
    public String f132c;

    /* renamed from: com.applovin.impl.a.h$a */
    public enum C0643a {
        UNSPECIFIED,
        STATIC,
        IFRAME,
        HTML
    }

    /* renamed from: a */
    public static C0642h m128a(C1310q qVar, C0642h hVar, C1188m mVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            if (hVar == null) {
                try {
                    hVar = new C0642h();
                } catch (Throwable th) {
                    mVar.mo10922B().mo11373b("VastNonVideoResource", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (hVar.f131b == null && !StringUtils.isValidString(hVar.f132c)) {
                String a = m129a(qVar, "StaticResource");
                if (URLUtil.isValidUrl(a)) {
                    hVar.f131b = Uri.parse(a);
                    hVar.f130a = C0643a.STATIC;
                    return hVar;
                }
                String a2 = m129a(qVar, "IFrameResource");
                if (StringUtils.isValidString(a2)) {
                    hVar.f130a = C0643a.IFRAME;
                    if (URLUtil.isValidUrl(a2)) {
                        hVar.f131b = Uri.parse(a2);
                    } else {
                        hVar.f132c = a2;
                    }
                    return hVar;
                }
                String a3 = m129a(qVar, "HTMLResource");
                if (StringUtils.isValidString(a3)) {
                    hVar.f130a = C0643a.HTML;
                    if (URLUtil.isValidUrl(a3)) {
                        hVar.f131b = Uri.parse(a3);
                    } else {
                        hVar.f132c = a3;
                    }
                }
            }
            return hVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public static String m129a(C1310q qVar, String str) {
        C1310q b = qVar.mo11350b(str);
        if (b != null) {
            return b.mo11353c();
        }
        return null;
    }

    /* renamed from: a */
    public C0643a mo9377a() {
        return this.f130a;
    }

    /* renamed from: a */
    public void mo9378a(Uri uri) {
        this.f131b = uri;
    }

    /* renamed from: a */
    public void mo9379a(String str) {
        this.f132c = str;
    }

    /* renamed from: b */
    public Uri mo9380b() {
        return this.f131b;
    }

    /* renamed from: c */
    public String mo9381c() {
        return this.f132c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0642h)) {
            return false;
        }
        C0642h hVar = (C0642h) obj;
        if (this.f130a != hVar.f130a) {
            return false;
        }
        Uri uri = this.f131b;
        if (uri == null ? hVar.f131b != null : !uri.equals(hVar.f131b)) {
            return false;
        }
        String str = this.f132c;
        String str2 = hVar.f132c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        C0643a aVar = this.f130a;
        int i = 0;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Uri uri = this.f131b;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.f132c;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("VastNonVideoResource{type=");
        outline24.append(this.f130a);
        outline24.append(", resourceUri=");
        outline24.append(this.f131b);
        outline24.append(", resourceContents='");
        outline24.append(this.f132c);
        outline24.append('\'');
        outline24.append('}');
        return outline24.toString();
    }
}
