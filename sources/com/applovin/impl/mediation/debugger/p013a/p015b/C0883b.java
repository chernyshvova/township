package com.applovin.impl.mediation.debugger.p013a.p015b;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.p012c.C0867c;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.b.b */
public class C0883b implements AppLovinCommunicatorSubscriber, Comparable<C0883b> {

    /* renamed from: a */
    public final C1188m f840a;

    /* renamed from: b */
    public final C0884a f841b;

    /* renamed from: c */
    public int f842c;

    /* renamed from: d */
    public final boolean f843d;

    /* renamed from: e */
    public final boolean f844e;

    /* renamed from: f */
    public final boolean f845f;

    /* renamed from: g */
    public final boolean f846g;

    /* renamed from: h */
    public final boolean f847h;

    /* renamed from: i */
    public final boolean f848i;

    /* renamed from: j */
    public final boolean f849j;

    /* renamed from: k */
    public final boolean f850k;

    /* renamed from: l */
    public final String f851l;

    /* renamed from: m */
    public final String f852m;

    /* renamed from: n */
    public final String f853n;

    /* renamed from: o */
    public String f854o;

    /* renamed from: p */
    public final String f855p;

    /* renamed from: q */
    public final String f856q;

    /* renamed from: r */
    public final String f857r;

    /* renamed from: s */
    public final int f858s;

    /* renamed from: t */
    public final List<MaxAdFormat> f859t;

    /* renamed from: u */
    public final List<C0887d> f860u;

    /* renamed from: v */
    public final List<C0882a> f861v;

    /* renamed from: w */
    public final List<String> f862w;

    /* renamed from: x */
    public final C0886c f863x;

    /* renamed from: com.applovin.impl.mediation.debugger.a.b.b$a */
    public enum C0884a {
        MISSING("MISSING"),
        INCOMPLETE_INTEGRATION("INCOMPLETE INTEGRATION"),
        INVALID_INTEGRATION("INVALID INTEGRATION"),
        COMPLETE("COMPLETE");
        

        /* renamed from: e */
        public final String f869e;

        /* access modifiers changed from: public */
        C0884a(String str) {
            this.f869e = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String m1037a() {
            return this.f869e;
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.a.b.b$b */
    public enum C0885b {
        NOT_SUPPORTED("Not Supported", SupportMenu.CATEGORY_MASK, "This network does not support test mode."),
        INVALID_INTEGRATION("Invalid Integration", SupportMenu.CATEGORY_MASK, "Please address all the integration issue(s) marked in red above."),
        NOT_INITIALIZED("Not Initialized", SupportMenu.CATEGORY_MASK, "Please configure this network in your MAX dashboard."),
        DISABLED("Enable", -16776961, "Please re-launch the app to enable test ads."),
        READY("", -16776961, "");
        

        /* renamed from: f */
        public final String f876f;

        /* renamed from: g */
        public final int f877g;

        /* renamed from: h */
        public final String f878h;

        /* access modifiers changed from: public */
        C0885b(String str, int i, String str2) {
            this.f876f = str;
            this.f877g = i;
            this.f878h = str2;
        }

        /* renamed from: a */
        public String mo10092a() {
            return this.f876f;
        }

        /* renamed from: b */
        public int mo10093b() {
            return this.f877g;
        }

        /* renamed from: c */
        public String mo10094c() {
            return this.f878h;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x017f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0883b(org.json.JSONObject r19, com.applovin.impl.sdk.C1188m r20) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.String r4 = "MediatedNetwork"
            r18.<init>()
            r1.f840a = r3
            java.lang.String r0 = "name"
            java.lang.String r5 = ""
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r0, r5)
            r1.f851l = r0
            java.lang.String r0 = "display_name"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r0, r5)
            r1.f852m = r0
            java.lang.String r6 = "adapter_class"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r6, r5)
            r1.f853n = r0
            java.lang.String r0 = "latest_adapter_version"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r0, r5)
            r1.f856q = r0
            java.util.List r0 = r18.m1009a((org.json.JSONObject) r19)
            r1.f862w = r0
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            java.lang.String r7 = "hide_if_missing"
            java.lang.Boolean r0 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r2, r7, r0)
            boolean r0 = r0.booleanValue()
            r1.f849j = r0
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r7 = "configuration"
            org.json.JSONObject r7 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r2, (java.lang.String) r7, (org.json.JSONObject) r0)
            java.util.List r0 = r1.m1010a(r7, r3)
            r1.f860u = r0
            com.applovin.impl.mediation.debugger.a.b.c r0 = new com.applovin.impl.mediation.debugger.a.b.c
            r0.<init>(r7, r3)
            r1.f863x = r0
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r8 = "test_mode"
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r2, (java.lang.String) r8, (org.json.JSONObject) r0)
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            java.lang.String r9 = "supported"
            java.lang.Boolean r8 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r0, r9, r8)
            boolean r8 = r8.booleanValue()
            r1.f847h = r8
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            java.lang.String r9 = "test_mode_requires_init"
            java.lang.Boolean r8 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r2, r9, r8)
            boolean r8 = r8.booleanValue()
            r1.f848i = r8
            java.lang.String r8 = "message"
            r9 = 0
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r0, r8, r9)
            r1.f857r = r0
            java.lang.String r0 = "existence_classes"
            java.util.List r0 = com.applovin.impl.sdk.utils.JsonUtils.getList(r2, r0, r9)
            if (r0 == 0) goto L_0x0098
            boolean r0 = com.applovin.impl.sdk.utils.Utils.checkClassesExistence(r0)
            goto L_0x00a2
        L_0x0098:
            java.lang.String r0 = "existence_class"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r0, r5)
            boolean r0 = com.applovin.impl.sdk.utils.Utils.checkClassExistence(r0)
        L_0x00a2:
            r1.f843d = r0
            java.util.List r8 = java.util.Collections.emptyList()
            java.lang.String r0 = r1.f853n
            com.applovin.mediation.adapter.MaxAdapter r0 = com.applovin.impl.mediation.p012c.C0867c.m940b(r0, r3)
            r9 = 1
            r10 = 0
            if (r0 == 0) goto L_0x012c
            r1.f844e = r9
            java.lang.String r11 = r0.getAdapterVersion()     // Catch:{ all -> 0x00d6 }
            java.lang.String r12 = r0.getSdkVersion()     // Catch:{ all -> 0x00d3 }
            if (r12 == 0) goto L_0x00c3
            java.lang.String r12 = r0.getSdkVersion()     // Catch:{ all -> 0x00d3 }
            goto L_0x00c4
        L_0x00c3:
            r12 = r5
        L_0x00c4:
            java.util.List r8 = r1.m1008a((com.applovin.mediation.adapter.MaxAdapter) r0)     // Catch:{ all -> 0x00d1 }
            boolean r0 = r0.isBeta()     // Catch:{ all -> 0x00d1 }
            r13 = r12
            r12 = r11
            r11 = r8
            r8 = r0
            goto L_0x00f8
        L_0x00d1:
            r0 = move-exception
            goto L_0x00d9
        L_0x00d3:
            r0 = move-exception
            r12 = r5
            goto L_0x00d9
        L_0x00d6:
            r0 = move-exception
            r11 = r5
            r12 = r11
        L_0x00d9:
            java.lang.String r13 = "Failed to load adapter for network "
            java.lang.StringBuilder r13 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r13)
            java.lang.String r14 = r1.f851l
            r13.append(r14)
            java.lang.String r14 = ". Please check that you have a compatible network SDK integrated. Error: "
            r13.append(r14)
            r13.append(r0)
            java.lang.String r0 = r13.toString()
            com.applovin.impl.sdk.C1314v.m2663i(r4, r0)
            r0 = 0
            r13 = r12
            r12 = r11
            r11 = r8
            r8 = 0
        L_0x00f8:
            java.lang.String r0 = r1.f853n     // Catch:{ all -> 0x011e }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x011e }
            java.lang.String r14 = "loadNativeAd"
            r15 = 3
            java.lang.Class[] r15 = new java.lang.Class[r15]     // Catch:{ all -> 0x011e }
            java.lang.Class<com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters> r16 = com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters.class
            r15[r10] = r16     // Catch:{ all -> 0x011e }
            java.lang.Class<android.app.Activity> r16 = android.app.Activity.class
            r15[r9] = r16     // Catch:{ all -> 0x011e }
            r16 = 2
            java.lang.Class<com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener> r17 = com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener.class
            r15[r16] = r17     // Catch:{ all -> 0x011e }
            java.lang.reflect.Method r14 = r0.getMethod(r14, r15)     // Catch:{ all -> 0x011e }
            java.lang.Class r14 = r14.getDeclaringClass()     // Catch:{ all -> 0x011e }
            boolean r0 = r14.equals(r0)     // Catch:{ all -> 0x011e }
            goto L_0x0129
        L_0x011e:
            r0 = move-exception
            com.applovin.impl.sdk.v r14 = r20.mo10922B()
            java.lang.String r15 = "Failed to check if adapter overrides MaxNativeAdAdapter"
            r14.mo11373b(r4, r15, r0)
            r0 = 0
        L_0x0129:
            r4 = r8
            r8 = r11
            goto L_0x0132
        L_0x012c:
            r1.f844e = r10
            r0 = 0
            r4 = 0
            r12 = r5
            r13 = r12
        L_0x0132:
            r1.f855p = r12
            r1.f854o = r13
            r1.f859t = r8
            r1.f850k = r0
            java.util.List r0 = r1.m1011a(r7, r12, r3)
            r1.f861v = r0
            java.lang.String r0 = "alternative_network"
            r7 = 0
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r2, (java.lang.String) r0, (org.json.JSONObject) r7)
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r0, r6, r5)
            boolean r0 = com.applovin.impl.sdk.utils.Utils.checkClassExistence(r0)
            r1.f846g = r0
            com.applovin.impl.mediation.debugger.a.b.b$a r0 = r18.m1012x()
            r1.f841b = r0
            java.lang.String r0 = r1.f856q
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0162
            if (r4 != 0) goto L_0x0162
            goto L_0x0163
        L_0x0162:
            r9 = 0
        L_0x0163:
            r1.f845f = r9
            android.content.Context r0 = r20.mo10932L()
            java.lang.String r2 = r1.f851l
            java.lang.String r3 = "_"
            int r2 = r2.lastIndexOf(r3)
            r3 = -1
            if (r2 == r3) goto L_0x017f
            java.lang.String r3 = r1.f851l
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r2 = r3.substring(r10, r2)
            goto L_0x0185
        L_0x017f:
            java.lang.String r2 = r1.f851l
            java.lang.String r2 = r2.toLowerCase()
        L_0x0185:
            android.content.res.Resources r3 = r0.getResources()
            java.lang.String r4 = "applovin_ic_mediation_"
            java.lang.String r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline16(r4, r2)
            java.lang.String r4 = r0.getPackageName()
            java.lang.String r5 = "drawable"
            int r2 = r3.getIdentifier(r2, r5, r4)
            r1.f858s = r2
            com.applovin.mediation.adapter.MaxAdapter$InitializationStatus r2 = com.applovin.mediation.adapter.MaxAdapter.InitializationStatus.WAITING_FOR_INIT
            int r2 = r2.getCode()
            r1.f842c = r2
            com.applovin.communicator.AppLovinCommunicator r0 = com.applovin.communicator.AppLovinCommunicator.getInstance(r0)
            java.lang.String r2 = "adapter_initialization_status"
            r0.subscribe((com.applovin.communicator.AppLovinCommunicatorSubscriber) r1, (java.lang.String) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.debugger.p013a.p015b.C0883b.<init>(org.json.JSONObject, com.applovin.impl.sdk.m):void");
    }

    /* renamed from: a */
    private List<MaxAdFormat> m1008a(MaxAdapter maxAdapter) {
        ArrayList arrayList = new ArrayList(5);
        if (maxAdapter instanceof MaxInterstitialAdapter) {
            arrayList.add(MaxAdFormat.INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxRewardedAdapter) {
            arrayList.add(MaxAdFormat.REWARDED);
        }
        if (maxAdapter instanceof MaxRewardedInterstitialAdapter) {
            arrayList.add(MaxAdFormat.REWARDED_INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAdViewAdapter) {
            arrayList.add(MaxAdFormat.BANNER);
            arrayList.add(MaxAdFormat.LEADER);
            arrayList.add(MaxAdFormat.MREC);
        }
        if (maxAdapter instanceof MaxNativeAdAdapter) {
            arrayList.add(MaxAdFormat.NATIVE);
        }
        return arrayList;
    }

    @Nullable
    /* renamed from: a */
    private List<String> m1009a(JSONObject jSONObject) {
        return JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "supported_regions", (JSONArray) null), (List) null);
    }

    /* renamed from: a */
    private List<C0887d> m1010a(JSONObject jSONObject, C1188m mVar) {
        ArrayList arrayList = new ArrayList();
        if (this.f853n.equals("com.applovin.mediation.adapters.AppLovinMediationAdapter")) {
            C0887d dVar = new C0887d("com.google.android.gms.permission.AD_ID", "Please add\n<uses-permission android:name=\"com.google.android.gms.permission.AD_ID\" />\nto your AndroidManifest.xml", mVar.mo10932L());
            if (dVar.mo10100c()) {
                arrayList.add(dVar);
            }
        }
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "permissions", new JSONObject());
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                arrayList.add(new C0887d(next, jSONObject2.getString(next), mVar.mo10932L()));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<C0882a> m1011a(JSONObject jSONObject, String str, C1188m mVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "dependencies", new JSONArray());
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "dependencies_v2", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray2.length() + jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new C0882a(jSONObject2, mVar));
            }
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray2, i2, (JSONObject) null);
            if (jSONObject3 != null && C0882a.m1004a(str, JsonUtils.getString(jSONObject3, "min_adapter_version", (String) null), JsonUtils.getString(jSONObject3, "max_adapter_version", (String) null))) {
                arrayList.add(new C0882a(jSONObject3, mVar));
            }
        }
        return arrayList;
    }

    /* renamed from: x */
    private C0884a m1012x() {
        if (!this.f843d && !this.f844e) {
            return C0884a.MISSING;
        }
        for (C0887d c : this.f860u) {
            if (!c.mo10100c()) {
                return C0884a.INVALID_INTEGRATION;
            }
        }
        for (C0882a c2 : this.f861v) {
            if (!c2.mo10065c()) {
                return C0884a.INVALID_INTEGRATION;
            }
        }
        if (this.f863x.mo10095a() && !this.f863x.mo10096b()) {
            return C0884a.INVALID_INTEGRATION;
        }
        if (this.f843d) {
            if (this.f844e) {
                return C0884a.COMPLETE;
            }
            if (this.f846g) {
                return C0884a.MISSING;
            }
        }
        return C0884a.INCOMPLETE_INTEGRATION;
    }

    /* renamed from: a */
    public int compareTo(C0883b bVar) {
        return this.f852m.compareToIgnoreCase(bVar.f852m);
    }

    /* renamed from: a */
    public C0884a mo10067a() {
        return this.f841b;
    }

    /* renamed from: b */
    public int mo10068b() {
        return this.f842c;
    }

    /* renamed from: c */
    public C0885b mo10069c() {
        return !this.f847h ? C0885b.NOT_SUPPORTED : this.f841b == C0884a.INVALID_INTEGRATION ? C0885b.INVALID_INTEGRATION : !this.f840a.mo10930J().mo10221a() ? C0885b.DISABLED : (!this.f848i || !(this.f842c == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() || this.f842c == MaxAdapter.InitializationStatus.INITIALIZING.getCode())) ? C0885b.READY : C0885b.NOT_INITIALIZED;
    }

    /* renamed from: d */
    public boolean mo10071d() {
        return this.f843d;
    }

    /* renamed from: e */
    public boolean mo10072e() {
        return this.f844e;
    }

    /* renamed from: f */
    public boolean mo10073f() {
        return this.f845f;
    }

    /* renamed from: g */
    public boolean mo10074g() {
        return this.f841b == C0884a.MISSING && this.f849j;
    }

    public String getCommunicatorId() {
        return "MediatedNetwork";
    }

    /* renamed from: h */
    public String mo10075h() {
        return this.f851l;
    }

    /* renamed from: i */
    public String mo10076i() {
        return this.f852m;
    }

    /* renamed from: j */
    public String mo10077j() {
        return this.f854o;
    }

    /* renamed from: k */
    public String mo10078k() {
        return this.f855p;
    }

    /* renamed from: l */
    public String mo10079l() {
        return this.f856q;
    }

    /* renamed from: m */
    public String mo10080m() {
        return this.f853n;
    }

    @Nullable
    /* renamed from: n */
    public List<String> mo10081n() {
        return this.f862w;
    }

    /* renamed from: o */
    public int mo10082o() {
        return this.f858s;
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        String string = appLovinCommunicatorMessage.getMessageData().getString("adapter_class", "");
        if (this.f853n.equals(string)) {
            this.f842c = appLovinCommunicatorMessage.getMessageData().getInt("init_status", 0);
            MaxAdapter b = C0867c.m940b(string, this.f840a);
            if (b != null && !this.f854o.equals(b.getSdkVersion())) {
                this.f854o = b.getSdkVersion();
                this.f840a.mo10969ag().mo10897a(this.f854o, string);
            }
        }
    }

    /* renamed from: p */
    public List<MaxAdFormat> mo10083p() {
        return this.f859t;
    }

    /* renamed from: q */
    public boolean mo10084q() {
        return this.f850k;
    }

    /* renamed from: r */
    public List<C0887d> mo10085r() {
        return this.f860u;
    }

    /* renamed from: s */
    public List<C0882a> mo10086s() {
        return this.f861v;
    }

    /* renamed from: t */
    public final C0886c mo10087t() {
        return this.f863x;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediatedNetwork{name=");
        outline24.append(this.f851l);
        outline24.append(", displayName=");
        outline24.append(this.f852m);
        outline24.append(", sdkAvailable=");
        outline24.append(this.f843d);
        outline24.append(", sdkVersion=");
        outline24.append(this.f854o);
        outline24.append(", adapterAvailable=");
        outline24.append(this.f844e);
        outline24.append(", adapterVersion=");
        return GeneratedOutlineSupport.outline18(outline24, this.f855p, "}");
    }

    /* renamed from: u */
    public String mo10089u() {
        return this.f857r;
    }

    /* renamed from: v */
    public final C1188m mo10090v() {
        return this.f840a;
    }

    /* renamed from: w */
    public final String mo10091w() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("\n---------- ");
        outline24.append(this.f851l);
        outline24.append(" ----------");
        outline24.append("\nStatus  - ");
        outline24.append(this.f841b.m1037a());
        outline24.append("\nSDK     - ");
        String str = "UNAVAILABLE";
        outline24.append((!this.f843d || TextUtils.isEmpty(this.f854o)) ? str : this.f854o);
        outline24.append("\nAdapter - ");
        if (this.f844e && !TextUtils.isEmpty(this.f855p)) {
            str = this.f855p;
        }
        outline24.append(str);
        if (this.f863x.mo10095a() && !this.f863x.mo10096b()) {
            outline24.append("\n* ");
            outline24.append(this.f863x.mo10097c());
        }
        for (C0887d next : mo10085r()) {
            if (!next.mo10100c()) {
                outline24.append("\n* MISSING ");
                outline24.append(next.mo10098a());
                outline24.append(": ");
                outline24.append(next.mo10099b());
            }
        }
        for (C0882a next2 : mo10086s()) {
            if (!next2.mo10065c()) {
                outline24.append("\n* MISSING ");
                outline24.append(next2.mo10063a());
                outline24.append(": ");
                outline24.append(next2.mo10064b());
            }
        }
        return outline24.toString();
    }
}
