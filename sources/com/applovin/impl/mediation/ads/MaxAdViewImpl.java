package com.applovin.impl.mediation.ads;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.ads.C0836a;
import com.applovin.impl.mediation.p010a.C0802b;
import com.applovin.impl.mediation.p010a.C0805e;
import com.applovin.impl.mediation.p012c.C0867c;
import com.applovin.impl.sdk.C1041aa;
import com.applovin.impl.sdk.C1042ab;
import com.applovin.impl.sdk.C1090d;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.p029e.C1166z;
import com.applovin.impl.sdk.utils.C1257b;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.C1307p;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.internal.ServerProtocol;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MaxAdViewImpl extends C0836a implements C1042ab.C1045a, C1090d.C1092a {

    /* renamed from: a */
    public final Context f617a;

    /* renamed from: b */
    public final MaxAdView f618b;

    /* renamed from: c */
    public final String f619c = UUID.randomUUID().toString().toLowerCase(Locale.US);

    /* renamed from: d */
    public final View f620d;

    /* renamed from: e */
    public long f621e = RecyclerView.FOREVER_NS;

    /* renamed from: f */
    public C0802b f622f;

    /* renamed from: g */
    public String f623g;

    /* renamed from: h */
    public final C0815a f624h;

    /* renamed from: i */
    public final C0817c f625i;

    /* renamed from: j */
    public final C1090d f626j;

    /* renamed from: k */
    public final C1041aa f627k;

    /* renamed from: l */
    public final C1042ab f628l;

    /* renamed from: m */
    public final Object f629m = new Object();

    /* renamed from: n */
    public C0802b f630n = null;

    /* renamed from: o */
    public boolean f631o;

    /* renamed from: p */
    public boolean f632p;

    /* renamed from: q */
    public boolean f633q;

    /* renamed from: r */
    public boolean f634r;

    /* renamed from: s */
    public boolean f635s = false;

    /* renamed from: t */
    public boolean f636t;

    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$a */
    public class C0815a extends C0816b {
        public C0815a() {
            super();
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            C1267j.m2553a(MaxAdViewImpl.this.adListener, str, maxError, true);
            MaxAdViewImpl.this.m788a(maxError);
        }

        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.f635s) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                C1314v vVar = maxAdViewImpl.logger;
                String str = maxAdViewImpl.tag;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Precache ad with ad unit ID '");
                outline24.append(MaxAdViewImpl.this.adUnitId);
                outline24.append("' loaded after MaxAdView was destroyed. Destroying the ad.");
                vVar.mo11372b(str, outline24.toString());
                MaxAdViewImpl.this.sdk.mo10925E().destroyAd(maxAd);
                return;
            }
            C0802b bVar = (C0802b) maxAd;
            bVar.mo9928d(MaxAdViewImpl.this.f623g);
            bVar.mo9929e(MaxAdViewImpl.this.customPostbackData);
            if (bVar.mo9864x() != null) {
                MaxAdViewImpl.this.m776a(bVar);
                if (bVar.mo9866z()) {
                    long A = bVar.mo9859A();
                    C1314v B = MaxAdViewImpl.this.sdk.mo10922B();
                    String str2 = MaxAdViewImpl.this.tag;
                    B.mo11372b(str2, "Scheduling banner ad refresh " + A + " milliseconds from now for '" + MaxAdViewImpl.this.adUnitId + "'...");
                    MaxAdViewImpl.this.f626j.mo10699a(A);
                    if (MaxAdViewImpl.this.f626j.mo10706f() || MaxAdViewImpl.this.f632p) {
                        MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                        maxAdViewImpl2.logger.mo11372b(maxAdViewImpl2.tag, "Pausing ad refresh for publisher");
                        MaxAdViewImpl.this.f626j.mo10704d();
                    }
                }
                C1267j.m2551a(MaxAdViewImpl.this.adListener, maxAd, true);
                return;
            }
            MaxAdViewImpl.this.sdk.mo10925E().destroyAd(bVar);
            onAdLoadFailed(bVar.getAdUnitId(), new MaxErrorImpl(-5001, "Ad view not fully loaded"));
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$b */
    public abstract class C0816b implements C0836a.C0837a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener {
        public C0816b() {
        }

        public void onAdClicked(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f630n)) {
                C1267j.m2579d(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdCollapsed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f630n)) {
                if (MaxAdViewImpl.this.f630n.mo9860B()) {
                    MaxAdViewImpl.this.startAutoRefresh();
                }
                C1267j.m2587h(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            if (maxAd.equals(MaxAdViewImpl.this.f630n)) {
                C1267j.m2548a(MaxAdViewImpl.this.adListener, maxAd, maxError, true);
            }
        }

        public void onAdDisplayed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f630n)) {
                C1267j.m2571b(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdExpanded(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f630n)) {
                if (MaxAdViewImpl.this.f630n.mo9860B()) {
                    MaxAdViewImpl.this.stopAutoRefresh();
                }
                C1267j.m2585g(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdHidden(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f630n)) {
                C1267j.m2576c(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
            C1267j.m2555a(MaxAdViewImpl.this.revenueListener, maxAd, true);
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$c */
    public class C0817c extends C0816b {
        public C0817c() {
            super();
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
            C1314v vVar = maxAdViewImpl.logger;
            String str2 = maxAdViewImpl.tag;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to precache ad for refresh with error code: ");
            outline24.append(maxError.getCode());
            vVar.mo11372b(str2, outline24.toString());
            MaxAdViewImpl.this.m788a(maxError);
        }

        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.f635s) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                C1314v vVar = maxAdViewImpl.logger;
                String str = maxAdViewImpl.tag;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Ad with ad unit ID '");
                outline24.append(MaxAdViewImpl.this.adUnitId);
                outline24.append("' loaded after MaxAdView was destroyed. Destroying the ad.");
                vVar.mo11372b(str, outline24.toString());
                MaxAdViewImpl.this.sdk.mo10925E().destroyAd(maxAd);
                return;
            }
            MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
            maxAdViewImpl2.logger.mo11372b(maxAdViewImpl2.tag, "Successfully pre-cached ad for refresh");
            MaxAdViewImpl.this.m787a(maxAd);
        }
    }

    public MaxAdViewImpl(String str, MaxAdFormat maxAdFormat, MaxAdView maxAdView, View view, C1188m mVar, Context context) {
        super(str, maxAdFormat, "MaxAdView", mVar);
        if (context != null) {
            this.f617a = context.getApplicationContext();
            this.f618b = maxAdView;
            this.f620d = view;
            this.f624h = new C0815a();
            this.f625i = new C0817c();
            this.f626j = new C1090d(mVar, this);
            this.f627k = new C1041aa(maxAdView, mVar);
            this.f628l = new C1042ab(maxAdView, mVar, this);
            C1314v vVar = this.logger;
            String str2 = this.tag;
            vVar.mo11372b(str2, "Created new MaxAdView (" + this + ")");
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m772a() {
        C0802b bVar;
        MaxAdView maxAdView = this.f618b;
        if (maxAdView != null) {
            C1257b.m2485a(maxAdView, this.f620d);
        }
        this.f628l.mo10509a();
        synchronized (this.f629m) {
            bVar = this.f630n;
        }
        if (bVar != null) {
            this.sdk.mo10973ak().mo11228b(bVar);
            this.sdk.mo10925E().destroyAd(bVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m773a(long j) {
        if (Utils.bitMaskContainsFlag(j, ((Long) this.sdk.mo10946a(C1084a.f1493D)).longValue())) {
            C1314v vVar = this.logger;
            String str = this.tag;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Undesired flags matched - current: ");
            outline24.append(Long.toBinaryString(j));
            outline24.append(", undesired: ");
            outline24.append(Long.toBinaryString(j));
            vVar.mo11372b(str, outline24.toString());
            this.logger.mo11372b(this.tag, "Waiting for refresh timer to manually fire request");
            this.f631o = true;
            return;
        }
        this.logger.mo11372b(this.tag, "No undesired viewability flags matched - scheduling viewability");
        this.f631o = false;
        m790b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m774a(AnimatorListenerAdapter animatorListenerAdapter) {
        C0802b bVar = this.f630n;
        if (bVar == null || bVar.mo9864x() == null || !((Boolean) this.sdk.mo10946a(C1084a.f1543z)).booleanValue()) {
            animatorListenerAdapter.onAnimationEnd((Animator) null);
            return;
        }
        View x = this.f630n.mo9864x();
        x.animate().alpha(0.0f).setDuration(((Long) this.sdk.mo10946a(C1084a.f1542y)).longValue()).setListener(animatorListenerAdapter).start();
    }

    /* renamed from: a */
    private void m775a(View view, C0802b bVar) {
        int v = bVar.mo9862v();
        int w = bVar.mo9863w();
        int i = -1;
        int dpToPx = v == -1 ? -1 : AppLovinSdkUtils.dpToPx(view.getContext(), v);
        if (w != -1) {
            i = AppLovinSdkUtils.dpToPx(view.getContext(), w);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(dpToPx, i);
        } else {
            layoutParams.width = dpToPx;
            layoutParams.height = i;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            this.logger.mo11372b(this.tag, "Pinning ad view to MAX ad view with width: " + dpToPx + " and height: " + i + CodelessMatcher.CURRENT_CLASS_NAME);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            for (int addRule : C1307p.m2632a(this.f618b.getGravity(), 10, 14)) {
                layoutParams2.addRule(addRule);
            }
        }
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m776a(final C0802b bVar) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                final View x = bVar.mo9864x();
                String str = x == null ? "MaxAdView does not have a loaded ad view" : null;
                final MaxAdView c = MaxAdViewImpl.this.f618b;
                if (c == null) {
                    str = "MaxAdView does not have a parent view";
                }
                if (str != null) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.mo11376e(maxAdViewImpl.tag, str);
                    C1267j.m2547a(MaxAdViewImpl.this.adListener, (MaxAd) bVar, (MaxError) new MaxErrorImpl(-1, str));
                    return;
                }
                MaxAdViewImpl.this.m774a((AnimatorListenerAdapter) new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        MaxAdViewImpl.this.m772a();
                        C08112 r4 = C08112.this;
                        MaxAdViewImpl.this.mo9986a(bVar);
                        MaxAdViewImpl.this.sdk.mo10973ak().mo11226a((Object) bVar);
                        if (bVar.mo9893H()) {
                            MaxAdViewImpl.this.f628l.mo10510a((C0805e) bVar);
                        }
                        c.setDescendantFocusability(393216);
                        C08112 r42 = C08112.this;
                        MaxAdViewImpl.this.m778a(bVar, x, c);
                        synchronized (MaxAdViewImpl.this.f629m) {
                            C0802b unused = MaxAdViewImpl.this.f630n = bVar;
                        }
                        MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                        maxAdViewImpl.logger.mo11372b(maxAdViewImpl.tag, "Scheduling impression for ad manually...");
                        MediationServiceImpl E = MaxAdViewImpl.this.sdk.mo10925E();
                        C08112 r0 = C08112.this;
                        E.processRawAdImpressionPostback(bVar, MaxAdViewImpl.this.f624h);
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                            public void run() {
                                long a = MaxAdViewImpl.this.f627k.mo10508a(bVar);
                                if (!bVar.mo9893H()) {
                                    C08112 r2 = C08112.this;
                                    MaxAdViewImpl.this.m777a(bVar, a);
                                }
                                MaxAdViewImpl.this.m773a(a);
                            }
                        }, bVar.mo9865y());
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m777a(C0802b bVar, long j) {
        this.logger.mo11372b(this.tag, "Scheduling viewability impression for ad...");
        this.sdk.mo10925E().processViewabilityAdImpressionPostback(bVar, j, this.f624h);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m778a(C0802b bVar, View view, MaxAdView maxAdView) {
        view.setAlpha(0.0f);
        if (bVar.mo9861C() != RecyclerView.FOREVER_NS) {
            this.f620d.setBackgroundColor((int) bVar.mo9861C());
        } else {
            long j = this.f621e;
            if (j != RecyclerView.FOREVER_NS) {
                this.f620d.setBackgroundColor((int) j);
            } else {
                this.f620d.setBackgroundColor(0);
            }
        }
        maxAdView.addView(view);
        m775a(view, bVar);
        m791b(bVar);
        view.animate().alpha(1.0f).setDuration(((Long) this.sdk.mo10946a(C1084a.f1541x)).longValue()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m786a(final C0836a.C0837a aVar) {
        if (m800f()) {
            C1314v.m2663i(this.tag, "Failed to load new ad - this instance is already destroyed");
        } else {
            AppLovinSdkUtils.runOnUiThread(true, new Runnable() {
                public void run() {
                    if (MaxAdViewImpl.this.f630n != null) {
                        long a = MaxAdViewImpl.this.f627k.mo10508a(MaxAdViewImpl.this.f630n);
                        MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                        maxAdViewImpl.loadRequestBuilder.mo11200a("visible_ad_ad_unit_id", maxAdViewImpl.f630n.getAdUnitId()).mo11200a("viewability_flags", String.valueOf(a));
                    } else {
                        MaxAdViewImpl.this.loadRequestBuilder.mo11203c("visible_ad_ad_unit_id").mo11203c("viewability_flags");
                    }
                    MaxAdViewImpl.this.loadRequestBuilder.mo11200a("viewport_width", String.valueOf(AppLovinSdkUtils.pxToDp(MaxAdViewImpl.this.f618b.getContext(), MaxAdViewImpl.this.f618b.getWidth()))).mo11200a("viewport_height", String.valueOf(AppLovinSdkUtils.pxToDp(MaxAdViewImpl.this.f618b.getContext(), MaxAdViewImpl.this.f618b.getHeight())));
                    MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                    C1314v vVar = maxAdViewImpl2.logger;
                    String str = maxAdViewImpl2.tag;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Loading ");
                    outline24.append(MaxAdViewImpl.this.adFormat.getLabel().toLowerCase(Locale.ENGLISH));
                    outline24.append(" ad for '");
                    outline24.append(MaxAdViewImpl.this.adUnitId);
                    outline24.append("' and notifying ");
                    outline24.append(aVar);
                    outline24.append("...");
                    vVar.mo11372b(str, outline24.toString());
                    MediationServiceImpl E = MaxAdViewImpl.this.sdk.mo10925E();
                    MaxAdViewImpl maxAdViewImpl3 = MaxAdViewImpl.this;
                    String str2 = maxAdViewImpl3.adUnitId;
                    String d = maxAdViewImpl3.f619c;
                    MaxAdViewImpl maxAdViewImpl4 = MaxAdViewImpl.this;
                    E.loadAd(str2, d, maxAdViewImpl4.adFormat, maxAdViewImpl4.localExtraParameters, maxAdViewImpl4.loadRequestBuilder.mo11201a(), MaxAdViewImpl.this.f617a, aVar);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m787a(MaxAd maxAd) {
        this.f634r = false;
        this.sdk.mo10973ak().mo11226a((Object) maxAd);
        if (this.f633q) {
            this.f633q = false;
            C1314v vVar = this.logger;
            String str = this.tag;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rendering precache request ad: ");
            outline24.append(maxAd.getAdUnitId());
            outline24.append("...");
            vVar.mo11372b(str, outline24.toString());
            this.f624h.onAdLoaded(maxAd);
            return;
        }
        this.logger.mo11372b(this.tag, "Saving pre-cache ad...");
        this.f622f = (C0802b) maxAd;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m788a(MaxError maxError) {
        if (this.sdk.mo10980b(C1084a.f1532o).contains(String.valueOf(maxError.getCode()))) {
            C1314v B = this.sdk.mo10922B();
            String str = this.tag;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Ignoring banner ad refresh for error code ");
            outline24.append(maxError.getCode());
            B.mo11372b(str, outline24.toString());
            return;
        }
        this.f631o = true;
        long longValue = ((Long) this.sdk.mo10946a(C1084a.f1531n)).longValue();
        if (longValue >= 0) {
            C1314v B2 = this.sdk.mo10922B();
            String str2 = this.tag;
            B2.mo11372b(str2, "Scheduling failed banner ad refresh " + longValue + " milliseconds from now for '" + this.adUnitId + "'...");
            this.f626j.mo10699a(longValue);
        }
    }

    /* renamed from: b */
    private void m790b() {
        if (m798e()) {
            long longValue = ((Long) this.sdk.mo10946a(C1084a.f1494E)).longValue();
            C1314v vVar = this.logger;
            String str = this.tag;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Scheduling refresh precache request in ");
            outline24.append(TimeUnit.MILLISECONDS.toSeconds(longValue));
            outline24.append(" seconds...");
            vVar.mo11372b(str, outline24.toString());
            this.f634r = true;
            this.sdk.mo10938S().mo10830a(new C1166z(this.sdk, new Runnable() {
                public void run() {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.mo11372b(maxAdViewImpl.tag, "Loading ad for pre-cache request...");
                    MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                    maxAdViewImpl2.m786a((C0836a.C0837a) maxAdViewImpl2.f625i);
                }
            }), C0867c.m935a(this.adFormat), longValue);
        }
    }

    /* renamed from: b */
    private void m791b(C0802b bVar) {
        int height = this.f618b.getHeight();
        int width = this.f618b.getWidth();
        if (height > 0 || width > 0) {
            int pxToDp = AppLovinSdkUtils.pxToDp(this.f617a, height);
            int pxToDp2 = AppLovinSdkUtils.pxToDp(this.f617a, width);
            MaxAdFormat format = bVar.getFormat();
            boolean c = m794c();
            int height2 = (c ? format.getAdaptiveSize(pxToDp2, this.f617a) : format.getSize()).getHeight();
            int width2 = format.getSize().getWidth();
            if (pxToDp < height2 || pxToDp2 < width2) {
                StringBuilder sb = new StringBuilder();
                sb.append("\n**************************************************\n`MaxAdView` size ");
                sb.append(pxToDp2);
                sb.append("x");
                sb.append(pxToDp);
                sb.append(" dp smaller than required ");
                sb.append(c ? "adaptive " : "");
                sb.append("size: ");
                sb.append(width2);
                sb.append("x");
                sb.append(height2);
                sb.append(" dp\n**************************************************\n");
                C1314v.m2662h(AppLovinSdk.TAG, sb.toString());
            }
        }
    }

    /* renamed from: c */
    private boolean m794c() {
        return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(this.loadRequestBuilder.mo11202b("adaptive_banner"));
    }

    /* renamed from: d */
    private void m796d() {
        C1314v vVar = this.logger;
        String str = this.tag;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Refreshing for cached ad: ");
        outline24.append(this.f622f);
        outline24.append("...");
        vVar.mo11372b(str, outline24.toString());
        this.f624h.onAdLoaded(this.f622f);
        this.f622f = null;
    }

    /* renamed from: e */
    private boolean m798e() {
        return ((Long) this.sdk.mo10946a(C1084a.f1494E)).longValue() > 0;
    }

    /* renamed from: f */
    private boolean m800f() {
        boolean z;
        synchronized (this.f629m) {
            z = this.f635s;
        }
        return z;
    }

    public void destroy() {
        m772a();
        if (this.f622f != null) {
            this.sdk.mo10973ak().mo11228b(this.f622f);
            this.sdk.mo10925E().destroyAd(this.f622f);
        }
        synchronized (this.f629m) {
            this.f635s = true;
        }
        this.f626j.mo10703c();
        this.adListener = null;
        this.revenueListener = null;
    }

    public MaxAdFormat getAdFormat() {
        return this.adFormat;
    }

    public String getPlacement() {
        return this.f623g;
    }

    public void loadAd() {
        C1314v vVar = this.logger;
        String str = this.tag;
        vVar.mo11372b(str, "" + this + " Loading ad for " + this.adUnitId + "...");
        boolean z = this.f636t || ((Boolean) this.sdk.mo10946a(C1084a.f1540w)).booleanValue();
        if (!z || this.f626j.mo10706f() || !this.f626j.mo10701a()) {
            if (z) {
                if (this.f622f != null) {
                    this.logger.mo11372b(this.tag, "Rendering cached ad");
                    m796d();
                    return;
                } else if (this.f634r) {
                    this.logger.mo11372b(this.tag, "Waiting for precache ad to load to render");
                    this.f633q = true;
                    return;
                }
            }
            this.logger.mo11372b(this.tag, "Loading ad...");
            m786a((C0836a.C0837a) this.f624h);
            return;
        }
        String str2 = this.tag;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unable to load a new ad. An ad refresh has already been scheduled in ");
        outline24.append(TimeUnit.MILLISECONDS.toSeconds(this.f626j.mo10702b()));
        outline24.append(" seconds.");
        C1314v.m2663i(str2, outline24.toString());
    }

    public void onAdRefresh() {
        String str;
        String str2;
        C1314v vVar;
        this.f633q = false;
        if (this.f622f != null) {
            m796d();
            return;
        }
        if (!m798e()) {
            vVar = this.logger;
            str2 = this.tag;
            str = "Refreshing ad from network...";
        } else if (this.f631o) {
            vVar = this.logger;
            str2 = this.tag;
            str = "Refreshing ad from network due to viewability requirements not met for refresh request...";
        } else {
            this.logger.mo11376e(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
            this.f633q = true;
            return;
        }
        vVar.mo11372b(str2, str);
        loadAd();
    }

    public void onLogVisibilityImpression() {
        m777a(this.f630n, this.f627k.mo10508a(this.f630n));
    }

    public void onWindowVisibilityChanged(int i) {
        if (((Boolean) this.sdk.mo10946a(C1084a.f1536s)).booleanValue() && this.f626j.mo10701a()) {
            if (C1307p.m2630a(i)) {
                this.logger.mo11372b(this.tag, "Ad view visible");
                this.f626j.mo10708h();
                return;
            }
            this.logger.mo11372b(this.tag, "Ad view hidden");
            this.f626j.mo10707g();
        }
    }

    public void setExtraParameter(String str, String str2) {
        if ("allow_pause_auto_refresh_immediately".equalsIgnoreCase(str)) {
            boolean parseBoolean = Boolean.parseBoolean(str2);
            this.f636t = parseBoolean;
            this.f626j.mo10700a(parseBoolean);
            return;
        }
        super.setExtraParameter(str, str2);
    }

    public void setPlacement(String str) {
        if (this.f630n != null) {
            String str2 = this.tag;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Placement for Ad Unit ID (");
            outline24.append(this.adUnitId);
            outline24.append(") was set after load was called. For the ads to be correctly attributed to this placement, please set the placement before loading the ");
            outline24.append(this.adFormat.getLabel());
            outline24.append(CodelessMatcher.CURRENT_CLASS_NAME);
            C1314v.m2663i(str2, outline24.toString());
        }
        this.f623g = str;
    }

    public void setPublisherBackgroundColor(int i) {
        this.f621e = (long) i;
    }

    public void startAutoRefresh() {
        String str;
        String str2;
        C1314v vVar;
        this.f632p = false;
        if (this.f626j.mo10706f()) {
            this.f626j.mo10705e();
            vVar = this.logger;
            str2 = this.tag;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Resumed auto-refresh with remaining time: ");
            outline24.append(this.f626j.mo10702b());
            outline24.append("ms");
            str = outline24.toString();
        } else {
            vVar = this.logger;
            str2 = this.tag;
            str = "Ignoring call to startAutoRefresh() - ad refresh is not paused";
        }
        vVar.mo11372b(str2, str);
    }

    public void stopAutoRefresh() {
        if (this.f630n != null) {
            C1314v vVar = this.logger;
            String str = this.tag;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Pausing auto-refresh with remaining time: ");
            outline24.append(this.f626j.mo10702b());
            outline24.append("ms");
            vVar.mo11372b(str, outline24.toString());
            this.f626j.mo10704d();
        } else if (this.f636t || ((Boolean) this.sdk.mo10946a(C1084a.f1540w)).booleanValue()) {
            this.f632p = true;
        } else {
            C1314v.m2662h(this.tag, "Stopping auto-refresh has no effect until after the first ad has been loaded.");
        }
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("MaxAdView{adUnitId='");
        GeneratedOutlineSupport.outline33(outline24, this.adUnitId, '\'', ", adListener=");
        outline24.append(this.adListener);
        outline24.append(", isDestroyed=");
        outline24.append(m800f());
        outline24.append('}');
        return outline24.toString();
    }
}
