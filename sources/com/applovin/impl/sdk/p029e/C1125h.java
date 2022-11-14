package com.applovin.impl.sdk.p029e;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.network.C1231i;
import com.applovin.impl.sdk.p025ad.C1053b;
import com.applovin.impl.sdk.p025ad.C1056d;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p028d.C1103f;
import com.applovin.impl.sdk.p028d.C1104g;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.C1264h;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.h */
public abstract class C1125h extends C1109a {

    /* renamed from: a */
    public final C1056d f1990a;

    /* renamed from: c */
    public final C1231i f1991c;

    public C1125h(C1056d dVar, @Nullable C1231i iVar, String str, C1188m mVar) {
        super(str, mVar);
        this.f1990a = dVar;
        this.f1991c = iVar;
    }

    /* renamed from: a */
    private void m1866a(C1104g gVar) {
        long b = gVar.mo10760b(C1103f.f1925c);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b > TimeUnit.MINUTES.toMillis((long) ((Integer) this.f1961b.mo10946a(C1085b.f1738dm)).intValue())) {
            gVar.mo10762b(C1103f.f1925c, currentTimeMillis);
            gVar.mo10764c(C1103f.f1926d);
        }
    }

    /* renamed from: i */
    private Map<String, String> m1867i() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("AppLovin-Zone-Id", this.f1990a.mo10548a());
        if (this.f1990a.mo10550c() != null) {
            hashMap.put("AppLovin-Ad-Size", this.f1990a.mo10550c().getLabel());
        }
        if (this.f1990a.mo10551d() != null) {
            hashMap.put("AppLovin-Ad-Type", this.f1990a.mo10551d().getLabel());
        }
        return hashMap;
    }

    /* renamed from: a */
    public abstract C1109a mo10805a(JSONObject jSONObject);

    /* renamed from: a */
    public Map<String, String> mo10806a() {
        HashMap hashMap = new HashMap(4);
        hashMap.put("zone_id", this.f1990a.mo10548a());
        if (this.f1990a.mo10550c() != null) {
            hashMap.put("size", this.f1990a.mo10550c().getLabel());
        }
        if (this.f1990a.mo10551d() != null) {
            hashMap.put("require", this.f1990a.mo10551d().getLabel());
        }
        hashMap.put("n", String.valueOf(this.f1961b.mo10968af().mo11385a(this.f1990a.mo10548a())));
        C1231i iVar = this.f1991c;
        if (iVar != null) {
            hashMap.putAll(BundleUtils.toStringMap(iVar.mo11196a()));
        }
        return hashMap;
    }

    /* renamed from: a */
    public void mo10807a(int i) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unable to fetch ");
        outline24.append(this.f1990a);
        outline24.append(" ad: server returned ");
        outline24.append(i);
        mo10773d(outline24.toString());
        if (i == -800) {
            this.f1961b.mo10939T().mo10757a(C1103f.f1930h);
        }
    }

    /* renamed from: b */
    public abstract String mo10808b();

    /* renamed from: b */
    public void mo10809b(JSONObject jSONObject) {
        C1264h.m2526d(jSONObject, this.f1961b);
        C1264h.m2525c(jSONObject, this.f1961b);
        C1264h.m2528e(jSONObject, this.f1961b);
        C1056d.m1474a(jSONObject);
        this.f1961b.mo10938S().mo10828a(mo10805a(jSONObject));
    }

    /* renamed from: c */
    public abstract String mo10810c();

    /* renamed from: h */
    public C1053b mo10811h() {
        return this.f1990a.mo10552e() ? C1053b.APPLOVIN_PRIMARY_ZONE : C1053b.APPLOVIN_CUSTOM_ZONE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.util.Map<java.lang.String, java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.util.Map<java.lang.String, java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v38, resolved type: java.util.HashMap} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            java.lang.String r0 = "Fetching next ad of zone: "
            java.lang.StringBuilder r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r0)
            com.applovin.impl.sdk.ad.d r1 = r9.f1990a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.mo10768a(r0)
            com.applovin.impl.sdk.m r0 = r9.f1961b
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.p027c.C1085b.f1706dG
            java.lang.Object r0 = r0.mo10946a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002d
            boolean r0 = com.applovin.impl.sdk.utils.Utils.isVPNConnected()
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = "User is connected to a VPN"
            r9.mo10768a(r0)
        L_0x002d:
            com.applovin.impl.sdk.m r0 = r9.f1961b
            com.applovin.impl.sdk.d.g r0 = r0.mo10939T()
            com.applovin.impl.sdk.d.f r1 = com.applovin.impl.sdk.p028d.C1103f.f1923a
            r0.mo10757a(r1)
            com.applovin.impl.sdk.d.f r1 = com.applovin.impl.sdk.p028d.C1103f.f1925c
            long r1 = r0.mo10760b(r1)
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x004d
            com.applovin.impl.sdk.d.f r1 = com.applovin.impl.sdk.p028d.C1103f.f1925c
            long r2 = java.lang.System.currentTimeMillis()
            r0.mo10762b(r1, r2)
        L_0x004d:
            r1 = 0
            r2 = 0
            com.applovin.impl.sdk.m r3 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.AppLovinAdServiceImpl r3 = r3.mo11005u()     // Catch:{ all -> 0x01a6 }
            org.json.JSONObject r3 = r3.getAndResetCustomPostBody()     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.m r4 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r5 = com.applovin.impl.sdk.p027c.C1085b.f1733dh     // Catch:{ all -> 0x01a6 }
            java.lang.Object r4 = r4.mo10946a(r5)     // Catch:{ all -> 0x01a6 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x01a6 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01a6 }
            r5 = 1
            java.lang.String r6 = "POST"
            if (r4 == 0) goto L_0x00b2
            com.applovin.impl.sdk.m r1 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.o r1 = r1.mo10941V()     // Catch:{ all -> 0x01a6 }
            java.util.Map r4 = r9.mo10806a()     // Catch:{ all -> 0x01a6 }
            java.util.Map r1 = r1.mo11205a(r4, r2, r5)     // Catch:{ all -> 0x01a6 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x01a6 }
            r4.<init>(r1)     // Catch:{ all -> 0x01a6 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x01a6 }
            r1.<init>()     // Catch:{ all -> 0x01a6 }
            java.lang.String r7 = "rid"
            java.util.UUID r8 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x01a6 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x01a6 }
            r1.put(r7, r8)     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.m r7 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p027c.C1085b.f1797et     // Catch:{ all -> 0x01a6 }
            java.lang.Object r7 = r7.mo10946a(r8)     // Catch:{ all -> 0x01a6 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x01a6 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x01a6 }
            if (r7 != 0) goto L_0x00ac
            java.lang.String r7 = "sdk_key"
            com.applovin.impl.sdk.m r8 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            java.lang.String r8 = r8.mo11010z()     // Catch:{ all -> 0x01a6 }
            r1.put(r7, r8)     // Catch:{ all -> 0x01a6 }
        L_0x00ac:
            if (r3 == 0) goto L_0x00cd
            com.applovin.impl.sdk.utils.JsonUtils.putAll(r4, r3)     // Catch:{ all -> 0x01a6 }
            goto L_0x00cd
        L_0x00b2:
            java.lang.String r4 = "GET"
            com.applovin.impl.sdk.m r7 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.o r7 = r7.mo10941V()     // Catch:{ all -> 0x01a6 }
            java.util.Map r8 = r9.mo10806a()     // Catch:{ all -> 0x01a6 }
            java.util.Map r7 = r7.mo11205a(r8, r2, r2)     // Catch:{ all -> 0x01a6 }
            java.util.Map r7 = com.applovin.impl.sdk.utils.Utils.stringifyObjectMap(r7)     // Catch:{ all -> 0x01a6 }
            if (r3 == 0) goto L_0x00ca
            r1 = r3
            goto L_0x00cb
        L_0x00ca:
            r6 = r4
        L_0x00cb:
            r4 = r1
            r1 = r7
        L_0x00cd:
            android.content.Context r3 = r9.mo10775f()     // Catch:{ all -> 0x01a6 }
            boolean r3 = com.applovin.impl.sdk.utils.Utils.isDspDemoApp(r3)     // Catch:{ all -> 0x01a6 }
            if (r3 == 0) goto L_0x00e4
            com.applovin.impl.sdk.m r3 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.AppLovinAdServiceImpl r3 = r3.mo11005u()     // Catch:{ all -> 0x01a6 }
            java.util.Map r3 = r3.getAndResetCustomQueryParams()     // Catch:{ all -> 0x01a6 }
            r1.putAll(r3)     // Catch:{ all -> 0x01a6 }
        L_0x00e4:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x01a6 }
            r3.<init>()     // Catch:{ all -> 0x01a6 }
            java.util.Map r7 = com.applovin.impl.sdk.C1046ac.m1444b()     // Catch:{ all -> 0x01a6 }
            r3.putAll(r7)     // Catch:{ all -> 0x01a6 }
            java.util.Map r7 = r9.m1867i()     // Catch:{ all -> 0x01a6 }
            r3.putAll(r7)     // Catch:{ all -> 0x01a6 }
            r9.m1866a((com.applovin.impl.sdk.p028d.C1104g) r0)     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.m r0 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.network.c$a r0 = com.applovin.impl.sdk.network.C1217c.m2223a((com.applovin.impl.sdk.C1188m) r0)     // Catch:{ all -> 0x01a6 }
            java.lang.String r7 = r9.mo10808b()     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.network.c$a r0 = r0.mo11127a((java.lang.String) r7)     // Catch:{ all -> 0x01a6 }
            java.lang.String r7 = r9.mo10810c()     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.network.c$a r0 = r0.mo11137c((java.lang.String) r7)     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.network.c$a r0 = r0.mo11128a((java.util.Map<java.lang.String, java.lang.String>) r1)     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.network.c$a r0 = r0.mo11133b((java.lang.String) r6)     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.network.c$a r0 = r0.mo11134b((java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ all -> 0x01a6 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x01a6 }
            r1.<init>()     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.network.c$a r0 = r0.mo11126a(r1)     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.m r1 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.c.b<java.lang.Integer> r3 = com.applovin.impl.sdk.p027c.C1085b.f1669cV     // Catch:{ all -> 0x01a6 }
            java.lang.Object r1 = r1.mo10946a(r3)     // Catch:{ all -> 0x01a6 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x01a6 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.network.c$a r0 = r0.mo11125a((int) r1)     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.m r1 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r3 = com.applovin.impl.sdk.p027c.C1085b.f1670cW     // Catch:{ all -> 0x01a6 }
            java.lang.Object r1 = r1.mo10946a(r3)     // Catch:{ all -> 0x01a6 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x01a6 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.network.c$a r0 = r0.mo11130a((boolean) r1)     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.m r1 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r3 = com.applovin.impl.sdk.p027c.C1085b.f1671cX     // Catch:{ all -> 0x01a6 }
            java.lang.Object r1 = r1.mo10946a(r3)     // Catch:{ all -> 0x01a6 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x01a6 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.network.c$a r0 = r0.mo11135b((boolean) r1)     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.m r1 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.c.b<java.lang.Integer> r3 = com.applovin.impl.sdk.p027c.C1085b.f1668cU     // Catch:{ all -> 0x01a6 }
            java.lang.Object r1 = r1.mo10946a(r3)     // Catch:{ all -> 0x01a6 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x01a6 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.network.c$a r0 = r0.mo11132b((int) r1)     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.network.c$a r0 = r0.mo11140e(r5)     // Catch:{ all -> 0x01a6 }
            if (r4 == 0) goto L_0x0187
            r0.mo11129a((org.json.JSONObject) r4)     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.m r1 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r3 = com.applovin.impl.sdk.p027c.C1085b.f1753eB     // Catch:{ all -> 0x01a6 }
            java.lang.Object r1 = r1.mo10946a(r3)     // Catch:{ all -> 0x01a6 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x01a6 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x01a6 }
            r0.mo11139d(r1)     // Catch:{ all -> 0x01a6 }
        L_0x0187:
            com.applovin.impl.sdk.e.h$1 r1 = new com.applovin.impl.sdk.e.h$1     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.network.c r0 = r0.mo11131a()     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.m r3 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            r1.<init>(r0, r3)     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.c.b<java.lang.String> r0 = com.applovin.impl.sdk.p027c.C1085b.f1568aX     // Catch:{ all -> 0x01a6 }
            r1.mo10853a((com.applovin.impl.sdk.p027c.C1085b<java.lang.String>) r0)     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.c.b<java.lang.String> r0 = com.applovin.impl.sdk.p027c.C1085b.f1569aY     // Catch:{ all -> 0x01a6 }
            r1.mo10855b((com.applovin.impl.sdk.p027c.C1085b<java.lang.String>) r0)     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.m r0 = r9.f1961b     // Catch:{ all -> 0x01a6 }
            com.applovin.impl.sdk.e.o r0 = r0.mo10938S()     // Catch:{ all -> 0x01a6 }
            r0.mo10828a((com.applovin.impl.sdk.p029e.C1109a) r1)     // Catch:{ all -> 0x01a6 }
            goto L_0x01bc
        L_0x01a6:
            r0 = move-exception
            java.lang.String r1 = "Unable to fetch ad "
            java.lang.StringBuilder r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r1)
            com.applovin.impl.sdk.ad.d r3 = r9.f1990a
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r9.mo10769a(r1, r0)
            r9.mo10807a((int) r2)
        L_0x01bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p029e.C1125h.run():void");
    }
}
