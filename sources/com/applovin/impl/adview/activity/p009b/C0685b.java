package com.applovin.impl.adview.activity.p009b;

import android.app.Activity;
import android.os.SystemClock;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.adview.activity.p008a.C0663b;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p025ad.C1052a;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.utils.C1260e;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.activity.b.b */
public class C0685b extends C0670a {

    /* renamed from: t */
    public final C0663b f268t = new C0663b(this.f223a, this.f227e, this.f224b);

    /* renamed from: u */
    public C1260e f269u;

    /* renamed from: v */
    public long f270v;

    /* renamed from: w */
    public AtomicBoolean f271w = new AtomicBoolean();

    public C0685b(C1057e eVar, Activity activity, C1188m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
    }

    /* renamed from: c */
    private long m249c() {
        C1057e eVar = this.f223a;
        if (!(eVar instanceof C1052a)) {
            return 0;
        }
        float k = ((C1052a) eVar).mo10536k();
        if (k <= 0.0f) {
            k = (float) this.f223a.mo10627q();
        }
        double secondsToMillisLong = (double) Utils.secondsToMillisLong(k);
        double M = (double) this.f223a.mo10567M();
        Double.isNaN(M);
        Double.isNaN(secondsToMillisLong);
        return (long) ((M / 100.0d) * secondsToMillisLong);
    }

    /* renamed from: a */
    public void mo9492a() {
    }

    /* renamed from: a */
    public void mo9449a(long j) {
    }

    /* renamed from: a */
    public void mo9451a(@Nullable ViewGroup viewGroup) {
        this.f268t.mo9439a(this.f229g, this.f228f, viewGroup);
        mo9456a(false);
        this.f228f.renderAd(this.f223a);
        mo9455a("javascript:al_onPoststitialShow();", (long) this.f223a.mo10568N());
        if (mo9478t()) {
            long c = m249c();
            this.f270v = c;
            if (c > 0) {
                C1314v vVar = this.f225c;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Scheduling timer for ad fully watched in ");
                outline24.append(this.f270v);
                outline24.append("ms...");
                vVar.mo11372b("AppLovinFullscreenActivity", outline24.toString());
                this.f269u = C1260e.m2499a(this.f270v, this.f224b, new Runnable() {
                    public void run() {
                        C0685b.this.f225c.mo11372b("AppLovinFullscreenActivity", "Marking ad as fully watched");
                        C0685b.this.f271w.set(true);
                    }
                });
            }
        }
        if (this.f229g != null) {
            if (this.f223a.mo10627q() >= 0) {
                mo9452a(this.f229g, this.f223a.mo10627q(), new Runnable() {
                    public void run() {
                        C0685b.this.f231i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                this.f229g.setVisibility(0);
            }
        }
        mo9479u();
        super.mo9460b(Utils.isVideoMutedInitially(this.f224b));
    }

    /* renamed from: b */
    public void mo9493b() {
    }

    /* renamed from: d */
    public void mo9462d() {
        mo9451a((ViewGroup) null);
    }

    /* renamed from: e */
    public void mo9463e() {
    }

    /* renamed from: h */
    public void mo9466h() {
        mo9471m();
        C1260e eVar = this.f269u;
        if (eVar != null) {
            eVar.mo11276a();
            this.f269u = null;
        }
        super.mo9466h();
    }

    /* renamed from: m */
    public void mo9471m() {
        C1260e eVar;
        boolean r = mo9476r();
        int i = 100;
        if (mo9478t()) {
            if (!r && (eVar = this.f269u) != null) {
                double b = (double) (this.f270v - eVar.mo11277b());
                double d = (double) this.f270v;
                Double.isNaN(b);
                Double.isNaN(d);
                i = (int) Math.min(100.0d, (b / d) * 100.0d);
            }
            C1314v vVar = this.f225c;
            vVar.mo11372b("AppLovinFullscreenActivity", "Ad engaged at " + i + "%");
        }
        super.mo9448a(i, false, r, -2);
    }

    /* renamed from: r */
    public boolean mo9476r() {
        if (mo9478t()) {
            return this.f271w.get();
        }
        return true;
    }

    /* renamed from: s */
    public boolean mo9477s() {
        return false;
    }

    /* renamed from: u */
    public void mo9479u() {
        long j;
        long millis;
        long j2 = 0;
        if (this.f223a.mo10579Y() >= 0 || this.f223a.mo10580Z() >= 0) {
            int i = (this.f223a.mo10579Y() > 0 ? 1 : (this.f223a.mo10579Y() == 0 ? 0 : -1));
            C1057e eVar = this.f223a;
            if (i >= 0) {
                j = eVar.mo10579Y();
            } else {
                if (eVar.mo10595aa()) {
                    int k = (int) ((C1052a) this.f223a).mo10536k();
                    if (k > 0) {
                        millis = TimeUnit.SECONDS.toMillis((long) k);
                    } else {
                        int q = (int) this.f223a.mo10627q();
                        if (q > 0) {
                            millis = TimeUnit.SECONDS.toMillis((long) q);
                        }
                    }
                    j2 = 0 + millis;
                }
                double d = (double) j2;
                double Z = (double) this.f223a.mo10580Z();
                Double.isNaN(Z);
                Double.isNaN(d);
                j = (long) ((Z / 100.0d) * d);
            }
            mo9458b(j);
        }
    }
}
