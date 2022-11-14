package com.applovin.impl.mediation.debugger.p013a.p014a;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.debugger.p013a.p015b.C0883b;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.facebook.GraphRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.a.a */
public class C0878a implements Comparable<C0878a> {

    /* renamed from: a */
    public final String f821a;

    /* renamed from: b */
    public final String f822b;

    /* renamed from: c */
    public final MaxAdFormat f823c;

    /* renamed from: d */
    public final C0880c f824d;

    /* renamed from: e */
    public final List<C0880c> f825e;

    public C0878a(JSONObject jSONObject, Map<String, C0883b> map, C1188m mVar) {
        this.f821a = JsonUtils.getString(jSONObject, "name", "");
        this.f822b = JsonUtils.getString(jSONObject, "display_name", "");
        this.f823c = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, GraphRequest.FORMAT_PARAM, (String) null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "waterfalls", new JSONArray());
        this.f825e = new ArrayList(jSONArray.length());
        C0880c cVar = null;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                C0880c cVar2 = new C0880c(jSONObject2, map, mVar);
                this.f825e.add(cVar2);
                if (cVar == null && cVar2.mo10060c()) {
                    cVar = cVar2;
                }
            }
        }
        this.f824d = cVar;
    }

    @Nullable
    /* renamed from: g */
    private C0880c m984g() {
        if (!this.f825e.isEmpty()) {
            return this.f825e.get(0);
        }
        return null;
    }

    /* renamed from: a */
    public int compareTo(C0878a aVar) {
        return this.f822b.compareToIgnoreCase(aVar.f822b);
    }

    /* renamed from: a */
    public String mo10045a() {
        return this.f821a;
    }

    /* renamed from: b */
    public String mo10046b() {
        return this.f822b;
    }

    /* renamed from: c */
    public String mo10047c() {
        MaxAdFormat maxAdFormat = this.f823c;
        return maxAdFormat != null ? maxAdFormat.getDisplayName() : "Unknown";
    }

    /* renamed from: d */
    public MaxAdFormat mo10049d() {
        return this.f823c;
    }

    @Nullable
    /* renamed from: e */
    public C0880c mo10050e() {
        C0880c cVar = this.f824d;
        return cVar != null ? cVar : m984g();
    }

    /* renamed from: f */
    public String mo10051f() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("\n---------- ");
        outline24.append(this.f822b);
        outline24.append(" ----------");
        outline24.append("\nIdentifier - ");
        outline24.append(this.f821a);
        outline24.append("\nFormat     - ");
        outline24.append(mo10047c());
        return outline24.toString();
    }
}
