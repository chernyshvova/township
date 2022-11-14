package com.applovin.impl.mediation.p011b;

import android.app.Activity;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.p010a.C0806f;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.mediation.b.a */
public class C0841a extends C1109a {

    /* renamed from: a */
    public final List<C0806f> f710a;

    /* renamed from: c */
    public final Activity f711c;

    /* renamed from: com.applovin.impl.mediation.b.a$a */
    public static class C0843a extends C1109a {

        /* renamed from: a */
        public final C0806f f714a;

        /* renamed from: c */
        public final List<C0806f> f715c;

        /* renamed from: d */
        public final Activity f716d;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public C0843a(com.applovin.impl.mediation.p010a.C0806f r3, java.util.List<com.applovin.impl.mediation.p010a.C0806f> r4, com.applovin.impl.sdk.C1188m r5, android.app.Activity r6) {
            /*
                r2 = this;
                java.lang.String r0 = "TaskSequentialInitAdapter:"
                java.lang.StringBuilder r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r0)
                java.lang.String r1 = r3.mo9897O()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r1 = 1
                r2.<init>(r0, r5, r1)
                r2.f716d = r6
                r2.f714a = r3
                r2.f715c = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.p011b.C0841a.C0843a.<init>(com.applovin.impl.mediation.a.f, java.util.List, com.applovin.impl.sdk.m, android.app.Activity):void");
        }

        public void run() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Auto-initing ");
            outline24.append(this.f714a);
            outline24.append("...");
            mo10768a(outline24.toString());
            this.f1961b.mo10924D().mo10229a(this.f714a, this.f716d, new Runnable() {
                public void run() {
                    C0843a aVar = C0843a.this;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Initialization task for adapter '");
                    outline24.append(C0843a.this.f714a.mo9898P());
                    outline24.append("' finished");
                    aVar.mo10768a(outline24.toString());
                    int indexOf = C0843a.this.f715c.indexOf(C0843a.this.f714a);
                    if (indexOf < C0843a.this.f715c.size() - 1) {
                        C0806f fVar = (C0806f) C0843a.this.f715c.get(indexOf + 1);
                        C0843a.this.f1961b.mo10938S().mo10830a(new C0843a(fVar, C0843a.this.f715c, C0843a.this.f1961b, C0843a.this.f716d), C1140o.C1142a.MAIN, fVar.mo9917aa());
                        return;
                    }
                    C0843a.this.mo10768a("Finished initializing adapters");
                }
            });
        }
    }

    public C0841a(List<C0806f> list, Activity activity, C1188m mVar) {
        super("TaskAutoInitAdapters", mVar, true);
        this.f710a = list;
        this.f711c = activity;
    }

    public void run() {
        try {
            if (this.f710a.size() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Auto-initing ");
                sb.append(this.f710a.size());
                sb.append(" adapters");
                sb.append(this.f1961b.mo10930J().mo10221a() ? " in test mode" : "");
                sb.append("...");
                mo10768a(sb.toString());
                if (TextUtils.isEmpty(this.f1961b.mo11003t())) {
                    this.f1961b.mo10985c(AppLovinMediationProvider.MAX);
                } else if (!this.f1961b.mo10989f()) {
                    C1314v.m2663i(AppLovinSdk.TAG, "Auto-initing adapters for non-MAX mediation provider: " + this.f1961b.mo11003t());
                }
                if (this.f711c == null) {
                    C1314v.m2663i(AppLovinSdk.TAG, "\n**********\nAttempting to init 3rd-party SDKs without an Activity instance. Please make sure to update the top Activity using `updateActivity().\n**********\n");
                }
                if (((Boolean) this.f1961b.mo10946a(C1084a.f1512W)).booleanValue()) {
                    C0806f fVar = this.f710a.get(0);
                    this.f1961b.mo10938S().mo10830a(new C0843a(fVar, this.f710a, this.f1961b, this.f711c), C1140o.C1142a.MAIN, fVar.mo9917aa());
                    return;
                }
                for (final C0806f next : this.f710a) {
                    this.f1961b.mo10938S().mo10833b().schedule(new Runnable() {
                        public void run() {
                            C0841a aVar = C0841a.this;
                            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Auto-initing adapter: ");
                            outline24.append(next);
                            aVar.mo10768a(outline24.toString());
                            C0841a.this.f1961b.mo10924D().mo10228a(next, C0841a.this.f711c);
                        }
                    }, next.mo9917aa(), TimeUnit.MILLISECONDS);
                }
            }
        } catch (Throwable th) {
            mo10769a("Failed to auto-init adapters", th);
        }
    }
}
