package com.applovin.impl.adview.activity.p009b;

import android.app.Activity;
import android.graphics.PointF;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.C0653a;
import com.applovin.impl.adview.C0754j;
import com.applovin.impl.adview.C0767m;
import com.applovin.impl.adview.C0782t;
import com.applovin.impl.p007a.C0631a;
import com.applovin.impl.p007a.C0640f;
import com.applovin.impl.p007a.C0645j;
import com.applovin.impl.p007a.C0646k;
import com.applovin.impl.p007a.C0647l;
import com.applovin.impl.p007a.C0648m;
import com.applovin.impl.p007a.C0651n;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p024a.C1019d;
import com.applovin.impl.sdk.p024a.C1023g;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import com.vungle.warren.analytics.AnalyticsEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.adview.activity.b.c */
public class C0688c extends C0692e {

    /* renamed from: G */
    public final C0631a f274G;

    /* renamed from: H */
    public final Set<C0645j> f275H = new HashSet();

    public C0688c(C1057e eVar, Activity activity, C1188m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        C0631a aVar = (C0631a) eVar;
        this.f274G = aVar;
        this.f275H.addAll(aVar.mo9299a(C0631a.C0635c.VIDEO, C0646k.f145a));
        m263a(C0631a.C0635c.IMPRESSION);
        m265a(C0631a.C0635c.VIDEO, "creativeView");
        this.f274G.getAdEventTracker().mo10458d();
    }

    /* renamed from: E */
    private void m261E() {
        if (mo9476r() && !this.f275H.isEmpty()) {
            C1314v vVar = this.f225c;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Firing ");
            outline24.append(this.f275H.size());
            outline24.append(" un-fired video progress trackers when video was completed.");
            vVar.mo11375d("AppLovinFullscreenActivity", outline24.toString());
            m268a(this.f275H);
        }
    }

    /* renamed from: a */
    private void m263a(C0631a.C0635c cVar) {
        m264a(cVar, C0640f.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m264a(C0631a.C0635c cVar, C0640f fVar) {
        m266a(cVar, "", fVar);
    }

    /* renamed from: a */
    private void m265a(C0631a.C0635c cVar, String str) {
        m266a(cVar, str, C0640f.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m266a(C0631a.C0635c cVar, String str, C0640f fVar) {
        m269a(this.f274G.mo9298a(cVar, str), fVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m268a(Set<C0645j> set) {
        m269a(set, C0640f.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m269a(Set<C0645j> set, C0640f fVar) {
        if (set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(this.f296u.getCurrentPosition());
            C0651n aJ = this.f274G.mo9302aJ();
            Uri a = aJ != null ? aJ.mo9406a() : null;
            C1314v vVar = this.f225c;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Firing ");
            outline24.append(set.size());
            outline24.append(" tracker(s): ");
            outline24.append(set);
            vVar.mo11372b("AppLovinFullscreenActivity", outline24.toString());
            C0647l.m153a(set, seconds, a, fVar, this.f224b);
        }
    }

    /* renamed from: a */
    public void mo9496a(PointF pointF) {
        m263a(C0631a.C0635c.VIDEO_CLICK);
        this.f274G.getAdEventTracker().mo10490o();
        super.mo9496a(pointF);
    }

    /* renamed from: a */
    public void mo9451a(@Nullable ViewGroup viewGroup) {
        super.mo9451a(viewGroup);
        this.f280A.mo9652a("PROGRESS_TRACKING", ((Long) this.f224b.mo10946a(C1085b.f1790em)).longValue(), (C0754j.C0756a) new C0754j.C0756a() {
            /* renamed from: a */
            public void mo9504a() {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(C0688c.this.f282C - (C0688c.this.f296u.getDuration() - C0688c.this.f296u.getCurrentPosition()));
                int D = C0688c.this.mo9517D();
                HashSet hashSet = new HashSet();
                Iterator it = new HashSet(C0688c.this.f275H).iterator();
                while (it.hasNext()) {
                    C0645j jVar = (C0645j) it.next();
                    if (jVar.mo9390a(seconds, D)) {
                        hashSet.add(jVar);
                        C0688c.this.f275H.remove(jVar);
                    }
                }
                C0688c.this.m268a((Set<C0645j>) hashSet);
                if (D >= 25 && D < 50) {
                    C0688c.this.f274G.getAdEventTracker().mo10481f();
                } else if (D >= 50 && D < 75) {
                    C0688c.this.f274G.getAdEventTracker().mo10482g();
                } else if (D >= 75) {
                    C0688c.this.f274G.getAdEventTracker().mo10483h();
                }
            }

            /* renamed from: b */
            public boolean mo9505b() {
                return !C0688c.this.f284E;
            }
        });
        ArrayList arrayList = new ArrayList();
        C0653a aVar = this.f297v;
        if (aVar != null) {
            arrayList.add(new C1019d(aVar, FriendlyObstructionPurpose.OTHER, "video stream buffering indicator"));
        }
        C0767m mVar = this.f298w;
        if (mVar != null) {
            arrayList.add(new C1019d(mVar, FriendlyObstructionPurpose.CLOSE_AD, "skip button"));
        }
        ProgressBar progressBar = this.f301z;
        if (progressBar != null) {
            arrayList.add(new C1019d(progressBar, FriendlyObstructionPurpose.OTHER, "progress bar"));
        }
        ImageView imageView = this.f299x;
        if (imageView != null) {
            arrayList.add(new C1019d(imageView, FriendlyObstructionPurpose.VIDEO_CONTROLS, "mute button"));
        }
        C0782t tVar = this.f300y;
        if (tVar != null) {
            arrayList.add(new C1019d(tVar, FriendlyObstructionPurpose.VIDEO_CONTROLS, "generic webview overlay containing HTML controls"));
        }
        this.f274G.getAdEventTracker().mo10451a((View) this.f295t, (List<C1019d>) arrayList);
    }

    /* renamed from: c */
    public void mo9497c() {
        m265a(C0631a.C0635c.VIDEO, "skip");
        this.f274G.getAdEventTracker().mo10489n();
        super.mo9497c();
    }

    /* renamed from: c */
    public void mo9498c(long j) {
        super.mo9498c(j);
        this.f274G.getAdEventTracker().mo10479a((float) TimeUnit.MILLISECONDS.toSeconds(j), Utils.isVideoMutedInitially(this.f224b));
    }

    /* renamed from: c */
    public void mo9499c(String str) {
        m264a(C0631a.C0635c.ERROR, C0640f.MEDIA_FILE_ERROR);
        this.f274G.getAdEventTracker().mo10453a(str);
        super.mo9499c(str);
    }

    /* renamed from: d */
    public void mo9462d() {
        mo9451a((ViewGroup) null);
    }

    /* renamed from: e */
    public void mo9463e() {
        this.f280A.mo9654c();
        super.mo9463e();
    }

    /* renamed from: f */
    public void mo9464f() {
        super.mo9464f();
        m265a(this.f284E ? C0631a.C0635c.COMPANION : C0631a.C0635c.VIDEO, "resume");
        this.f274G.getAdEventTracker().mo10486k();
    }

    /* renamed from: g */
    public void mo9465g() {
        super.mo9465g();
        m265a(this.f284E ? C0631a.C0635c.COMPANION : C0631a.C0635c.VIDEO, "pause");
        this.f274G.getAdEventTracker().mo10485j();
    }

    /* renamed from: h */
    public void mo9466h() {
        m265a(C0631a.C0635c.VIDEO, "close");
        m265a(C0631a.C0635c.COMPANION, "close");
        this.f274G.getAdEventTracker().mo10459e();
        super.mo9466h();
    }

    /* renamed from: u */
    public void mo9479u() {
        long j;
        int q;
        long j2 = 0;
        if (this.f274G.mo10579Y() >= 0 || this.f274G.mo10580Z() >= 0) {
            int i = (this.f274G.mo10579Y() > 0 ? 1 : (this.f274G.mo10579Y() == 0 ? 0 : -1));
            C0631a aVar = this.f274G;
            if (i >= 0) {
                j = aVar.mo10579Y();
            } else {
                C0648m m = aVar.mo9329m();
                if (m == null || m.mo9397b() <= 0) {
                    long j3 = this.f282C;
                    if (j3 > 0) {
                        j2 = 0 + j3;
                    }
                } else {
                    j2 = 0 + TimeUnit.SECONDS.toMillis((long) m.mo9397b());
                }
                if (aVar.mo10595aa() && (q = (int) aVar.mo10627q()) > 0) {
                    j2 += TimeUnit.SECONDS.toMillis((long) q);
                }
                double d = (double) j2;
                double Z = (double) this.f274G.mo10580Z();
                Double.isNaN(Z);
                Double.isNaN(d);
                j = (long) ((Z / 100.0d) * d);
            }
            mo9458b(j);
        }
    }

    /* renamed from: v */
    public void mo9500v() {
        super.mo9500v();
        C0631a aVar = this.f274G;
        if (aVar != null) {
            aVar.getAdEventTracker().mo10487l();
        }
    }

    /* renamed from: w */
    public void mo9501w() {
        super.mo9501w();
        C0631a aVar = this.f274G;
        if (aVar != null) {
            aVar.getAdEventTracker().mo10488m();
        }
    }

    /* renamed from: x */
    public void mo9502x() {
        super.mo9502x();
        m265a(C0631a.C0635c.VIDEO, this.f281B ? AnalyticsEvent.C1956Ad.mute : AnalyticsEvent.C1956Ad.unmute);
        this.f274G.getAdEventTracker().mo10480a(this.f281B);
    }

    /* renamed from: y */
    public void mo9503y() {
        m261E();
        if (!C0647l.m160c(this.f274G)) {
            this.f225c.mo11372b("AppLovinFullscreenActivity", "VAST ad does not have valid companion ad - dismissing...");
            mo9466h();
        } else if (!this.f284E) {
            m265a(C0631a.C0635c.COMPANION, "creativeView");
            this.f274G.getAdEventTracker().mo10484i();
            C1023g d = this.f274G.getAdEventTracker();
            AppLovinAdView appLovinAdView = this.f228f;
            d.mo10451a((View) appLovinAdView, (List<C1019d>) Collections.singletonList(new C1019d(appLovinAdView, FriendlyObstructionPurpose.CLOSE_AD, "close button")));
            super.mo9503y();
        }
    }
}
