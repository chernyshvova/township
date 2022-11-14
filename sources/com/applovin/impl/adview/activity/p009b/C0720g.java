package com.applovin.impl.adview.activity.p009b;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.StrictMode;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.adview.C0653a;
import com.applovin.impl.adview.C0750g;
import com.applovin.impl.adview.C0767m;
import com.applovin.impl.adview.activity.p008a.C0668d;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p025ad.C1052a;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.p029e.C1166z;
import com.applovin.impl.sdk.utils.C1263g;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.C1368R;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.activity.b.g */
public class C0720g extends C0670a implements C0750g {

    /* renamed from: A */
    public AtomicBoolean f355A = new AtomicBoolean();

    /* renamed from: B */
    public AtomicBoolean f356B = new AtomicBoolean();

    /* renamed from: C */
    public boolean f357C = Utils.isVideoMutedInitially(this.f224b);

    /* renamed from: D */
    public long f358D = -2;

    /* renamed from: E */
    public long f359E = 0;

    /* renamed from: t */
    public final C0668d f360t = new C0668d(this.f223a, this.f227e, this.f224b);
    @Nullable

    /* renamed from: u */
    public final C0767m f361u;
    @Nullable

    /* renamed from: v */
    public final ImageView f362v;
    @Nullable

    /* renamed from: w */
    public final C0653a f363w;

    /* renamed from: x */
    public final boolean f364x = this.f223a.mo9314e();

    /* renamed from: y */
    public double f365y;

    /* renamed from: z */
    public double f366z;

    /* renamed from: com.applovin.impl.adview.activity.b.g$a */
    public class C0724a implements View.OnClickListener {
        public C0724a() {
        }

        public void onClick(View view) {
            if (view == C0720g.this.f361u) {
                if (C0720g.this.mo9477s()) {
                    C0720g.this.mo9474p();
                    C0720g.this.f239q.mo10658b();
                    return;
                }
                C0720g.this.mo9556v();
            } else if (view == C0720g.this.f362v) {
                C0720g.this.mo9558x();
            } else {
                C1314v vVar = C0720g.this.f225c;
                vVar.mo11376e("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    public C0720g(C1057e eVar, Activity activity, C1188m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        C0724a aVar = new C0724a();
        if (eVar.mo10625o() >= 0) {
            C0767m mVar2 = new C0767m(eVar.mo10631u(), activity);
            this.f361u = mVar2;
            mVar2.setVisibility(8);
            this.f361u.setOnClickListener(aVar);
        } else {
            this.f361u = null;
        }
        if (m394a(this.f357C, mVar)) {
            ImageView imageView = new ImageView(activity);
            this.f362v = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f362v.setClickable(true);
            this.f362v.setOnClickListener(aVar);
            m398d(this.f357C);
        } else {
            this.f362v = null;
        }
        if (this.f364x) {
            C0653a aVar2 = new C0653a(activity, ((Integer) mVar.mo10946a(C1085b.f1654cG)).intValue(), 16842874);
            this.f363w = aVar2;
            aVar2.setColor(Color.parseColor("#75FFFFFF"));
            this.f363w.setBackgroundColor(Color.parseColor("#00000000"));
            this.f363w.setVisibility(8);
            return;
        }
        this.f363w = null;
    }

    /* renamed from: a */
    public static boolean m394a(boolean z, C1188m mVar) {
        if (!((Boolean) mVar.mo10946a(C1085b.f1695cv)).booleanValue()) {
            return false;
        }
        if (!((Boolean) mVar.mo10946a(C1085b.f1696cw)).booleanValue() || z) {
            return true;
        }
        return ((Boolean) mVar.mo10946a(C1085b.f1698cy)).booleanValue();
    }

    /* renamed from: d */
    private void m398d(boolean z) {
        if (C1263g.m2508d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f227e.getDrawable(z ? C1368R.C1369drawable.unmute_to_mute : C1368R.C1369drawable.mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.f362v.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f362v.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri ay = z ? this.f223a.mo10618ay() : this.f223a.mo10619az();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f362v.setImageURI(ay);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m399y() {
        if (this.f356B.compareAndSet(false, true)) {
            mo9452a(this.f361u, this.f223a.mo10625o(), new Runnable() {
                public void run() {
                    long unused = C0720g.this.f358D = -1;
                    long unused2 = C0720g.this.f359E = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    /* renamed from: a */
    public void mo9492a() {
        this.f225c.mo11372b("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
    }

    /* renamed from: a */
    public void mo9551a(double d) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("javascript:al_setVideoMuted(");
        outline24.append(this.f357C);
        outline24.append(");");
        mo9459b(outline24.toString());
        C0653a aVar = this.f363w;
        if (aVar != null) {
            aVar.mo9423b();
        }
        if (this.f361u != null) {
            m399y();
        }
        this.f228f.getController().mo9590m();
        this.f366z = d;
        mo9479u();
        if (this.f223a.mo10603ai()) {
            this.f239q.mo10656a(this.f223a, (Runnable) null);
        }
    }

    /* renamed from: a */
    public void mo9449a(long j) {
    }

    /* renamed from: a */
    public void mo9451a(@Nullable ViewGroup viewGroup) {
        this.f360t.mo9445a(this.f362v, this.f361u, this.f229g, this.f363w, this.f228f, viewGroup);
        this.f228f.getController().mo9569a((C0750g) this);
        mo9456a(false);
        C0653a aVar = this.f363w;
        if (aVar != null) {
            aVar.mo9422a();
        }
        this.f228f.renderAd(this.f223a);
        if (this.f361u != null) {
            this.f224b.mo10938S().mo10831a((C1109a) new C1166z(this.f224b, new Runnable() {
                public void run() {
                    C0720g.this.m399y();
                }
            }), C1140o.C1142a.MAIN, this.f223a.mo10626p(), true);
        }
        super.mo9460b(this.f357C);
    }

    /* renamed from: a_ */
    public void mo9552a_() {
        mo9557w();
    }

    /* renamed from: b */
    public void mo9493b() {
        this.f225c.mo11372b("AppLovinFullscreenActivity", "Skipping video from prompt");
        mo9556v();
    }

    /* renamed from: b */
    public void mo9553b(double d) {
        this.f365y = d;
    }

    /* renamed from: b_ */
    public void mo9554b_() {
        C0653a aVar = this.f363w;
        if (aVar != null) {
            aVar.mo9422a();
        }
    }

    /* renamed from: c */
    public void mo9555c() {
        C0653a aVar = this.f363w;
        if (aVar != null) {
            aVar.mo9423b();
        }
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
        super.mo9466h();
    }

    /* renamed from: m */
    public void mo9471m() {
        super.mo9448a((int) this.f365y, this.f364x, mo9476r(), this.f358D);
    }

    /* renamed from: r */
    public boolean mo9476r() {
        return this.f365y >= ((double) this.f223a.mo10566L());
    }

    /* renamed from: s */
    public boolean mo9477s() {
        return mo9478t() && !mo9476r();
    }

    /* renamed from: u */
    public void mo9479u() {
        long j;
        int k;
        long j2 = 0;
        if (this.f223a.mo10579Y() >= 0 || this.f223a.mo10580Z() >= 0) {
            int i = (this.f223a.mo10579Y() > 0 ? 1 : (this.f223a.mo10579Y() == 0 ? 0 : -1));
            C1057e eVar = this.f223a;
            if (i >= 0) {
                j = eVar.mo10579Y();
            } else {
                C1052a aVar = (C1052a) eVar;
                double d = this.f366z;
                if (d > RoundRectDrawableWithShadow.COS_45) {
                    j2 = 0 + TimeUnit.SECONDS.toMillis((long) d);
                }
                if (aVar.mo10595aa() && ((k = (int) ((C1052a) this.f223a).mo10536k()) > 0 || (k = (int) aVar.mo10627q()) > 0)) {
                    j2 += TimeUnit.SECONDS.toMillis((long) k);
                }
                double d2 = (double) j2;
                double Z = (double) this.f223a.mo10580Z();
                Double.isNaN(Z);
                Double.isNaN(d2);
                j = (long) ((Z / 100.0d) * d2);
            }
            mo9458b(j);
        }
    }

    /* renamed from: v */
    public void mo9556v() {
        this.f358D = SystemClock.elapsedRealtime() - this.f359E;
        C1314v vVar = this.f225c;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Skipping video with skip time: ");
        outline24.append(this.f358D);
        outline24.append("ms");
        vVar.mo11372b("AppLovinFullscreenActivity", outline24.toString());
        this.f226d.mo10739f();
        this.f232j++;
        if (this.f223a.mo10632v()) {
            mo9466h();
        } else {
            mo9557w();
        }
    }

    /* renamed from: w */
    public void mo9557w() {
        if (this.f355A.compareAndSet(false, true)) {
            this.f225c.mo11372b("AppLovinFullscreenActivity", "Showing postitial...");
            mo9459b("javascript:al_showPostitial();");
            C0767m mVar = this.f361u;
            if (mVar != null) {
                mVar.setVisibility(8);
            }
            ImageView imageView = this.f362v;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            C0653a aVar = this.f363w;
            if (aVar != null) {
                aVar.mo9423b();
            }
            if (this.f229g != null) {
                if (this.f223a.mo10627q() >= 0) {
                    mo9452a(this.f229g, this.f223a.mo10627q(), new Runnable() {
                        public void run() {
                            C0720g.this.f231i = SystemClock.elapsedRealtime();
                        }
                    });
                } else {
                    this.f229g.setVisibility(0);
                }
            }
            this.f228f.getController().mo9591n();
        }
    }

    /* renamed from: x */
    public void mo9558x() {
        this.f357C = !this.f357C;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("javascript:al_setVideoMuted(");
        outline24.append(this.f357C);
        outline24.append(");");
        mo9459b(outline24.toString());
        m398d(this.f357C);
        mo9457a(this.f357C, 0);
    }
}
