package com.applovin.impl.sdk.p029e;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.network.C1213b;
import com.applovin.impl.sdk.p026b.C1082c;
import com.applovin.impl.sdk.p027c.C1085b;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.ab */
public abstract class C1111ab extends C1164y {
    public C1111ab(String str, C1188m mVar) {
        super(str, mVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1809b(JSONObject jSONObject) {
        C1082c c = m1810c(jSONObject);
        if (c != null) {
            mo10026a(c);
            mo10768a("Pending reward handled: " + c);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r3 = java.util.Collections.emptyMap();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0020 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.applovin.impl.sdk.p026b.C1082c m1810c(org.json.JSONObject r3) {
        /*
            r2 = this;
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.C1264h.m2516a((org.json.JSONObject) r3)     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.m r1 = r2.f1961b     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.utils.C1264h.m2526d(r0, r1)     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.m r1 = r2.f1961b     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.utils.C1264h.m2525c(r3, r1)     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.m r1 = r2.f1961b     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.utils.C1264h.m2528e(r3, r1)     // Catch:{ JSONException -> 0x0032 }
            java.lang.String r3 = "params"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0020 }
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ all -> 0x0020 }
            java.util.Map r3 = com.applovin.impl.sdk.utils.JsonUtils.toStringMap(r3)     // Catch:{ all -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            java.util.Map r3 = java.util.Collections.emptyMap()     // Catch:{ JSONException -> 0x0032 }
        L_0x0024:
            java.lang.String r1 = "result"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ all -> 0x002b }
            goto L_0x002d
        L_0x002b:
            java.lang.String r0 = "network_timeout"
        L_0x002d:
            com.applovin.impl.sdk.b.c r3 = com.applovin.impl.sdk.p026b.C1082c.m1638a(r0, r3)     // Catch:{ JSONException -> 0x0032 }
            return r3
        L_0x0032:
            r3 = move-exception
            java.lang.String r0 = "Unable to parse API response"
            r2.mo10769a(r0, r3)
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p029e.C1111ab.m1810c(org.json.JSONObject):com.applovin.impl.sdk.b.c");
    }

    /* renamed from: a */
    public abstract void mo10026a(C1082c cVar);

    /* renamed from: b */
    public abstract boolean mo10027b();

    /* renamed from: h */
    public int mo10777h() {
        return ((Integer) this.f1961b.mo10946a(C1085b.f1645bx)).intValue();
    }

    public void run() {
        mo10863a(mo10864i(), new C1213b.C1216c<JSONObject>() {
            /* renamed from: a */
            public void mo10008a(int i, String str, JSONObject jSONObject) {
                if (C1111ab.this.mo10027b()) {
                    C1111ab abVar = C1111ab.this;
                    abVar.mo10773d("Reward validation failed with error code " + i + " but task was cancelled already");
                    return;
                }
                C1111ab abVar2 = C1111ab.this;
                abVar2.mo10773d("Reward validation failed with code " + i + " and error: " + str);
                C1111ab.this.mo10021a(i);
            }

            /* renamed from: a */
            public void mo10010a(JSONObject jSONObject, int i) {
                if (C1111ab.this.mo10027b()) {
                    C1111ab abVar = C1111ab.this;
                    abVar.mo10773d("Reward validation succeeded with code " + i + " but task was cancelled already");
                    C1111ab abVar2 = C1111ab.this;
                    abVar2.mo10773d("Response: " + jSONObject);
                    return;
                }
                C1111ab abVar3 = C1111ab.this;
                abVar3.mo10768a("Reward validation succeeded with code " + i + " and response: " + jSONObject);
                C1111ab.this.m1809b(jSONObject);
            }
        });
    }
}
