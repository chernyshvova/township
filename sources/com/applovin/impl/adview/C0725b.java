package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.network.C1231i;
import com.applovin.impl.sdk.p025ad.C1052a;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p028d.C1101d;
import com.applovin.impl.sdk.p028d.C1103f;
import com.applovin.impl.sdk.utils.C1257b;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.C1301k;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.applovin.impl.adview.b */
public class C0725b implements AppLovinCommunicatorSubscriber {

    /* renamed from: A */
    public volatile AppLovinAdViewEventListener f371A;

    /* renamed from: B */
    public volatile AppLovinAdClickListener f372B;

    /* renamed from: C */
    public volatile C0750g f373C = null;

    /* renamed from: a */
    public Context f374a;

    /* renamed from: b */
    public ViewGroup f375b;

    /* renamed from: c */
    public C1188m f376c;

    /* renamed from: d */
    public AppLovinAdServiceImpl f377d;

    /* renamed from: e */
    public C1314v f378e;

    /* renamed from: f */
    public AppLovinCommunicator f379f;

    /* renamed from: g */
    public AppLovinAdSize f380g;

    /* renamed from: h */
    public String f381h;

    /* renamed from: i */
    public C1101d f382i;

    /* renamed from: j */
    public C0746e f383j;

    /* renamed from: k */
    public C0738c f384k;

    /* renamed from: l */
    public C0740d f385l;

    /* renamed from: m */
    public Runnable f386m;

    /* renamed from: n */
    public Runnable f387n;

    /* renamed from: o */
    public C1231i.C1233a f388o;

    /* renamed from: p */
    public volatile C1057e f389p = null;

    /* renamed from: q */
    public volatile AppLovinAd f390q = null;

    /* renamed from: r */
    public C0759l f391r = null;

    /* renamed from: s */
    public C0759l f392s = null;

    /* renamed from: t */
    public final AtomicReference<AppLovinAd> f393t = new AtomicReference<>();

    /* renamed from: u */
    public final AtomicBoolean f394u = new AtomicBoolean();

    /* renamed from: v */
    public volatile boolean f395v = false;

    /* renamed from: w */
    public volatile boolean f396w = false;

    /* renamed from: x */
    public volatile boolean f397x = false;

    /* renamed from: y */
    public volatile AppLovinAdLoadListener f398y;

    /* renamed from: z */
    public volatile AppLovinAdDisplayListener f399z;

    /* renamed from: com.applovin.impl.adview.b$a */
    public class C0736a implements Runnable {
        public C0736a() {
        }

        public void run() {
            if (C0725b.this.f385l != null) {
                C0725b.this.f385l.setVisibility(8);
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.b$b */
    public class C0737b implements Runnable {
        public C0737b() {
        }

        public void run() {
            if (C0725b.this.f389p == null) {
                return;
            }
            if (C0725b.this.f385l != null) {
                C0725b.this.m448x();
                C1314v c = C0725b.this.f378e;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rendering advertisement ad for #");
                outline24.append(C0725b.this.f389p.getAdIdNumber());
                outline24.append("...");
                c.mo11372b("AppLovinAdView", outline24.toString());
                C0725b.m427b((View) C0725b.this.f385l, C0725b.this.f389p.getSize());
                C0725b.this.f385l.mo9614a(C0725b.this.f389p);
                if (C0725b.this.f389p.getSize() != AppLovinAdSize.INTERSTITIAL && !C0725b.this.f396w) {
                    C0725b bVar = C0725b.this;
                    C1101d unused = bVar.f382i = new C1101d(bVar.f389p, C0725b.this.f376c);
                    C0725b.this.f382i.mo10730a();
                    C0725b.this.f385l.setStatsManagerHelper(C0725b.this.f382i);
                    C0725b.this.f389p.setHasShown(true);
                }
                if (C0725b.this.f385l.getStatsManagerHelper() != null) {
                    C0725b.this.f385l.getStatsManagerHelper().mo10731a(C0725b.this.f389p.mo10634x() ? 0 : 1);
                    return;
                }
                return;
            }
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Unable to render advertisement for ad #");
            outline242.append(C0725b.this.f389p.getAdIdNumber());
            outline242.append(". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
            C1314v.m2663i("AppLovinAdView", outline242.toString());
            C1267j.m2543a(C0725b.this.f371A, (AppLovinAd) C0725b.this.f389p, (AppLovinAdView) null, AppLovinAdViewDisplayErrorCode.WEBVIEW_NOT_FOUND);
        }
    }

    /* renamed from: com.applovin.impl.adview.b$c */
    public static class C0738c implements AppLovinAdLoadListener {

        /* renamed from: a */
        public final C0725b f416a;

        public C0738c(C0725b bVar, C1188m mVar) {
            if (bVar == null) {
                throw new IllegalArgumentException("No view specified");
            } else if (mVar != null) {
                this.f416a = bVar;
            } else {
                throw new IllegalArgumentException("No sdk specified");
            }
        }

        /* renamed from: a */
        private C0725b m483a() {
            return this.f416a;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            C0725b a = m483a();
            if (a != null) {
                a.mo9579b(appLovinAd);
            } else {
                C1314v.m2663i("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
            }
        }

        public void failedToReceiveAd(int i) {
            C0725b a = m483a();
            if (a != null) {
                a.mo9564a(i);
            }
        }
    }

    /* renamed from: a */
    private void m423a(AppLovinAdView appLovinAdView, C1188m mVar, AppLovinAdSize appLovinAdSize, String str, Context context) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (mVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (appLovinAdSize != null) {
            this.f376c = mVar;
            this.f377d = mVar.mo11005u();
            this.f378e = mVar.mo10922B();
            this.f379f = AppLovinCommunicator.getInstance(context);
            this.f380g = appLovinAdSize;
            this.f381h = str;
            this.f374a = context;
            this.f375b = appLovinAdView;
            this.f383j = new C0746e(this, mVar);
            this.f387n = new C0736a();
            this.f386m = new C0737b();
            this.f384k = new C0738c(this, mVar);
            this.f388o = new C1231i.C1233a();
            mo9577a(appLovinAdSize);
        } else {
            throw new IllegalArgumentException("No ad size specified");
        }
    }

    /* renamed from: a */
    private void m424a(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(runnable);
    }

    /* renamed from: b */
    public static void m427b(View view, AppLovinAdSize appLovinAdSize) {
        if (view != null) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            int i = -1;
            int applyDimension = appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()) ? -1 : appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getWidth(), displayMetrics);
            if (!appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel())) {
                i = appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getHeight(), displayMetrics);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.width = applyDimension;
            layoutParams.height = i;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(10);
                layoutParams2.addRule(9);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: t */
    private void m444t() {
        C1314v vVar = this.f378e;
        if (vVar != null) {
            vVar.mo11372b("AppLovinAdView", "Destroying...");
        }
        C0740d dVar = this.f385l;
        if (dVar != null) {
            ViewParent parent = dVar.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f385l);
            }
            this.f385l.removeAllViews();
            this.f385l.loadUrl("about:blank");
            this.f385l.onPause();
            this.f385l.destroyDrawingCache();
            this.f385l.destroy();
            this.f385l = null;
            this.f376c.mo10973ak().mo11228b(this.f389p);
        }
        this.f396w = true;
    }

    /* renamed from: u */
    private void m445u() {
        m424a((Runnable) new Runnable() {
            public void run() {
                if (C0725b.this.f391r != null) {
                    C1314v c = C0725b.this.f378e;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Detaching expanded ad: ");
                    outline24.append(C0725b.this.f391r.mo9659a());
                    c.mo11372b("AppLovinAdView", outline24.toString());
                    C0725b bVar = C0725b.this;
                    C0759l unused = bVar.f392s = bVar.f391r;
                    C0759l unused2 = C0725b.this.f391r = null;
                    C0725b bVar2 = C0725b.this;
                    bVar2.mo9577a(bVar2.f380g);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m446v() {
        m424a((Runnable) new Runnable() {
            public void run() {
                C1052a aVar;
                if (C0725b.this.f392s != null || C0725b.this.f391r != null) {
                    if (C0725b.this.f392s != null) {
                        aVar = C0725b.this.f392s.mo9659a();
                        C0725b.this.f392s.dismiss();
                        C0759l unused = C0725b.this.f392s = null;
                    } else {
                        aVar = C0725b.this.f391r.mo9659a();
                        C0725b.this.f391r.dismiss();
                        C0759l unused2 = C0725b.this.f391r = null;
                    }
                    C1267j.m2569b(C0725b.this.f371A, (AppLovinAd) aVar, (AppLovinAdView) C0725b.this.f375b);
                }
            }
        });
    }

    /* renamed from: w */
    private void m447w() {
        C1101d dVar = this.f382i;
        if (dVar != null) {
            dVar.mo10734c();
            this.f382i = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m448x() {
        C1057e eVar = this.f389p;
        C1301k kVar = new C1301k();
        kVar.mo11316a().mo11320a(eVar).mo11318a(mo9595r());
        if (!Utils.isBML(eVar.getSize())) {
            kVar.mo11316a().mo11322a("Fullscreen Ad Properties").mo11325b(eVar);
        }
        kVar.mo11321a(this.f376c);
        kVar.mo11316a();
        C1314v.m2660f("AppLovinAdView", kVar.toString());
    }

    /* renamed from: a */
    public void mo9563a() {
        if (this.f376c == null || this.f384k == null || this.f374a == null || !this.f395v) {
            C1314v.m2661g("AppLovinAdView", "Unable to load next ad: AppLovinAdView is not initialized.");
            return;
        }
        C0740d dVar = this.f385l;
        if (dVar != null) {
            this.f388o.mo11200a("viewport_width", String.valueOf(AppLovinSdkUtils.pxToDp(this.f374a, dVar.getWidth()))).mo11200a("viewport_height", String.valueOf(AppLovinSdkUtils.pxToDp(this.f374a, this.f385l.getHeight())));
        }
        this.f377d.loadNextAd(this.f381h, this.f380g, this.f388o.mo11201a(), this.f384k);
    }

    /* renamed from: a */
    public void mo9564a(final int i) {
        if (!this.f396w) {
            m424a(this.f387n);
        }
        m424a((Runnable) new Runnable() {
            public void run() {
                try {
                    if (C0725b.this.f398y != null) {
                        C0725b.this.f398y.failedToReceiveAd(i);
                    }
                } catch (Throwable th) {
                    C1314v.m2659c("AppLovinAdView", "Exception while running app load  callback", th);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo9565a(final PointF pointF) {
        m424a((Runnable) new Runnable() {
            public void run() {
                if (C0725b.this.f391r == null && (C0725b.this.f389p instanceof C1052a) && C0725b.this.f385l != null) {
                    C1052a aVar = (C1052a) C0725b.this.f389p;
                    Activity retrieveParentActivity = C0725b.this.f374a instanceof Activity ? (Activity) C0725b.this.f374a : Utils.retrieveParentActivity(C0725b.this.f385l, C0725b.this.f376c);
                    if (retrieveParentActivity != null) {
                        if (C0725b.this.f375b != null) {
                            C0725b.this.f375b.removeView(C0725b.this.f385l);
                        }
                        C0759l unused = C0725b.this.f391r = new C0759l(aVar, C0725b.this.f385l, retrieveParentActivity, C0725b.this.f376c);
                        C0725b.this.f391r.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            public void onDismiss(DialogInterface dialogInterface) {
                                C0725b.this.mo9588k();
                            }
                        });
                        C0725b.this.f391r.show();
                        C1267j.m2542a(C0725b.this.f371A, (AppLovinAd) C0725b.this.f389p, (AppLovinAdView) C0725b.this.f375b);
                        if (C0725b.this.f382i != null) {
                            C0725b.this.f382i.mo10736d();
                        }
                        if (C0725b.this.f389p.isOpenMeasurementEnabled()) {
                            C0725b.this.f389p.getAdEventTracker().mo10450a((View) C0725b.this.f391r.mo9660b());
                            return;
                        }
                        return;
                    }
                    C1314v.m2663i("AppLovinAdView", "Unable to expand ad. No Activity found.");
                    Uri i = aVar.mo9324i();
                    if (i != null) {
                        AppLovinAdServiceImpl l = C0725b.this.f377d;
                        AppLovinAdView r = C0725b.this.mo9595r();
                        C0725b bVar = C0725b.this;
                        l.trackAndLaunchClick(aVar, r, bVar, i, pointF, bVar.f397x);
                        if (C0725b.this.f382i != null) {
                            C0725b.this.f382i.mo10732b();
                        }
                    }
                    C0725b.this.f385l.mo9615a("javascript:al_onFailedExpand();");
                }
            }
        });
    }

    /* renamed from: a */
    public void mo9566a(final WebView webView) {
        m424a((Runnable) new Runnable() {
            public void run() {
                webView.setVisibility(0);
            }
        });
        try {
            if (this.f389p != this.f390q && this.f399z != null) {
                this.f390q = this.f389p;
                C1267j.m2560a(this.f399z, (AppLovinAd) this.f389p);
                this.f376c.mo10973ak().mo11226a((Object) this.f389p);
                this.f385l.mo9615a("javascript:al_onAdViewRendered();");
            }
        } catch (Throwable th) {
            C1314v.m2659c("AppLovinAdView", "Exception while notifying ad display listener", th);
        }
    }

    /* renamed from: a */
    public void mo9567a(AppLovinAdView appLovinAdView, Context context, AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (context == null) {
            C1314v.m2663i("AppLovinAdView", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
        } else {
            if (appLovinAdSize == null && (appLovinAdSize = C1257b.m2484a(attributeSet)) == null) {
                appLovinAdSize = AppLovinAdSize.BANNER;
            }
            AppLovinAdSize appLovinAdSize2 = appLovinAdSize;
            if (appLovinSdk == null) {
                appLovinSdk = AppLovinSdk.getInstance(context);
            }
            if (appLovinSdk != null && !appLovinSdk.hasCriticalErrors()) {
                m423a(appLovinAdView, appLovinSdk.coreSdk, appLovinAdSize2, str, context);
                if (C1257b.m2487b(attributeSet)) {
                    mo9563a();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo9568a(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.f371A = appLovinAdViewEventListener;
    }

    /* renamed from: a */
    public void mo9569a(C0750g gVar) {
        this.f373C = gVar;
    }

    /* renamed from: a */
    public void mo9570a(C1057e eVar, AppLovinAdView appLovinAdView, Uri uri, PointF pointF) {
        C1267j.m2559a(this.f372B, (AppLovinAd) eVar);
        if (appLovinAdView != null) {
            this.f377d.trackAndLaunchClick(eVar, appLovinAdView, this, uri, pointF, this.f397x);
            return;
        }
        this.f378e.mo11376e("AppLovinAdView", "Unable to process ad click - AppLovinAdView destroyed prematurely");
    }

    /* renamed from: a */
    public void mo9571a(C1101d dVar) {
        C0740d dVar2 = this.f385l;
        if (dVar2 != null) {
            dVar2.setStatsManagerHelper(dVar);
        }
    }

    /* renamed from: a */
    public void mo9572a(AppLovinAd appLovinAd) {
        mo9573a(appLovinAd, (String) null);
    }

    /* renamed from: a */
    public void mo9573a(AppLovinAd appLovinAd, String str) {
        if (appLovinAd != null) {
            Utils.validateAdSdkKey(appLovinAd, this.f376c);
            if (this.f395v) {
                C1057e eVar = (C1057e) Utils.maybeRetrieveNonDummyAd(appLovinAd, this.f376c);
                if (eVar != null && eVar != this.f389p) {
                    C1314v vVar = this.f378e;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rendering ad #");
                    outline24.append(eVar.getAdIdNumber());
                    outline24.append(" (");
                    outline24.append(eVar.getSize());
                    outline24.append(")");
                    vVar.mo11372b("AppLovinAdView", outline24.toString());
                    C1267j.m2572b(this.f399z, (AppLovinAd) this.f389p);
                    this.f376c.mo10973ak().mo11228b(this.f389p);
                    if (eVar.getSize() != AppLovinAdSize.INTERSTITIAL) {
                        m447w();
                    }
                    if (this.f389p != null && this.f389p.isOpenMeasurementEnabled()) {
                        this.f389p.getAdEventTracker().mo10459e();
                    }
                    this.f393t.set((Object) null);
                    this.f390q = null;
                    this.f389p = eVar;
                    if (!this.f396w && Utils.isBML(this.f380g)) {
                        this.f376c.mo11005u().trackImpression(eVar);
                    }
                    if (this.f391r != null) {
                        m445u();
                    }
                    m424a(this.f386m);
                } else if (eVar == null) {
                    this.f378e.mo11375d("AppLovinAdView", "Unable to render ad. Ad is null. Internal inconsistency error.");
                } else {
                    C1314v vVar2 = this.f378e;
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24("Ad #");
                    outline242.append(eVar.getAdIdNumber());
                    outline242.append(" is already showing, ignoring");
                    vVar2.mo11375d("AppLovinAdView", outline242.toString());
                    if (((Boolean) this.f376c.mo10946a(C1085b.f1678ce)).booleanValue()) {
                        throw new IllegalStateException("Failed to display ad - ad can only be displayed once. Load the next ad.");
                    }
                }
            } else {
                C1314v.m2661g("AppLovinAdView", "Unable to render ad: AppLovinAdView is not initialized.");
            }
        } else {
            throw new IllegalArgumentException("No ad specified");
        }
    }

    /* renamed from: a */
    public void mo9574a(AppLovinAdClickListener appLovinAdClickListener) {
        this.f372B = appLovinAdClickListener;
    }

    /* renamed from: a */
    public void mo9575a(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f399z = appLovinAdDisplayListener;
    }

    /* renamed from: a */
    public void mo9576a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f398y = appLovinAdLoadListener;
    }

    /* renamed from: a */
    public void mo9577a(AppLovinAdSize appLovinAdSize) {
        try {
            C0740d dVar = new C0740d(this.f383j, this.f376c, this.f374a);
            this.f385l = dVar;
            dVar.setBackgroundColor(0);
            this.f385l.setWillNotCacheDrawing(false);
            this.f375b.setBackgroundColor(0);
            this.f375b.addView(this.f385l);
            m427b((View) this.f385l, appLovinAdSize);
            if (!this.f395v) {
                m424a(this.f387n);
            }
            m424a((Runnable) new Runnable() {
                public void run() {
                    C0725b.this.f385l.loadDataWithBaseURL("/", "<html></html>", "text/html", (String) null, "");
                }
            });
            this.f395v = true;
        } catch (Throwable th) {
            C1314v.m2659c("AppLovinAdView", "Failed to initialize AdWebView", th);
            this.f394u.set(true);
        }
    }

    /* renamed from: b */
    public AppLovinAdSize mo9578b() {
        return this.f380g;
    }

    /* renamed from: b */
    public void mo9579b(final AppLovinAd appLovinAd) {
        if (appLovinAd != null) {
            if (!this.f396w) {
                mo9572a(appLovinAd);
            } else {
                this.f393t.set(appLovinAd);
                this.f378e.mo11372b("AppLovinAdView", "Ad view has paused when an ad was received, ad saved for later");
            }
            m424a((Runnable) new Runnable() {
                public void run() {
                    if (C0725b.this.f394u.compareAndSet(true, false)) {
                        C0725b bVar = C0725b.this;
                        bVar.mo9577a(bVar.f380g);
                    }
                    try {
                        if (C0725b.this.f398y != null) {
                            C0725b.this.f398y.adReceived(appLovinAd);
                        }
                    } catch (Throwable th) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Exception while running ad load callback: ");
                        outline24.append(th.getMessage());
                        C1314v.m2663i("AppLovinAdView", outline24.toString());
                    }
                }
            });
            return;
        }
        this.f378e.mo11376e("AppLovinAdView", "No provided when to the view controller");
        mo9564a(-1);
    }

    /* renamed from: c */
    public String mo9580c() {
        return this.f381h;
    }

    /* renamed from: d */
    public void mo9581d() {
        if (this.f395v && !this.f396w) {
            this.f396w = true;
        }
    }

    /* renamed from: e */
    public void mo9582e() {
        if (this.f395v) {
            AppLovinAd andSet = this.f393t.getAndSet((Object) null);
            if (andSet != null) {
                mo9572a(andSet);
            }
            this.f396w = false;
        }
    }

    /* renamed from: f */
    public void mo9583f() {
        if (!(this.f385l == null || this.f391r == null)) {
            mo9588k();
        }
        m444t();
    }

    /* renamed from: g */
    public AppLovinAdViewEventListener mo9584g() {
        return this.f371A;
    }

    public String getCommunicatorId() {
        return C0725b.class.getSimpleName();
    }

    @Nullable
    /* renamed from: h */
    public C0750g mo9585h() {
        return this.f373C;
    }

    /* renamed from: i */
    public void mo9586i() {
        if (C1257b.m2486a((View) this.f385l)) {
            this.f376c.mo10939T().mo10757a(C1103f.f1935m);
        }
    }

    /* renamed from: j */
    public void mo9587j() {
        if (this.f395v) {
            C1267j.m2572b(this.f399z, (AppLovinAd) this.f389p);
            this.f376c.mo10973ak().mo11228b(this.f389p);
            if (this.f389p != null && this.f389p.isOpenMeasurementEnabled()) {
                this.f389p.getAdEventTracker().mo10459e();
            }
            if (this.f385l == null || this.f391r == null) {
                this.f378e.mo11372b("AppLovinAdView", "onDetachedFromWindowCalled without an expanded ad present");
                return;
            }
            this.f378e.mo11372b("AppLovinAdView", "onDetachedFromWindowCalled with expanded ad present");
            m445u();
        }
    }

    /* renamed from: k */
    public void mo9588k() {
        m424a((Runnable) new Runnable() {
            public void run() {
                C0725b.this.m446v();
                if (C0725b.this.f375b != null && C0725b.this.f385l != null && C0725b.this.f385l.getParent() == null) {
                    C0725b.this.f375b.addView(C0725b.this.f385l);
                    C0725b.m427b((View) C0725b.this.f385l, C0725b.this.f389p.getSize());
                    if (C0725b.this.f389p.isOpenMeasurementEnabled()) {
                        C0725b.this.f389p.getAdEventTracker().mo10450a((View) C0725b.this.f385l);
                    }
                }
            }
        });
    }

    /* renamed from: l */
    public void mo9589l() {
        if (this.f391r == null && this.f392s == null) {
            C1314v vVar = this.f378e;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Ad: ");
            outline24.append(this.f389p);
            outline24.append(" closed.");
            vVar.mo11372b("AppLovinAdView", outline24.toString());
            m424a(this.f387n);
            C1267j.m2572b(this.f399z, (AppLovinAd) this.f389p);
            this.f376c.mo10973ak().mo11228b(this.f389p);
            this.f389p = null;
            return;
        }
        mo9588k();
    }

    /* renamed from: m */
    public void mo9590m() {
        this.f397x = true;
    }

    /* renamed from: n */
    public void mo9591n() {
        this.f397x = false;
    }

    /* renamed from: o */
    public void mo9592o() {
        if ((this.f374a instanceof C0758k) && this.f389p != null) {
            if (this.f389p.mo10558D() == C1057e.C1059a.DISMISS) {
                ((C0758k) this.f374a).dismiss();
            }
        }
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("crash_applovin_ad_webview".equals(appLovinCommunicatorMessage.getTopic())) {
            m424a((Runnable) new Runnable() {
                public void run() {
                    C0725b.this.mo9596s().loadUrl("chrome://crash");
                }
            });
        }
    }

    /* renamed from: p */
    public C1057e mo9593p() {
        return this.f389p;
    }

    /* renamed from: q */
    public C1188m mo9594q() {
        return this.f376c;
    }

    /* renamed from: r */
    public AppLovinAdView mo9595r() {
        return (AppLovinAdView) this.f375b;
    }

    /* renamed from: s */
    public C0740d mo9596s() {
        return this.f385l;
    }
}
