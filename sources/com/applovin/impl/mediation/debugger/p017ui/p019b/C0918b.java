package com.applovin.impl.mediation.debugger.p017ui.p019b;

import android.content.Context;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.debugger.p013a.p014a.C0878a;
import com.applovin.impl.mediation.debugger.p013a.p015b.C0883b;
import com.applovin.impl.mediation.debugger.p017ui.p019b.p020a.C0916a;
import com.applovin.impl.mediation.debugger.p017ui.p019b.p020a.C0917b;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0933d;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0936e;
import com.applovin.impl.sdk.C1173j;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1262f;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1368R;
import com.vungle.warren.CleverCacheSettings;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.mediation.debugger.ui.b.b */
public class C0918b extends C0933d implements AppLovinCommunicatorSubscriber {

    /* renamed from: a */
    public C1188m f965a;

    /* renamed from: b */
    public List<C0878a> f966b;

    /* renamed from: d */
    public String f967d;

    /* renamed from: e */
    public String f968e;

    /* renamed from: f */
    public String f969f;

    /* renamed from: g */
    public final StringBuilder f970g = new StringBuilder("");

    /* renamed from: h */
    public final AtomicBoolean f971h = new AtomicBoolean();

    /* renamed from: i */
    public boolean f972i = false;

    /* renamed from: j */
    public List<C0883b> f973j = new ArrayList();

    /* renamed from: k */
    public List<C0883b> f974k = new ArrayList();

    /* renamed from: l */
    public List<C0883b> f975l = new ArrayList();

    /* renamed from: m */
    public List<C0883b> f976m = new ArrayList();

    /* renamed from: n */
    public List<C0929c> f977n = new ArrayList();

    /* renamed from: o */
    public List<C0929c> f978o = new ArrayList();

    /* renamed from: p */
    public List<C0929c> f979p = new ArrayList();

    /* renamed from: q */
    public List<C0929c> f980q = new ArrayList();

    /* renamed from: r */
    public List<C0929c> f981r = new ArrayList();

    /* renamed from: s */
    public List<C0929c> f982s = new ArrayList();

    /* renamed from: t */
    public List<C0929c> f983t = new ArrayList();

    /* renamed from: com.applovin.impl.mediation.debugger.ui.b.b$a */
    public enum C0920a {
        AD_UNITS,
        SELECT_LIVE_NETWORKS,
        COUNT
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.b.b$b */
    public enum C0921b {
        APP_INFO,
        MAX,
        PRIVACY,
        ADS,
        INCOMPLETE_NETWORKS,
        COMPLETED_NETWORKS,
        MISSING_NETWORKS,
        COUNT
    }

    public C0918b(Context context) {
        super(context);
    }

    /* renamed from: a */
    private C0929c m1122a(String str, String str2) {
        C0929c.C0931a a = C0929c.m1177p().mo10180a(str);
        if (StringUtils.isValidString(str2)) {
            a.mo10185b(str2);
        } else {
            a.mo10177a(C1368R.C1369drawable.applovin_ic_x_mark);
            a.mo10187c(C1262f.m2502a(C1368R.color.applovin_sdk_xmarkColor, this.f1061c));
        }
        return a.mo10182a();
    }

    /* renamed from: a */
    private void m1123a(C0929c.C0931a aVar, String str) {
        aVar.mo10188c("MAX Ad Review").mo10189d(str).mo10177a(C1368R.C1369drawable.applovin_ic_x_mark).mo10187c(C1262f.m2502a(C1368R.color.applovin_sdk_xmarkColor, this.f1061c)).mo10181a(true);
    }

    /* renamed from: a */
    private void m1124a(StringBuilder sb, String str) {
        String sb2 = sb.toString();
        if (str.length() + sb2.length() >= ((Integer) this.f965a.mo10946a(C1085b.f1586ar)).intValue()) {
            C1314v.m2660f("MediationDebuggerListAdapter", sb2);
            this.f970g.append(sb2);
            sb.setLength(1);
        }
        sb.append(str);
    }

    /* renamed from: a */
    private void m1125a(List<C0883b> list) {
        List<C0883b> list2;
        for (C0883b next : list) {
            if (!next.mo10074g()) {
                if (next.mo10067a() == C0883b.C0884a.INCOMPLETE_INTEGRATION || next.mo10067a() == C0883b.C0884a.INVALID_INTEGRATION) {
                    list2 = this.f973j;
                } else if (next.mo10067a() == C0883b.C0884a.COMPLETE) {
                    this.f974k.add(next);
                    list2 = this.f976m;
                } else if (next.mo10067a() == C0883b.C0884a.MISSING) {
                    list2 = this.f975l;
                }
                list2.add(next);
            }
        }
    }

    /* renamed from: b */
    private List<C0929c> m1126b(List<C0883b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (C0883b aVar : list) {
            arrayList.add(new C0916a(aVar, this.f1061c));
        }
        return arrayList;
    }

    /* renamed from: j */
    private void m1127j() {
        Map<String, String> metaData;
        StringBuilder sb = new StringBuilder("\n========== MEDIATION DEBUGGER ==========");
        sb.append("\n========== APP INFO ==========");
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("\nDev Build - ");
        outline24.append(Utils.isPubInDebugMode(this.f1061c));
        sb.append(outline24.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nTest Mode - ");
        sb2.append(this.f965a.mo10930J().mo10221a() ? CleverCacheSettings.KEY_ENABLED : "disabled");
        sb.append(sb2.toString());
        sb.append("\nTarget SDK - " + this.f965a.mo10941V().mo11213h().get("target_sdk"));
        sb.append("\n========== MAX ==========");
        String str = AppLovinSdk.VERSION;
        String str2 = (String) this.f965a.mo10946a(C1085b.f1700dA);
        String safedkVersion = Utils.getSafedkVersion();
        sb.append("\nSDK Version - " + str);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\nPlugin Version - ");
        String str3 = "None";
        if (!StringUtils.isValidString(str2)) {
            str2 = str3;
        }
        sb3.append(str2);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("\nAd Review Version - ");
        if (!StringUtils.isValidString(safedkVersion)) {
            safedkVersion = "Disabled";
        }
        sb4.append(safedkVersion);
        sb.append(sb4.toString());
        if (this.f965a.mo10990g() && (metaData = Utils.getMetaData(this.f965a.mo10999p())) != null) {
            String str4 = metaData.get("UnityVersion");
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("\nUnity Version - ");
            if (StringUtils.isValidString(str4)) {
                str3 = str4;
            }
            outline242.append(str3);
            sb.append(outline242.toString());
        }
        sb.append("\n========== PRIVACY ==========");
        sb.append(C1173j.m2014a(this.f1061c));
        sb.append("\n========== NETWORKS ==========");
        for (C0883b w : this.f974k) {
            m1124a(sb, w.mo10091w());
        }
        for (C0883b w2 : this.f973j) {
            m1124a(sb, w2.mo10091w());
        }
        sb.append("\n========== AD UNITS ==========");
        for (C0878a f : this.f966b) {
            m1124a(sb, f.mo10051f());
        }
        sb.append("\n========== END ==========");
        C1314v.m2660f("MediationDebuggerListAdapter", sb.toString());
        this.f970g.append(sb.toString());
    }

    /* renamed from: k */
    private List<C0929c> m1128k() {
        String str;
        ArrayList arrayList = new ArrayList(5);
        try {
            str = this.f1061c.getPackageManager().getPackageInfo(this.f1061c.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            str = null;
        }
        arrayList.add(C0929c.m1177p().mo10180a("Package Name").mo10185b(this.f1061c.getPackageName()).mo10182a());
        C0929c.C0931a a = C0929c.m1177p().mo10180a("App Version");
        String str2 = "None";
        if (!StringUtils.isValidString(str)) {
            str = str2;
        }
        arrayList.add(a.mo10185b(str).mo10182a());
        arrayList.add(C0929c.m1177p().mo10180a("OS").mo10185b(Utils.getAndroidOSInfo()).mo10182a());
        arrayList.add(C0929c.m1177p().mo10180a("Account").mo10185b(StringUtils.isValidString(this.f969f) ? this.f969f : str2).mo10182a());
        C0929c.C0931a a2 = C0929c.m1177p().mo10180a("Mediation Provider");
        if (StringUtils.isValidString(this.f965a.mo11003t())) {
            str2 = this.f965a.mo11003t();
        }
        arrayList.add(a2.mo10185b(str2).mo10182a());
        arrayList.add(C0929c.m1177p().mo10180a("OM SDK Version").mo10185b(this.f965a.mo10975am().mo10475c()).mo10182a());
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00be  */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c> m1129l() {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 4
            r0.<init>(r1)
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c.m1177p()
            java.lang.String r2 = "SDK Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.mo10180a((java.lang.String) r2)
            java.lang.String r2 = com.applovin.sdk.AppLovinSdk.VERSION
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.mo10185b((java.lang.String) r2)
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.mo10182a()
            r0.add(r1)
            com.applovin.impl.sdk.m r1 = r6.f965a
            com.applovin.impl.sdk.c.b<java.lang.String> r2 = com.applovin.impl.sdk.p027c.C1085b.f1700dA
            java.lang.Object r1 = r1.mo10946a(r2)
            java.lang.String r1 = (java.lang.String) r1
            com.applovin.impl.mediation.debugger.ui.d.c$a r2 = com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c.m1177p()
            java.lang.String r3 = "Plugin Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r2 = r2.mo10180a((java.lang.String) r3)
            boolean r3 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r1)
            java.lang.String r4 = "None"
            if (r3 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r1 = r4
        L_0x003b:
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r2.mo10185b((java.lang.String) r1)
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.mo10182a()
            r0.add(r1)
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c.m1177p()
            java.lang.String r2 = "Ad Review Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.mo10180a((java.lang.String) r2)
            java.lang.String r2 = com.applovin.impl.sdk.utils.Utils.getSafedkVersion()
            boolean r3 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r2)
            if (r3 == 0) goto L_0x0090
            java.lang.String r3 = com.applovin.impl.sdk.utils.Utils.getSafedkSdkKey()
            boolean r5 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r3)
            if (r5 == 0) goto L_0x008c
            com.applovin.impl.sdk.m r5 = r6.f965a
            java.lang.String r5 = r5.mo11010z()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0071
            goto L_0x008c
        L_0x0071:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "MAX Ad Review integrated with wrong SDK key. Please check that your "
            r2.<init>(r3)
            com.applovin.impl.sdk.m r3 = r6.f965a
            boolean r3 = r3.mo10990g()
            if (r3 == 0) goto L_0x0083
            java.lang.String r3 = "SDK key is downloaded"
            goto L_0x0085
        L_0x0083:
            java.lang.String r3 = "Gradle plugin snippet is integrated"
        L_0x0085:
            java.lang.String r5 = " from the correct account."
            java.lang.String r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline18(r2, r3, r5)
            goto L_0x0092
        L_0x008c:
            r1.mo10185b((java.lang.String) r2)
            goto L_0x0095
        L_0x0090:
            java.lang.String r2 = "Integrating MAX Ad review is OPTIONAL. This feature gives developers unprecedented transparency into the creatives the users see in their apps."
        L_0x0092:
            r6.m1123a((com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c.C0931a) r1, (java.lang.String) r2)
        L_0x0095:
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.mo10182a()
            r0.add(r1)
            com.applovin.impl.sdk.m r1 = r6.f965a
            boolean r1 = r1.mo10990g()
            if (r1 == 0) goto L_0x00c8
            com.applovin.impl.sdk.m r1 = r6.f965a
            com.applovin.sdk.AppLovinSdkSettings r1 = r1.mo10999p()
            java.util.Map r1 = com.applovin.impl.sdk.utils.Utils.getMetaData(r1)
            if (r1 == 0) goto L_0x00c8
            java.lang.String r2 = "UnityVersion"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r1)
            if (r2 == 0) goto L_0x00bf
            r4 = r1
        L_0x00bf:
            java.lang.String r1 = "Unity Version"
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r6.m1122a((java.lang.String) r1, (java.lang.String) r4)
            r0.add(r1)
        L_0x00c8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.debugger.p017ui.p019b.C0918b.m1129l():java.util.List");
    }

    /* renamed from: m */
    private List<C0929c> m1130m() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new C0917b(C1173j.m2013a(), true, this.f1061c));
        arrayList.add(new C0917b(C1173j.m2018b(), false, this.f1061c));
        arrayList.add(new C0917b(C1173j.m2020c(), true, this.f1061c));
        return arrayList;
    }

    /* renamed from: n */
    private List<C0929c> m1131n() {
        ArrayList arrayList = new ArrayList(2);
        C0929c.C0931a p = C0929c.m1177p();
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("View Ad Units (");
        outline24.append(this.f966b.size());
        outline24.append(")");
        arrayList.add(p.mo10180a(outline24.toString()).mo10178a(this.f1061c).mo10181a(true).mo10182a());
        arrayList.add(m1132o());
        return arrayList;
    }

    /* renamed from: o */
    private C0929c m1132o() {
        C0929c.C0931a p = C0929c.m1177p();
        if (!this.f965a.mo10930J().mo10221a()) {
            p.mo10178a(this.f1061c);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f965a.mo10930J().mo10224c() != null ? "" : "Select ");
        sb.append("Live Network");
        return p.mo10180a(sb.toString()).mo10185b(this.f965a.mo10930J().mo10221a() ? "Enable" : null).mo10183b(-16776961).mo10189d("Ad loads are not supported while Test Mode is enabled. Please restart the app and make sure your GAID has not been enabled for test mode and that you are not on an emulator.").mo10181a(true).mo10182a();
    }

    /* renamed from: a */
    public int mo10118a(int i) {
        List<C0929c> list;
        C0921b bVar = C0921b.APP_INFO;
        if (i == 0) {
            list = this.f977n;
        } else {
            C0921b bVar2 = C0921b.MAX;
            if (i == 1) {
                list = this.f978o;
            } else {
                C0921b bVar3 = C0921b.PRIVACY;
                if (i == 2) {
                    list = this.f979p;
                } else {
                    C0921b bVar4 = C0921b.ADS;
                    if (i == 3) {
                        list = this.f980q;
                    } else {
                        C0921b bVar5 = C0921b.INCOMPLETE_NETWORKS;
                        if (i == 4) {
                            list = this.f981r;
                        } else {
                            C0921b bVar6 = C0921b.COMPLETED_NETWORKS;
                            list = i == 5 ? this.f982s : this.f983t;
                        }
                    }
                }
            }
        }
        return list.size();
    }

    /* renamed from: a */
    public void mo10148a(List<C0883b> list, List<C0878a> list2, String str, String str2, String str3, C1188m mVar) {
        this.f965a = mVar;
        this.f966b = list2;
        this.f967d = str;
        this.f968e = str2;
        this.f969f = str3;
        if (list != null && this.f971h.compareAndSet(false, true)) {
            mVar.mo10922B().mo11372b("MediationDebuggerListAdapter", "Populating networks...");
            m1125a(list);
            this.f977n.addAll(m1128k());
            this.f978o.addAll(m1129l());
            this.f979p.addAll(m1130m());
            this.f980q.addAll(m1131n());
            this.f981r = m1126b(this.f973j);
            this.f982s = m1126b(this.f974k);
            this.f983t = m1126b(this.f975l);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add("privacy_setting_updated");
            arrayList.add("network_sdk_version_updated");
            AppLovinCommunicator.getInstance(this.f1061c).subscribe((AppLovinCommunicatorSubscriber) this, (List<String>) arrayList);
            m1127j();
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                C0918b.this.notifyDataSetChanged();
            }
        });
    }

    /* renamed from: a */
    public void mo10149a(boolean z) {
        this.f972i = z;
    }

    /* renamed from: a */
    public boolean mo10150a() {
        return this.f971h.get();
    }

    /* renamed from: b */
    public int mo10120b() {
        C0921b bVar = C0921b.COUNT;
        return 7;
    }

    /* renamed from: b */
    public C0929c mo10121b(int i) {
        C0921b bVar = C0921b.APP_INFO;
        if (i == 0) {
            return new C0936e("APP INFO");
        }
        C0921b bVar2 = C0921b.MAX;
        if (i == 1) {
            return new C0936e("MAX");
        }
        C0921b bVar3 = C0921b.PRIVACY;
        if (i == 2) {
            return new C0936e("PRIVACY");
        }
        C0921b bVar4 = C0921b.ADS;
        if (i == 3) {
            return new C0936e("ADS");
        }
        C0921b bVar5 = C0921b.INCOMPLETE_NETWORKS;
        if (i == 4) {
            return new C0936e("INCOMPLETE INTEGRATIONS");
        }
        C0921b bVar6 = C0921b.COMPLETED_NETWORKS;
        return i == 5 ? new C0936e("COMPLETED INTEGRATIONS") : new C0936e("MISSING INTEGRATIONS");
    }

    /* renamed from: c */
    public List<C0929c> mo10122c(int i) {
        C0921b bVar = C0921b.APP_INFO;
        if (i == 0) {
            return this.f977n;
        }
        C0921b bVar2 = C0921b.MAX;
        if (i == 1) {
            return this.f978o;
        }
        C0921b bVar3 = C0921b.PRIVACY;
        if (i == 2) {
            return this.f979p;
        }
        C0921b bVar4 = C0921b.ADS;
        if (i == 3) {
            return this.f980q;
        }
        C0921b bVar5 = C0921b.INCOMPLETE_NETWORKS;
        if (i == 4) {
            return this.f981r;
        }
        C0921b bVar6 = C0921b.COMPLETED_NETWORKS;
        return i == 5 ? this.f982s : this.f983t;
    }

    /* renamed from: c */
    public boolean mo10151c() {
        return this.f972i;
    }

    /* renamed from: d */
    public C1188m mo10152d() {
        return this.f965a;
    }

    /* renamed from: e */
    public List<C0878a> mo10153e() {
        return this.f966b;
    }

    /* renamed from: f */
    public String mo10154f() {
        return this.f967d;
    }

    /* renamed from: g */
    public String mo10155g() {
        return this.f968e;
    }

    public String getCommunicatorId() {
        return "MediationDebuggerListAdapter";
    }

    /* renamed from: h */
    public List<C0883b> mo10156h() {
        return this.f976m;
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("privacy_setting_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.f979p = m1130m();
        } else if ("network_sdk_version_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.f981r = m1126b(this.f973j);
            this.f982s = m1126b(this.f974k);
        } else {
            return;
        }
        mo10202i();
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediationDebuggerListAdapter{isInitialized=");
        outline24.append(this.f971h.get());
        outline24.append("}");
        return outline24.toString();
    }
}
