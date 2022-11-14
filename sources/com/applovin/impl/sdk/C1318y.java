package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.y */
public class C1318y {

    /* renamed from: a */
    public final C1188m f2582a;

    /* renamed from: b */
    public final JSONObject f2583b;

    /* renamed from: c */
    public final Object f2584c = new Object();

    public C1318y(C1188m mVar) {
        this.f2582a = mVar;
        this.f2583b = JsonUtils.jsonObjectFromJsonString((String) mVar.mo10978b(C1087d.f1838u, JsonUtils.EMPTY_JSON), new JSONObject());
    }

    /* renamed from: a */
    public Integer mo11385a(String str) {
        Integer valueOf;
        synchronized (this.f2584c) {
            if (this.f2583b.has(str)) {
                JsonUtils.putInt(this.f2583b, str, JsonUtils.getInt(this.f2583b, str, 0) + 1);
            } else {
                JsonUtils.putInt(this.f2583b, str, 1);
            }
            this.f2582a.mo10953a(C1087d.f1838u, this.f2583b.toString());
            valueOf = Integer.valueOf(JsonUtils.getInt(this.f2583b, str, 0));
        }
        return valueOf;
    }
}
