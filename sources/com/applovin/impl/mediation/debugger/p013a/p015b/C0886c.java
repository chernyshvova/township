package com.applovin.impl.mediation.debugger.p013a.p015b;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.C1259d;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.b.c */
public class C0886c {

    /* renamed from: a */
    public final boolean f879a;

    /* renamed from: b */
    public final boolean f880b;

    /* renamed from: c */
    public final boolean f881c;

    /* renamed from: d */
    public final String f882d;

    public C0886c(JSONObject jSONObject, C1188m mVar) {
        this.f879a = C1259d.m2494a(mVar.mo10932L()).mo11273a();
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "cleartext_traffic", (JSONObject) null);
        boolean z = false;
        if (jSONObject2 != null) {
            this.f880b = true;
            this.f882d = JsonUtils.getString(jSONObject2, "description", "");
            if (C1264h.m2519a()) {
                this.f881c = true;
                return;
            }
            List list = JsonUtils.getList(jSONObject2, "domains", new ArrayList());
            if (list.size() > 0) {
                Iterator it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!C1264h.m2522a((String) it.next())) {
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
            }
            this.f881c = z;
            return;
        }
        this.f880b = false;
        this.f882d = "";
        this.f881c = C1264h.m2519a();
    }

    /* renamed from: a */
    public boolean mo10095a() {
        return this.f880b;
    }

    /* renamed from: b */
    public boolean mo10096b() {
        boolean z = this.f881c;
        return z && (this.f879a || z);
    }

    /* renamed from: c */
    public String mo10097c() {
        return this.f879a ? this.f882d : "You must include an entry in your AndroidManifest.xml to point to your network_security_config.xml.\n\nFor more information, visit: https://developer.android.com/training/articles/security-config";
    }
}
