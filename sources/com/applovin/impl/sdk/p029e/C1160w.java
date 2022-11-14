package com.applovin.impl.sdk.p029e;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.network.C1213b;
import com.applovin.impl.sdk.p026b.C1082c;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.internal.NativeProtocol;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.w */
public abstract class C1160w extends C1164y {
    public C1160w(String str, C1188m mVar) {
        super(str, mVar);
    }

    /* renamed from: a */
    private JSONObject m1965a(C1082c cVar) {
        JSONObject i = mo10864i();
        JsonUtils.putString(i, "result", cVar.mo10667b());
        Map<String, String> a = cVar.mo10666a();
        if (a != null) {
            JsonUtils.putJSONObject(i, NativeProtocol.WEB_DIALOG_PARAMS, new JSONObject(a));
        }
        return i;
    }

    /* renamed from: b */
    public abstract C1082c mo10023b();

    /* renamed from: b */
    public abstract void mo10024b(JSONObject jSONObject);

    /* renamed from: c */
    public abstract void mo10025c();

    /* renamed from: h */
    public int mo10777h() {
        return ((Integer) this.f1961b.mo10946a(C1085b.f1646by)).intValue();
    }

    public void run() {
        C1082c b = mo10023b();
        if (b != null) {
            mo10768a("Reporting pending reward: " + b + "...");
            mo10863a(m1965a(b), new C1213b.C1216c<JSONObject>() {
                /* renamed from: a */
                public void mo10008a(int i, String str, JSONObject jSONObject) {
                    C1160w.this.mo10021a(i);
                }

                /* renamed from: a */
                public void mo10010a(JSONObject jSONObject, int i) {
                    C1160w.this.mo10024b(jSONObject);
                }
            });
            return;
        }
        mo10773d("Pending reward not found");
        mo10025c();
    }
}
