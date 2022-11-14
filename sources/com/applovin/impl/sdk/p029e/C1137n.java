package com.applovin.impl.sdk.p029e;

import android.app.Activity;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1173j;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.utils.C1301k;
import com.applovin.impl.sdk.utils.C1306o;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.e.n */
public class C1137n extends C1109a {

    /* renamed from: a */
    public final C1188m f2004a;

    public C1137n(C1188m mVar) {
        super("TaskInitializeSdk", mVar);
        this.f2004a = mVar;
    }

    /* renamed from: a */
    private void m1909a() {
        if (!this.f2004a.mo10924D().mo10230a()) {
            Activity ao = this.f2004a.mo10977ao();
            if (ao != null) {
                this.f2004a.mo10924D().mo10226a(ao);
            } else {
                this.f2004a.mo10938S().mo10830a(new C1166z(this.f2004a, true, new Runnable() {
                    public void run() {
                        C1137n.this.f2004a.mo10924D().mo10226a(C1137n.this.f2004a.mo10967ae().mo10434a());
                    }
                }), C1140o.C1142a.MAIN, TimeUnit.SECONDS.toMillis(1));
            }
        }
    }

    /* renamed from: b */
    private void m1910b() {
        if (!this.f2004a.mo10988e()) {
            boolean d = this.f2004a.mo10931K().mo10686d();
            String outline18 = d ? GeneratedOutlineSupport.outline18(new StringBuilder(), this.f2004a.mo10941V().mo11217l().f2383b, " (use this for test devices)") : "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
            Map<String, Object> d2 = this.f2004a.mo10941V().mo11209d();
            Map<String, Object> c = this.f2004a.mo10941V().mo11208c();
            C1301k kVar = new C1301k();
            kVar.mo11316a().mo11322a("=====AppLovin SDK=====");
            kVar.mo11322a("===SDK Versions===").mo11323a("Version", AppLovinSdk.VERSION).mo11323a("Plugin Version", this.f2004a.mo10946a(C1085b.f1700dA)).mo11323a("Ad Review Version", Utils.getSafedkVersion()).mo11323a("OM SDK Version", this.f2004a.mo10975am().mo10475c());
            kVar.mo11322a("===Device Info===").mo11323a("OS", Utils.getAndroidOSInfo()).mo11323a("GAID", outline18).mo11323a("Model", d2.get(DeviceRequestsHelper.DEVICE_INFO_MODEL)).mo11323a("Locale", d2.get("locale")).mo11323a("Emulator", d2.get("sim")).mo11323a("WVVC", d2.get("wvvc")).mo11323a("Tablet", d2.get("is_tablet"));
            kVar.mo11322a("===App Info===").mo11323a("Application ID", c.get("package_name")).mo11323a("Target SDK", c.get("target_sdk")).mo11323a("ExoPlayer Version", Integer.valueOf(Utils.tryToGetExoPlayerVersionCode()));
            kVar.mo11322a("===SDK Settings===").mo11323a("SDK Key", this.f2004a.mo11010z()).mo11323a("Mediation Provider", this.f2004a.mo11003t()).mo11323a("TG", C1306o.m2623a(this.f2004a)).mo11323a("Test Mode On", Boolean.valueOf(this.f2004a.mo10930J().mo10221a())).mo11323a("Verbose Logging On", Boolean.valueOf(d));
            kVar.mo11322a("===Privacy States===\nPlease review AppLovin MAX documentation to be compliant with regional privacy policies.").mo11322a(C1173j.m2014a(mo10775f()));
            kVar.mo11316a();
            C1314v.m2660f(AppLovinSdk.TAG, kVar.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0147, code lost:
        if (r12.f2004a.mo10987d() != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0196, code lost:
        if (r12.f2004a.mo10987d() == false) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0199, code lost:
        r2 = "failed";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x019a, code lost:
        r5.append(r2);
        r5.append(" in ");
        r5.append(java.lang.System.currentTimeMillis() - r6);
        r5.append("ms");
        mo10768a(r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x01b2, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r12 = this;
            java.lang.String r0 = "ms"
            java.lang.String r1 = " in "
            java.lang.String r2 = "succeeded"
            java.lang.String r3 = "failed"
            java.lang.String r4 = " initialization "
            java.lang.String r5 = "AppLovin SDK "
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.String r8 = "Initializing AppLovin SDK v"
            java.lang.StringBuilder r8 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r8)
            java.lang.String r9 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r9)
            java.lang.String r9 = "..."
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r12.mo10768a(r8)
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.d.g r8 = r8.mo10939T()     // Catch:{ all -> 0x014a }
            r8.mo10765d()     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.d.g r8 = r8.mo10939T()     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.d.f r9 = com.applovin.impl.sdk.p028d.C1103f.f1924b     // Catch:{ all -> 0x014a }
            r8.mo10764c(r9)     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.r r8 = r8.mo10963aa()     // Catch:{ all -> 0x014a }
            android.content.Context r9 = r12.mo10775f()     // Catch:{ all -> 0x014a }
            r8.mo11243a((android.content.Context) r9)     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.r r8 = r8.mo10963aa()     // Catch:{ all -> 0x014a }
            android.content.Context r9 = r12.mo10775f()     // Catch:{ all -> 0x014a }
            r8.mo11246b((android.content.Context) r9)     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.d.c r8 = r8.mo10964ab()     // Catch:{ all -> 0x014a }
            r8.mo10718a()     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.e.o r8 = r8.mo10938S()     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.e.b r9 = new com.applovin.impl.sdk.e.b     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r10 = r12.f2004a     // Catch:{ all -> 0x014a }
            r9.<init>(r10)     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.e.o$a r10 = com.applovin.impl.sdk.p029e.C1140o.C1142a.MAIN     // Catch:{ all -> 0x014a }
            r8.mo10829a((com.applovin.impl.sdk.p029e.C1109a) r9, (com.applovin.impl.sdk.p029e.C1140o.C1142a) r10)     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.o r8 = r8.mo10941V()     // Catch:{ all -> 0x014a }
            r8.mo11210e()     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.utils.m r8 = r8.mo10970ah()     // Catch:{ all -> 0x014a }
            r8.mo11328a()     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.p r8 = r8.mo10973ak()     // Catch:{ all -> 0x014a }
            r8.mo11227b()     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            r8.mo10991h()     // Catch:{ all -> 0x014a }
            r12.m1910b()     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.p027c.C1085b.f1722dW     // Catch:{ all -> 0x014a }
            java.lang.Object r8 = r8.mo10946a(r9)     // Catch:{ all -> 0x014a }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x014a }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x014a }
            if (r8 == 0) goto L_0x00ab
            com.applovin.impl.sdk.e.n$1 r8 = new com.applovin.impl.sdk.e.n$1     // Catch:{ all -> 0x014a }
            r8.<init>()     // Catch:{ all -> 0x014a }
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThread(r8)     // Catch:{ all -> 0x014a }
        L_0x00ab:
            r12.m1909a()     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            r9 = 1
            r8.mo10960a((boolean) r9)     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.network.f r8 = r8.mo10940U()     // Catch:{ all -> 0x014a }
            r8.mo11144a()     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.sdk.AppLovinEventService r8 = r8.mo11007w()     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.EventServiceImpl r8 = (com.applovin.impl.sdk.EventServiceImpl) r8     // Catch:{ all -> 0x014a }
            r8.maybeTrackAppOpenEvent()     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.impl.mediation.debugger.a r8 = r8.mo10927G()     // Catch:{ all -> 0x014a }
            boolean r8 = r8.mo10037b()     // Catch:{ all -> 0x014a }
            if (r8 == 0) goto L_0x00dc
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            boolean r8 = r8.mo10988e()     // Catch:{ all -> 0x014a }
            if (r8 == 0) goto L_0x0100
        L_0x00dc:
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.p027c.C1084a.f1525h     // Catch:{ all -> 0x014a }
            java.lang.Object r8 = r8.mo10946a(r9)     // Catch:{ all -> 0x014a }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x014a }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x014a }
            if (r8 == 0) goto L_0x0109
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            android.content.Context r8 = r8.mo10932L()     // Catch:{ all -> 0x014a }
            boolean r8 = com.applovin.impl.sdk.utils.Utils.isPubInDebugMode(r8)     // Catch:{ all -> 0x014a }
            if (r8 == 0) goto L_0x0109
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            boolean r8 = r8.mo10989f()     // Catch:{ all -> 0x014a }
            if (r8 == 0) goto L_0x0109
        L_0x0100:
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x014a }
            com.applovin.impl.mediation.debugger.a r8 = r8.mo10927G()     // Catch:{ all -> 0x014a }
            r8.mo10033a()     // Catch:{ all -> 0x014a }
        L_0x0109:
            com.applovin.impl.sdk.m r8 = r12.f2004a
            com.applovin.impl.sdk.a.f r8 = r8.mo10975am()
            r8.mo10473a()
            com.applovin.impl.sdk.m r8 = r12.f2004a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.p027c.C1085b.f1549aE
            java.lang.Object r8 = r8.mo10946a(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0135
            com.applovin.impl.sdk.m r8 = r12.f2004a
            com.applovin.impl.sdk.c.b<java.lang.Long> r9 = com.applovin.impl.sdk.p027c.C1085b.f1550aF
            java.lang.Object r8 = r8.mo10946a(r9)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            com.applovin.impl.sdk.m r10 = r12.f2004a
            r10.mo10950a((long) r8)
        L_0x0135:
            java.lang.StringBuilder r5 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r5)
            java.lang.String r8 = com.applovin.sdk.AppLovinSdk.VERSION
            r5.append(r8)
            r5.append(r4)
            com.applovin.impl.sdk.m r4 = r12.f2004a
            boolean r4 = r4.mo10987d()
            if (r4 == 0) goto L_0x0199
            goto L_0x019a
        L_0x014a:
            r8 = move-exception
            java.lang.String r9 = "AppLovinSdk"
            java.lang.String r10 = "Failed to initialize SDK!"
            com.applovin.impl.sdk.C1314v.m2659c(r9, r10, r8)     // Catch:{ all -> 0x01b3 }
            com.applovin.impl.sdk.m r8 = r12.f2004a     // Catch:{ all -> 0x01b3 }
            r9 = 0
            r8.mo10960a((boolean) r9)     // Catch:{ all -> 0x01b3 }
            com.applovin.impl.sdk.m r8 = r12.f2004a
            com.applovin.impl.sdk.a.f r8 = r8.mo10975am()
            r8.mo10473a()
            com.applovin.impl.sdk.m r8 = r12.f2004a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.p027c.C1085b.f1549aE
            java.lang.Object r8 = r8.mo10946a(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0184
            com.applovin.impl.sdk.m r8 = r12.f2004a
            com.applovin.impl.sdk.c.b<java.lang.Long> r9 = com.applovin.impl.sdk.p027c.C1085b.f1550aF
            java.lang.Object r8 = r8.mo10946a(r9)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            com.applovin.impl.sdk.m r10 = r12.f2004a
            r10.mo10950a((long) r8)
        L_0x0184:
            java.lang.StringBuilder r5 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r5)
            java.lang.String r8 = com.applovin.sdk.AppLovinSdk.VERSION
            r5.append(r8)
            r5.append(r4)
            com.applovin.impl.sdk.m r4 = r12.f2004a
            boolean r4 = r4.mo10987d()
            if (r4 == 0) goto L_0x0199
            goto L_0x019a
        L_0x0199:
            r2 = r3
        L_0x019a:
            r5.append(r2)
            r5.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            r5.append(r1)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r12.mo10768a(r0)
            return
        L_0x01b3:
            r8 = move-exception
            com.applovin.impl.sdk.m r9 = r12.f2004a
            com.applovin.impl.sdk.a.f r9 = r9.mo10975am()
            r9.mo10473a()
            com.applovin.impl.sdk.m r9 = r12.f2004a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r10 = com.applovin.impl.sdk.p027c.C1085b.f1549aE
            java.lang.Object r9 = r9.mo10946a(r10)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x01e0
            com.applovin.impl.sdk.m r9 = r12.f2004a
            com.applovin.impl.sdk.c.b<java.lang.Long> r10 = com.applovin.impl.sdk.p027c.C1085b.f1550aF
            java.lang.Object r9 = r9.mo10946a(r10)
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            com.applovin.impl.sdk.m r11 = r12.f2004a
            r11.mo10950a((long) r9)
        L_0x01e0:
            java.lang.StringBuilder r5 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r5)
            java.lang.String r9 = com.applovin.sdk.AppLovinSdk.VERSION
            r5.append(r9)
            r5.append(r4)
            com.applovin.impl.sdk.m r4 = r12.f2004a
            boolean r4 = r4.mo10987d()
            if (r4 == 0) goto L_0x01f5
            goto L_0x01f6
        L_0x01f5:
            r2 = r3
        L_0x01f6:
            r5.append(r2)
            r5.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            r5.append(r1)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r12.mo10768a(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p029e.C1137n.run():void");
    }
}
