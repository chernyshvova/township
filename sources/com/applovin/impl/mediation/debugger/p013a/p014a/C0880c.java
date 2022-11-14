package com.applovin.impl.mediation.debugger.p013a.p014a;

import com.applovin.impl.mediation.debugger.p013a.p015b.C0883b;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.a.c */
public class C0880c {

    /* renamed from: a */
    public final String f831a;

    /* renamed from: b */
    public final boolean f832b;

    /* renamed from: c */
    public final List<C0879b> f833c;

    /* renamed from: d */
    public final List<C0879b> f834d;

    public C0880c(JSONObject jSONObject, Map<String, C0883b> map, C1188m mVar) {
        this.f831a = JsonUtils.getString(jSONObject, "name", "");
        this.f832b = JsonUtils.getBoolean(jSONObject, "default", Boolean.FALSE).booleanValue();
        this.f833c = m998a("bidders", jSONObject, map, mVar);
        this.f834d = m998a("waterfall", jSONObject, map, mVar);
    }

    /* renamed from: a */
    private List<C0879b> m998a(String str, JSONObject jSONObject, Map<String, C0883b> map, C1188m mVar) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, str, new JSONArray());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                String string = JsonUtils.getString(jSONObject2, "adapter_class", "");
                C0883b bVar = map.get(string);
                if (bVar == null) {
                    C1314v B = mVar.mo10922B();
                    B.mo11376e("AdUnitWaterfall", "Failed to retrieve network info for adapter class: " + string);
                } else {
                    arrayList.add(new C0879b(jSONObject2, bVar, mVar));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<C0879b> mo10058a() {
        return this.f833c;
    }

    /* renamed from: b */
    public List<C0879b> mo10059b() {
        return this.f834d;
    }

    /* renamed from: c */
    public boolean mo10060c() {
        return this.f832b;
    }
}
