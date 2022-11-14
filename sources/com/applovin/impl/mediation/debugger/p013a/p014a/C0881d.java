package com.applovin.impl.mediation.debugger.p013a.p014a;

import androidx.annotation.Nullable;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.a.d */
public class C0881d {

    /* renamed from: a */
    public final String f835a;
    @Nullable

    /* renamed from: b */
    public final String f836b;

    public C0881d(JSONObject jSONObject, C1188m mVar) {
        this.f835a = JsonUtils.getString(jSONObject, "id", "");
        this.f836b = JsonUtils.getString(jSONObject, "price", (String) null);
    }

    /* renamed from: a */
    public String mo10061a() {
        return this.f835a;
    }

    @Nullable
    /* renamed from: b */
    public String mo10062b() {
        return this.f836b;
    }
}
