package com.applovin.impl.mediation.p010a;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.applinks.FacebookAppLinkResolver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.f */
public class C0806f {

    /* renamed from: a */
    public final JSONObject f604a;

    /* renamed from: b */
    public final C1188m f605b;

    /* renamed from: c */
    public final JSONObject f606c;

    /* renamed from: d */
    public final Map<String, Object> f607d;

    /* renamed from: e */
    public final Object f608e = new Object();

    /* renamed from: f */
    public final Object f609f = new Object();

    /* renamed from: g */
    public String f610g;
    @Nullable

    /* renamed from: h */
    public String f611h;

    public C0806f(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, C1188m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (jSONObject2 == null) {
            throw new IllegalArgumentException("No full response specified");
        } else if (jSONObject != null) {
            this.f605b = mVar;
            this.f604a = jSONObject2;
            this.f606c = jSONObject;
            this.f607d = map;
        } else {
            throw new IllegalArgumentException("No ad object specified");
        }
    }

    /* renamed from: a */
    private int mo9825a() {
        return mo9919b("mute_state", mo9910a("mute_state", ((Integer) this.f605b.mo10946a(C1084a.f1504O)).intValue()));
    }

    /* renamed from: M */
    public JSONObject mo9895M() {
        JSONObject jSONObject;
        synchronized (this.f609f) {
            jSONObject = this.f604a;
        }
        return jSONObject;
    }

    /* renamed from: N */
    public JSONObject mo9896N() {
        JSONObject jSONObject;
        synchronized (this.f608e) {
            jSONObject = this.f606c;
        }
        return jSONObject;
    }

    /* renamed from: O */
    public String mo9897O() {
        return mo9922b(FacebookAppLinkResolver.APP_LINK_TARGET_CLASS_KEY, (String) null);
    }

    /* renamed from: P */
    public String mo9898P() {
        return mo9922b("name", (String) null);
    }

    /* renamed from: Q */
    public String mo9899Q() {
        return mo9898P().split("_")[0];
    }

    /* renamed from: R */
    public boolean mo9900R() {
        return mo9921b("is_testing", Boolean.FALSE).booleanValue();
    }

    /* renamed from: S */
    public Boolean mo9901S() {
        return mo9924b("huc") ? mo9921b("huc", Boolean.FALSE) : mo9912a("huc", (Boolean) null);
    }

    /* renamed from: T */
    public Boolean mo9902T() {
        return mo9924b("aru") ? mo9921b("aru", Boolean.FALSE) : mo9912a("aru", (Boolean) null);
    }

    /* renamed from: U */
    public Boolean mo9903U() {
        return mo9924b("dns") ? mo9921b("dns", Boolean.FALSE) : mo9912a("dns", (Boolean) null);
    }

    /* renamed from: V */
    public boolean mo9904V() {
        return mo9921b("run_on_ui_thread", Boolean.TRUE).booleanValue();
    }

    /* renamed from: W */
    public Map<String, Object> mo9905W() {
        return this.f607d;
    }

    /* renamed from: X */
    public Bundle mo9906X() {
        Bundle bundle = mo9925c("server_parameters") instanceof JSONObject ? JsonUtils.toBundle(mo9916a("server_parameters", (JSONObject) null)) : new Bundle();
        int a = mo9825a();
        if (a != -1) {
            bundle.putBoolean("is_muted", a == 2 ? this.f605b.mo10999p().isMuted() : a == 0);
        }
        return bundle;
    }

    /* renamed from: Y */
    public long mo9907Y() {
        return mo9920b("adapter_timeout_ms", ((Long) this.f605b.mo10946a(C1084a.f1529l)).longValue());
    }

    /* renamed from: Z */
    public long mo9908Z() {
        return mo9920b("init_completion_delay_ms", -1);
    }

    /* renamed from: a */
    public float mo9909a(String str, float f) {
        float f2;
        synchronized (this.f608e) {
            f2 = JsonUtils.getFloat(this.f606c, str, f);
        }
        return f2;
    }

    /* renamed from: a */
    public int mo9910a(String str, int i) {
        int i2;
        synchronized (this.f609f) {
            i2 = JsonUtils.getInt(this.f604a, str, i);
        }
        return i2;
    }

    /* renamed from: a */
    public long mo9911a(String str, long j) {
        long j2;
        synchronized (this.f609f) {
            j2 = JsonUtils.getLong(this.f604a, str, j);
        }
        return j2;
    }

    /* renamed from: a */
    public Boolean mo9912a(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.f609f) {
            bool2 = JsonUtils.getBoolean(this.f604a, str, bool);
        }
        return bool2;
    }

    @Nullable
    /* renamed from: a */
    public Float mo9913a(String str, @Nullable Float f) {
        Float f2;
        synchronized (this.f608e) {
            f2 = JsonUtils.getFloat(this.f606c, str, f);
        }
        return f2;
    }

    /* renamed from: a */
    public String mo9914a(String str, String str2) {
        String string;
        synchronized (this.f609f) {
            string = JsonUtils.getString(this.f604a, str, str2);
        }
        return string;
    }

    /* renamed from: a */
    public JSONArray mo9915a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.f609f) {
            jSONArray2 = JsonUtils.getJSONArray(this.f604a, str, jSONArray);
        }
        return jSONArray2;
    }

    /* renamed from: a */
    public JSONObject mo9916a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (this.f608e) {
            jSONObject2 = JsonUtils.getJSONObject(this.f606c, str, jSONObject);
        }
        return jSONObject2;
    }

    /* renamed from: aa */
    public long mo9917aa() {
        return mo9920b("auto_init_delay_ms", 0);
    }

    @Nullable
    /* renamed from: ab */
    public String mo9918ab() {
        return this.f611h;
    }

    /* renamed from: b */
    public int mo9919b(String str, int i) {
        int i2;
        synchronized (this.f608e) {
            i2 = JsonUtils.getInt(this.f606c, str, i);
        }
        return i2;
    }

    /* renamed from: b */
    public long mo9920b(String str, long j) {
        long j2;
        synchronized (this.f608e) {
            j2 = JsonUtils.getLong(this.f606c, str, j);
        }
        return j2;
    }

    /* renamed from: b */
    public Boolean mo9921b(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.f608e) {
            bool2 = JsonUtils.getBoolean(this.f606c, str, bool);
        }
        return bool2;
    }

    /* renamed from: b */
    public String mo9922b(String str, String str2) {
        String string;
        synchronized (this.f608e) {
            string = JsonUtils.getString(this.f606c, str, str2);
        }
        return string;
    }

    /* renamed from: b */
    public JSONArray mo9923b(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.f608e) {
            jSONArray2 = JsonUtils.getJSONArray(this.f606c, str, jSONArray);
        }
        return jSONArray2;
    }

    /* renamed from: b */
    public boolean mo9924b(String str) {
        boolean has;
        synchronized (this.f608e) {
            has = this.f606c.has(str);
        }
        return has;
    }

    /* renamed from: c */
    public Object mo9925c(String str) {
        Object opt;
        synchronized (this.f608e) {
            opt = this.f606c.opt(str);
        }
        return opt;
    }

    /* renamed from: c */
    public void mo9926c(String str, long j) {
        synchronized (this.f608e) {
            JsonUtils.putLong(this.f606c, str, j);
        }
    }

    /* renamed from: c */
    public void mo9927c(String str, String str2) {
        synchronized (this.f608e) {
            JsonUtils.putString(this.f606c, str, str2);
        }
    }

    /* renamed from: d */
    public void mo9928d(String str) {
        this.f610g = str;
    }

    /* renamed from: e */
    public void mo9929e(@Nullable String str) {
        this.f611h = str;
    }

    /* renamed from: f */
    public List<String> mo9930f(String str) {
        if (str != null) {
            List optList = JsonUtils.optList(mo9915a(str, new JSONArray()), Collections.EMPTY_LIST);
            List optList2 = JsonUtils.optList(mo9923b(str, new JSONArray()), Collections.EMPTY_LIST);
            ArrayList arrayList = new ArrayList(optList2.size() + optList.size());
            arrayList.addAll(optList);
            arrayList.addAll(optList2);
            return arrayList;
        }
        throw new IllegalArgumentException("No key specified");
    }

    /* renamed from: g */
    public String mo9931g(String str) {
        String b = mo9922b(str, "");
        return StringUtils.isValidString(b) ? b : mo9914a(str, "");
    }

    public String getAdUnitId() {
        return mo9914a("ad_unit_id", "");
    }

    public String getPlacement() {
        return this.f610g;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediationAdapterSpec{adapterClass='");
        outline24.append(mo9897O());
        outline24.append("', adapterName='");
        outline24.append(mo9898P());
        outline24.append("', isTesting=");
        outline24.append(mo9900R());
        outline24.append('}');
        return outline24.toString();
    }
}
