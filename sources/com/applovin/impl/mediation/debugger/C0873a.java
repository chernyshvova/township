package com.applovin.impl.mediation.debugger;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.debugger.p013a.p014a.C0878a;
import com.applovin.impl.mediation.debugger.p013a.p015b.C0883b;
import com.applovin.impl.mediation.debugger.p016b.C0888a;
import com.applovin.impl.mediation.debugger.p017ui.p019b.C0918b;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.network.C1213b;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.utils.C1256a;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxDebuggerActivity;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.drive.DriveFile;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a */
public class C0873a implements C1213b.C1216c<JSONObject> {

    /* renamed from: a */
    public static WeakReference<MaxDebuggerActivity> f808a;

    /* renamed from: b */
    public static final AtomicBoolean f809b = new AtomicBoolean();

    /* renamed from: c */
    public final C1188m f810c;

    /* renamed from: d */
    public final C1314v f811d;

    /* renamed from: e */
    public final C0918b f812e;

    /* renamed from: f */
    public final Map<String, C0883b> f813f = new HashMap();

    /* renamed from: g */
    public final AtomicBoolean f814g = new AtomicBoolean();

    /* renamed from: h */
    public boolean f815h;

    /* renamed from: i */
    public final Context f816i;

    public C0873a(C1188m mVar) {
        this.f810c = mVar;
        this.f811d = mVar.mo10922B();
        this.f816i = mVar.mo10932L();
        this.f812e = new C0918b(this.f816i);
    }

    /* renamed from: a */
    private List<C0883b> m967a(JSONObject jSONObject, C1188m mVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "networks", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                C0883b bVar = new C0883b(jSONObject2, mVar);
                arrayList.add(bVar);
                this.f813f.put(bVar.mo10080m(), bVar);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private List<C0878a> m968a(JSONObject jSONObject, List<C0883b> list, C1188m mVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ad_units", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new C0878a(jSONObject2, this.f813f, mVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private void m969a(List<C0883b> list) {
        boolean z;
        Iterator<C0883b> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            C0883b next = it.next();
            if (next.mo10072e() && next.mo10067a() == C0883b.C0884a.INVALID_INTEGRATION) {
                z = true;
                break;
            }
        }
        if (z) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    new AlertDialog.Builder(C0873a.this.f810c.mo10967ae().mo10434a()).setTitle("Review Integration Errors").setMessage("Looks like MAX Mediation Debugger flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this prompt will only be shown in your development builds. Live apps will not be affected.").setPositiveButton("Show Mediation Debugger", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            C0873a.this.mo10038c();
                        }
                    }).setNegativeButton("DISMISS", (DialogInterface.OnClickListener) null).create().show();
                }
            }, TimeUnit.SECONDS.toMillis(2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m975f() {
        WeakReference<MaxDebuggerActivity> weakReference = f808a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* renamed from: a */
    public void mo10033a() {
        if (this.f814g.compareAndSet(false, true)) {
            this.f810c.mo10938S().mo10829a((C1109a) new C0888a(this, this.f810c), C1140o.C1142a.MEDIATION_MAIN);
        }
    }

    /* renamed from: a */
    public void mo10008a(int i, String str, JSONObject jSONObject) {
        C1314v vVar = this.f811d;
        vVar.mo11376e("MediationDebuggerService", "Unable to fetch mediation debugger info: server returned " + i);
        C1314v.m2663i(AppLovinSdk.TAG, "Unable to show mediation debugger.");
        this.f812e.mo10148a((List<C0883b>) null, (List<C0878a>) null, (String) null, (String) null, (String) null, this.f810c);
        this.f814g.set(false);
    }

    /* renamed from: a */
    public void mo10010a(JSONObject jSONObject, int i) {
        List<C0883b> a = m967a(jSONObject, this.f810c);
        List<C0878a> a2 = m968a(jSONObject, a, this.f810c);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "alert", (JSONObject) null);
        List<C0883b> list = a;
        this.f812e.mo10148a(list, a2, JsonUtils.getString(jSONObject2, "title", (String) null), JsonUtils.getString(jSONObject2, "message", (String) null), JsonUtils.getString(jSONObject, "account_id", (String) null), this.f810c);
        if (mo10037b()) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C0873a.this.mo10038c();
                }
            }, TimeUnit.SECONDS.toMillis(2));
        } else {
            m969a(a);
        }
    }

    /* renamed from: a */
    public void mo10036a(boolean z) {
        this.f815h = z;
    }

    /* renamed from: b */
    public boolean mo10037b() {
        return this.f815h;
    }

    /* renamed from: c */
    public void mo10038c() {
        mo10033a();
        if (m975f() || !f809b.compareAndSet(false, true)) {
            C1314v.m2663i(AppLovinSdk.TAG, "Mediation debugger is already showing");
            return;
        }
        this.f810c.mo10967ae().mo10435a(new C1256a() {
            public void onActivityDestroyed(Activity activity) {
                if (activity instanceof MaxDebuggerActivity) {
                    C1314v.m2660f(AppLovinSdk.TAG, "Mediation debugger destroyed");
                    C0873a.this.f810c.mo10967ae().mo10437b(this);
                    WeakReference unused = C0873a.f808a = null;
                }
            }

            public void onActivityStarted(Activity activity) {
                if (activity instanceof MaxDebuggerActivity) {
                    C1314v.m2660f(AppLovinSdk.TAG, "Started mediation debugger");
                    if (!C0873a.this.m975f() || C0873a.f808a.get() != activity) {
                        MaxDebuggerActivity maxDebuggerActivity = (MaxDebuggerActivity) activity;
                        WeakReference unused = C0873a.f808a = new WeakReference(maxDebuggerActivity);
                        maxDebuggerActivity.setListAdapter(C0873a.this.f812e, C0873a.this.f810c.mo10967ae());
                    }
                    C0873a.f809b.set(false);
                }
            }
        });
        Intent intent = new Intent(this.f816i, MaxDebuggerActivity.class);
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        C1314v.m2660f(AppLovinSdk.TAG, "Starting mediation debugger...");
        this.f816i.startActivity(intent);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediationDebuggerService{, listAdapter=");
        outline24.append(this.f812e);
        outline24.append("}");
        return outline24.toString();
    }
}
