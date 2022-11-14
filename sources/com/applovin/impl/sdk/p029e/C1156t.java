package com.applovin.impl.sdk.p029e;

import com.applovin.impl.p007a.C0631a;
import com.applovin.impl.p007a.C0637c;
import com.applovin.impl.p007a.C0638d;
import com.applovin.impl.p007a.C0639e;
import com.applovin.impl.p007a.C0640f;
import com.applovin.impl.p007a.C0644i;
import com.applovin.impl.p007a.C0645j;
import com.applovin.impl.p007a.C0647l;
import com.applovin.impl.p007a.C0648m;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.utils.C1310q;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.e.t */
public class C1156t extends C1109a {

    /* renamed from: a */
    public final C0639e f2081a;

    /* renamed from: c */
    public final AppLovinAdLoadListener f2082c;

    public C1156t(C0639e eVar, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
        super("TaskRenderVastAd", mVar);
        this.f2082c = appLovinAdLoadListener;
        this.f2081a = eVar;
    }

    public void run() {
        mo10768a("Rendering VAST ad...");
        int size = this.f2081a.mo9364b().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String str = "";
        C0644i iVar = null;
        C0648m mVar = null;
        C0638d dVar = null;
        C0637c cVar = null;
        String str2 = str;
        for (C1310q next : this.f2081a.mo9364b()) {
            C1310q c = next.mo11352c(C0647l.m156a(next) ? "Wrapper" : "InLine");
            if (c != null) {
                C1310q c2 = c.mo11352c("AdSystem");
                if (c2 != null) {
                    iVar = C0644i.m135a(c2, iVar, this.f1961b);
                }
                str = C0647l.m147a(c, "AdTitle", str);
                str2 = C0647l.m147a(c, "Description", str2);
                C0647l.m152a(c.mo11349a("Impression"), (Set<C0645j>) hashSet, this.f2081a, this.f1961b);
                C1310q b = c.mo11350b("ViewableImpression");
                if (b != null) {
                    C0647l.m152a(b.mo11349a("Viewable"), (Set<C0645j>) hashSet, this.f2081a, this.f1961b);
                }
                C1310q c3 = c.mo11352c("AdVerifications");
                if (c3 != null) {
                    cVar = C0637c.m109a(c3, cVar, this.f2081a, this.f1961b);
                }
                C0647l.m152a(c.mo11349a("Error"), (Set<C0645j>) hashSet2, this.f2081a, this.f1961b);
                C1310q b2 = c.mo11350b("Creatives");
                if (b2 != null) {
                    for (C1310q next2 : b2.mo11354d()) {
                        C1310q b3 = next2.mo11350b("Linear");
                        if (b3 != null) {
                            mVar = C0648m.m162a(b3, mVar, this.f2081a, this.f1961b);
                        } else {
                            C1310q c4 = next2.mo11352c("CompanionAds");
                            if (c4 != null) {
                                C1310q c5 = c4.mo11352c("Companion");
                                if (c5 != null) {
                                    dVar = C0638d.m111a(c5, dVar, this.f2081a, this.f1961b);
                                }
                            } else {
                                mo10773d("Received and will skip rendering for an unidentified creative: " + next2);
                            }
                        }
                    }
                }
            } else {
                mo10773d("Did not find wrapper or inline response for node: " + next);
            }
        }
        C0631a a = new C0631a.C0633a().mo9337a(this.f1961b).mo9340a(this.f2081a.mo9365c()).mo9344b(this.f2081a.mo9366d()).mo9336a(this.f2081a.mo9367e()).mo9331a(this.f2081a.mo9368f()).mo9338a(str).mo9342b(str2).mo9334a(iVar).mo9335a(mVar).mo9333a(dVar).mo9332a(cVar).mo9339a((Set<C0645j>) hashSet).mo9332a(cVar).mo9343b((Set<C0645j>) hashSet2).mo9341a();
        C0640f a2 = C0647l.m143a(a);
        if (a2 == null) {
            mo10768a("Finished rendering VAST ad: " + a);
            a.getAdEventTracker().mo10455b();
            C1119e eVar = new C1119e(a, this.f1961b, this.f2082c);
            C1140o.C1142a aVar = C1140o.C1142a.CACHING_OTHER;
            if (((Boolean) this.f1961b.mo10946a(C1085b.f1636bo)).booleanValue()) {
                if (a.getType() == AppLovinAdType.REGULAR) {
                    aVar = C1140o.C1142a.CACHING_INTERSTITIAL;
                } else if (a.getType() == AppLovinAdType.INCENTIVIZED) {
                    aVar = C1140o.C1142a.CACHING_INCENTIVIZED;
                }
            }
            this.f1961b.mo10938S().mo10829a((C1109a) eVar, aVar);
            return;
        }
        C0647l.m150a(this.f2081a, this.f2082c, a2, -6, this.f1961b);
    }
}
