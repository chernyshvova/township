package com.applovin.impl.sdk.p025ad;

import android.text.TextUtils;
import android.util.Base64;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.c */
public class C1054c {

    /* renamed from: a */
    public final C1188m f1400a;

    /* renamed from: b */
    public final String f1401b;

    /* renamed from: com.applovin.impl.sdk.ad.c$a */
    public enum C1055a {
        UNSPECIFIED("UNSPECIFIED"),
        REGULAR("REGULAR"),
        AD_RESPONSE_JSON("AD_RESPONSE_JSON");
        

        /* renamed from: d */
        public final String f1406d;

        /* access modifiers changed from: public */
        C1055a(String str) {
            this.f1406d = str;
        }

        public String toString() {
            return this.f1406d;
        }
    }

    public C1054c(String str, C1188m mVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Identifier is empty");
        } else if (mVar != null) {
            this.f1401b = str;
            this.f1400a = mVar;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    private String m1466a(C1085b<String> bVar) {
        for (String next : this.f1400a.mo10980b(bVar)) {
            if (this.f1401b.startsWith(next)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String mo10540a() {
        return this.f1401b;
    }

    /* renamed from: b */
    public C1055a mo10541b() {
        return m1466a(C1085b.f1628bg) != null ? C1055a.REGULAR : m1466a(C1085b.f1629bh) != null ? C1055a.AD_RESPONSE_JSON : C1055a.UNSPECIFIED;
    }

    /* renamed from: c */
    public String mo10542c() {
        String a = m1466a(C1085b.f1628bg);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = m1466a(C1085b.f1629bh);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return null;
    }

    /* renamed from: d */
    public JSONObject mo10543d() {
        if (mo10541b() != C1055a.AD_RESPONSE_JSON) {
            return null;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.f1401b.substring(mo10542c().length()), 0), "UTF-8"));
                C1314v B = this.f1400a.mo10922B();
                B.mo11372b("AdToken", "Decoded token into ad response: " + jSONObject);
                return jSONObject;
            } catch (JSONException e) {
                C1314v B2 = this.f1400a.mo10922B();
                B2.mo11373b("AdToken", "Unable to decode token '" + this.f1401b + "' into JSON", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            this.f1400a.mo10922B().mo11373b("AdToken", GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline24("Unable to process ad response from token '"), this.f1401b, "'"), e2);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1054c)) {
            return false;
        }
        String str = this.f1401b;
        String str2 = ((C1054c) obj).f1401b;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.f1401b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder outline27 = GeneratedOutlineSupport.outline27("AdToken{id=", StringUtils.prefixToIndex(32, this.f1401b), ", type=");
        outline27.append(mo10541b());
        outline27.append('}');
        return outline27.toString();
    }
}
