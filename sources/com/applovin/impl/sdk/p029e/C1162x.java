package com.applovin.impl.sdk.p029e;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.p007a.C0639e;
import com.applovin.impl.p007a.C0640f;
import com.applovin.impl.p007a.C0647l;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.network.C1217c;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1310q;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.e.x */
public class C1162x extends C1109a {

    /* renamed from: a */
    public final C0639e f2093a;

    /* renamed from: c */
    public final AppLovinAdLoadListener f2094c;

    public C1162x(C0639e eVar, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
        super("TaskResolveVastWrapper", mVar);
        this.f2094c = appLovinAdLoadListener;
        this.f2093a = eVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1975a(int i) {
        mo10773d("Failed to resolve VAST wrapper due to error code " + i);
        if (i == -1009) {
            AppLovinAdLoadListener appLovinAdLoadListener = this.f2094c;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i);
                return;
            }
            return;
        }
        C0647l.m150a(this.f2093a, this.f2094c, i == -1001 ? C0640f.TIMED_OUT : C0640f.GENERAL_WRAPPER_ERROR, i, this.f1961b);
    }

    public void run() {
        String a = C0647l.m146a(this.f2093a);
        if (StringUtils.isValidString(a)) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Resolving VAST ad with depth ");
            outline24.append(this.f2093a.mo9363a());
            outline24.append(" at ");
            outline24.append(a);
            mo10768a(outline24.toString());
            try {
                this.f1961b.mo10938S().mo10828a((C1109a) new C1157u<C1310q>(C1217c.m2223a(this.f1961b).mo11127a(a).mo11133b("GET").mo11126a(C1310q.f2561a).mo11125a(((Integer) this.f1961b.mo10946a(C1085b.f1795er)).intValue()).mo11132b(((Integer) this.f1961b.mo10946a(C1085b.f1796es)).intValue()).mo11138c(false).mo11131a(), this.f1961b) {
                    /* renamed from: a */
                    public void mo10008a(int i, String str, C1310q qVar) {
                        mo10773d("Unable to resolve VAST wrapper. Server returned " + i);
                        C1162x.this.m1975a(i);
                    }

                    /* renamed from: a */
                    public void mo10010a(C1310q qVar, int i) {
                        this.f1961b.mo10938S().mo10828a((C1109a) C1150r.m1939a(qVar, C1162x.this.f2093a, C1162x.this.f2094c, C1162x.this.f1961b));
                    }
                });
            } catch (Throwable th) {
                mo10769a("Unable to resolve VAST wrapper", th);
            }
        } else {
            mo10773d("Resolving VAST failed. Could not find resolution URL");
            m1975a(-1);
        }
    }
}
