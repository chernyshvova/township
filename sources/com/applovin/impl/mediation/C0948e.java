package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.p010a.C0806f;
import com.applovin.impl.mediation.p011b.C0841a;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.facebook.applinks.FacebookAppLinkResolver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.e */
public class C0948e {

    /* renamed from: a */
    public final C1188m f1111a;

    /* renamed from: b */
    public final C1314v f1112b;

    /* renamed from: c */
    public final AtomicBoolean f1113c = new AtomicBoolean();

    /* renamed from: d */
    public final JSONArray f1114d = new JSONArray();

    /* renamed from: e */
    public final LinkedHashSet<String> f1115e = new LinkedHashSet<>();

    /* renamed from: f */
    public final Object f1116f = new Object();

    /* renamed from: g */
    public List<C0806f> f1117g;

    /* renamed from: h */
    public boolean f1118h;

    public C0948e(C1188m mVar) {
        this.f1111a = mVar;
        this.f1112b = mVar.mo10922B();
    }

    /* renamed from: a */
    private List<C0806f> m1255a(JSONArray jSONArray, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new C0806f(Collections.EMPTY_MAP, JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), jSONObject, this.f1111a));
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo10226a(Activity activity) {
        boolean z = false;
        if (this.f1113c.compareAndSet(false, true)) {
            if (activity == null) {
                z = true;
            }
            this.f1118h = z;
            String str = (String) this.f1111a.mo10947a(C1087d.f1843z);
            if (StringUtils.isValidString(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    List<C0806f> a = m1255a(JsonUtils.getJSONArray(jSONObject, this.f1111a.mo10930J().mo10221a() ? "test_mode_auto_init_adapters" : "auto_init_adapters", new JSONArray()), jSONObject);
                    this.f1117g = a;
                    this.f1111a.mo10938S().mo10828a((C1109a) new C0841a(a, activity, this.f1111a));
                } catch (JSONException e) {
                    this.f1112b.mo11373b("MediationAdapterInitializationManager", "Failed to parse auto-init adapters JSON", e);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo10227a(C0806f fVar, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        boolean z;
        if (initializationStatus != null && initializationStatus != MaxAdapter.InitializationStatus.INITIALIZING) {
            synchronized (this.f1116f) {
                z = !mo10231a(fVar);
                if (z) {
                    this.f1115e.add(fVar.mo9897O());
                    JSONObject jSONObject = new JSONObject();
                    JsonUtils.putString(jSONObject, FacebookAppLinkResolver.APP_LINK_TARGET_CLASS_KEY, fVar.mo9897O());
                    JsonUtils.putString(jSONObject, "init_status", String.valueOf(initializationStatus.getCode()));
                    JsonUtils.putString(jSONObject, "error_message", JSONObject.quote(str));
                    this.f1114d.put(jSONObject);
                }
            }
            if (z) {
                Bundle outline5 = GeneratedOutlineSupport.outline5("type", "DID_INITIALIZE");
                outline5.putString("network_name", fVar.mo9898P());
                outline5.putInt("initialization_status", initializationStatus.getCode());
                if (StringUtils.isValidString(str)) {
                    outline5.putString("error_message", str);
                }
                this.f1111a.mo10969ag().mo10893a(outline5, "max_adapter_events");
                this.f1111a.mo10952a(fVar);
                this.f1111a.mo10925E().processAdapterInitializationPostback(fVar, j, initializationStatus, str);
                this.f1111a.mo10969ag().mo10896a(initializationStatus, fVar.mo9897O());
            }
        }
    }

    /* renamed from: a */
    public void mo10228a(C0806f fVar, Activity activity) {
        mo10229a(fVar, activity, (Runnable) null);
    }

    /* renamed from: a */
    public void mo10229a(C0806f fVar, Activity activity, @Nullable Runnable runnable) {
        List<C0806f> list;
        if (this.f1111a.mo10930J().mo10221a() && (list = this.f1117g) != null) {
            Iterator<C0806f> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    fVar = null;
                    break;
                }
                C0806f next = it.next();
                if (next.mo9897O().equals(fVar.mo9897O())) {
                    fVar = next;
                    break;
                }
            }
        }
        if (fVar != null) {
            Bundle outline5 = GeneratedOutlineSupport.outline5("type", "WILL_INITIALIZE");
            outline5.putString("network_name", fVar.mo9898P());
            this.f1111a.mo10969ag().mo10893a(outline5, "max_adapter_events");
            C0951g a = this.f1111a.mo10923C().mo10235a(fVar);
            if (a != null) {
                C1314v vVar = this.f1112b;
                vVar.mo11374c("MediationAdapterInitializationManager", "Initializing adapter " + fVar);
                a.mo10247a((MaxAdapterInitializationParameters) MaxAdapterParametersImpl.m622a(fVar), activity, runnable);
            } else if (runnable != null) {
                runnable.run();
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: a */
    public boolean mo10230a() {
        return this.f1113c.get();
    }

    /* renamed from: a */
    public boolean mo10231a(C0806f fVar) {
        boolean contains;
        synchronized (this.f1116f) {
            contains = this.f1115e.contains(fVar.mo9897O());
        }
        return contains;
    }

    /* renamed from: b */
    public boolean mo10232b() {
        return this.f1118h;
    }

    /* renamed from: c */
    public LinkedHashSet<String> mo10233c() {
        LinkedHashSet<String> linkedHashSet;
        synchronized (this.f1116f) {
            linkedHashSet = this.f1115e;
        }
        return linkedHashSet;
    }

    /* renamed from: d */
    public JSONArray mo10234d() {
        JSONArray jSONArray;
        synchronized (this.f1116f) {
            jSONArray = this.f1114d;
        }
        return jSONArray;
    }
}
