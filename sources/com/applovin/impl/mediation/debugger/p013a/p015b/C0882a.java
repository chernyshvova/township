package com.applovin.impl.mediation.debugger.p013a.p015b;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.b.a */
public class C0882a {

    /* renamed from: a */
    public final String f837a;

    /* renamed from: b */
    public final String f838b;

    /* renamed from: c */
    public final boolean f839c;

    public C0882a(JSONObject jSONObject, C1188m mVar) {
        this.f837a = JsonUtils.getString(jSONObject, "name", "");
        this.f838b = JsonUtils.getString(jSONObject, "description", "");
        List list = JsonUtils.getList(jSONObject, "existence_classes", (List) null);
        this.f839c = list != null ? Utils.checkClassesExistence(list) : Utils.checkClassExistence(JsonUtils.getString(jSONObject, "existence_class", ""));
    }

    /* renamed from: a */
    public static boolean m1004a(String str, String str2, String str3) {
        if (str == null) {
            return true;
        }
        if (str2 == null || Utils.compare(str2, str) != 1) {
            return str3 == null || Utils.compare(str3, str) != -1;
        }
        return false;
    }

    /* renamed from: a */
    public String mo10063a() {
        return this.f837a;
    }

    /* renamed from: b */
    public String mo10064b() {
        return this.f838b;
    }

    /* renamed from: c */
    public boolean mo10065c() {
        return this.f839c;
    }
}
