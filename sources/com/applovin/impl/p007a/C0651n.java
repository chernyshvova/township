package com.applovin.impl.p007a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.C1310q;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Locale;

/* renamed from: com.applovin.impl.a.n */
public class C0651n {

    /* renamed from: a */
    public Uri f160a;

    /* renamed from: b */
    public Uri f161b;

    /* renamed from: c */
    public C0652a f162c;

    /* renamed from: d */
    public String f163d;

    /* renamed from: e */
    public int f164e;

    /* renamed from: f */
    public int f165f;

    /* renamed from: g */
    public int f166g;

    /* renamed from: com.applovin.impl.a.n$a */
    public enum C0652a {
        Progressive,
        Streaming
    }

    /* renamed from: a */
    public static C0652a m171a(String str) {
        if (StringUtils.isValidString(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return C0652a.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return C0652a.Streaming;
            }
        }
        return C0652a.Progressive;
    }

    /* renamed from: a */
    public static C0651n m172a(C1310q qVar, C1188m mVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            try {
                String c = qVar.mo11353c();
                if (URLUtil.isValidUrl(c)) {
                    Uri parse = Uri.parse(c);
                    C0651n nVar = new C0651n();
                    nVar.f160a = parse;
                    nVar.f161b = parse;
                    nVar.f166g = StringUtils.parseInt(qVar.mo11351b().get("bitrate"));
                    nVar.f162c = m171a(qVar.mo11351b().get("delivery"));
                    nVar.f165f = StringUtils.parseInt(qVar.mo11351b().get("height"));
                    nVar.f164e = StringUtils.parseInt(qVar.mo11351b().get("width"));
                    nVar.f163d = qVar.mo11351b().get("type").toLowerCase(Locale.ENGLISH);
                    return nVar;
                }
                mVar.mo10922B().mo11376e("VastVideoFile", "Unable to create video file. Could not find URL.");
                return null;
            } catch (Throwable th) {
                mVar.mo10922B().mo11373b("VastVideoFile", "Error occurred while initializing", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public Uri mo9406a() {
        return this.f160a;
    }

    /* renamed from: a */
    public void mo9407a(Uri uri) {
        this.f161b = uri;
    }

    /* renamed from: b */
    public Uri mo9408b() {
        return this.f161b;
    }

    /* renamed from: c */
    public String mo9409c() {
        return this.f163d;
    }

    /* renamed from: d */
    public int mo9410d() {
        return this.f166g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0651n)) {
            return false;
        }
        C0651n nVar = (C0651n) obj;
        if (this.f164e != nVar.f164e || this.f165f != nVar.f165f || this.f166g != nVar.f166g) {
            return false;
        }
        Uri uri = this.f160a;
        if (uri == null ? nVar.f160a != null : !uri.equals(nVar.f160a)) {
            return false;
        }
        Uri uri2 = this.f161b;
        if (uri2 == null ? nVar.f161b != null : !uri2.equals(nVar.f161b)) {
            return false;
        }
        if (this.f162c != nVar.f162c) {
            return false;
        }
        String str = this.f163d;
        String str2 = nVar.f163d;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        Uri uri = this.f160a;
        int i = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.f161b;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        C0652a aVar = this.f162c;
        int hashCode3 = (hashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.f163d;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((((hashCode3 + i) * 31) + this.f164e) * 31) + this.f165f) * 31) + this.f166g;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("VastVideoFile{sourceVideoUri=");
        outline24.append(this.f160a);
        outline24.append(", videoUri=");
        outline24.append(this.f161b);
        outline24.append(", deliveryType=");
        outline24.append(this.f162c);
        outline24.append(", fileType='");
        GeneratedOutlineSupport.outline33(outline24, this.f163d, '\'', ", width=");
        outline24.append(this.f164e);
        outline24.append(", height=");
        outline24.append(this.f165f);
        outline24.append(", bitrate=");
        outline24.append(this.f166g);
        outline24.append('}');
        return outline24.toString();
    }
}
