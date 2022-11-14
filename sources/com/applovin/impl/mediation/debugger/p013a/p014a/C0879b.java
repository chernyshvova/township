package com.applovin.impl.mediation.debugger.p013a.p014a;

import androidx.annotation.Nullable;
import com.applovin.impl.mediation.debugger.p013a.p015b.C0883b;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.a.b */
public class C0879b {

    /* renamed from: a */
    public final C0883b f826a;

    /* renamed from: b */
    public final String f827b;

    /* renamed from: c */
    public final String f828c;

    /* renamed from: d */
    public final C0881d f829d;
    @Nullable

    /* renamed from: e */
    public final List<C0881d> f830e;

    public C0879b(JSONObject jSONObject, C0883b bVar, C1188m mVar) {
        this.f826a = bVar;
        this.f827b = JsonUtils.getString(jSONObject, "name", "");
        this.f828c = JsonUtils.getString(jSONObject, "display_name", "");
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "bidder_placement", (JSONObject) null);
        if (jSONObject2 != null) {
            this.f829d = new C0881d(jSONObject2, mVar);
        } else {
            this.f829d = null;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "placements", new JSONArray());
        this.f830e = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject3 != null) {
                this.f830e.add(new C0881d(jSONObject3, mVar));
            }
        }
    }

    /* renamed from: a */
    public C0883b mo10052a() {
        return this.f826a;
    }

    /* renamed from: b */
    public String mo10053b() {
        return this.f827b;
    }

    /* renamed from: c */
    public String mo10054c() {
        return this.f828c;
    }

    @Nullable
    /* renamed from: d */
    public C0881d mo10055d() {
        return this.f829d;
    }

    /* renamed from: e */
    public boolean mo10056e() {
        return this.f829d != null;
    }

    /* renamed from: f */
    public List<C0881d> mo10057f() {
        return this.f830e;
    }
}
