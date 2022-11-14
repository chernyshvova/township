package com.applovin.impl.sdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.applovin.impl.mediation.p010a.C0802b;
import com.applovin.impl.mediation.p010a.C0804d;
import com.applovin.impl.mediation.p010a.C0805e;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.sdk.ab */
public class C1042ab {

    /* renamed from: a */
    public final C1188m f1362a;

    /* renamed from: b */
    public final C1314v f1363b;

    /* renamed from: c */
    public final Object f1364c = new Object();

    /* renamed from: d */
    public final Rect f1365d = new Rect();

    /* renamed from: e */
    public final Handler f1366e;

    /* renamed from: f */
    public final Runnable f1367f;

    /* renamed from: g */
    public final ViewTreeObserver.OnPreDrawListener f1368g;

    /* renamed from: h */
    public final WeakReference<View> f1369h;

    /* renamed from: i */
    public WeakReference<ViewTreeObserver> f1370i = new WeakReference<>((Object) null);

    /* renamed from: j */
    public WeakReference<View> f1371j = new WeakReference<>((Object) null);

    /* renamed from: k */
    public int f1372k;

    /* renamed from: l */
    public long f1373l;

    /* renamed from: m */
    public long f1374m = Long.MIN_VALUE;

    /* renamed from: com.applovin.impl.sdk.ab$a */
    public interface C1045a {
        void onLogVisibilityImpression();
    }

    public C1042ab(View view, C1188m mVar, C1045a aVar) {
        this.f1362a = mVar;
        this.f1363b = mVar.mo10922B();
        this.f1366e = new Handler(Looper.getMainLooper());
        this.f1369h = new WeakReference<>(view);
        final WeakReference weakReference = new WeakReference(aVar);
        this.f1367f = new Runnable() {
            public void run() {
                ViewGroup viewGroup = C1042ab.this.f1369h.get() instanceof ViewGroup ? (ViewGroup) C1042ab.this.f1369h.get() : null;
                View view = (View) C1042ab.this.f1371j.get();
                if (viewGroup != null && view != null) {
                    if (C1042ab.this.m1433b(viewGroup, view)) {
                        C1042ab.this.f1363b.mo11372b("VisibilityTracker", "View met visibility requirements. Logging visibility impression..");
                        C1042ab.this.mo10509a();
                        C1045a aVar = (C1045a) weakReference.get();
                        if (aVar != null) {
                            aVar.onLogVisibilityImpression();
                            return;
                        }
                        return;
                    }
                    C1042ab.this.m1432b();
                }
            }
        };
        this.f1368g = new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                C1042ab.this.m1432b();
                C1042ab.this.m1435c();
                return true;
            }
        };
    }

    /* renamed from: a */
    private void m1428a(View view) {
        View rootView = Utils.getRootView((View) this.f1369h.get());
        if (rootView == null) {
            rootView = Utils.getRootView(view);
        }
        if (rootView == null) {
            this.f1363b.mo11372b("VisibilityTracker", "Unable to set view tree observer due to no root view.");
            return;
        }
        ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            this.f1363b.mo11375d("VisibilityTracker", "Unable to set view tree observer since the view tree observer is not alive.");
            return;
        }
        this.f1370i = new WeakReference<>(viewTreeObserver);
        viewTreeObserver.addOnPreDrawListener(this.f1368g);
    }

    /* renamed from: a */
    private boolean m1429a(View view, View view2) {
        if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || view2.getWidth() <= 0 || view2.getHeight() <= 0 || !view2.getGlobalVisibleRect(this.f1365d)) {
            return false;
        }
        return ((long) (AppLovinSdkUtils.pxToDp(view2.getContext(), this.f1365d.height()) * AppLovinSdkUtils.pxToDp(view2.getContext(), this.f1365d.width()))) >= ((long) this.f1372k);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1432b() {
        this.f1366e.postDelayed(this.f1367f, ((Long) this.f1362a.mo10946a(C1085b.f1620bY)).longValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m1433b(View view, View view2) {
        if (!m1429a(view, view2)) {
            return false;
        }
        if (this.f1374m == Long.MIN_VALUE) {
            this.f1374m = SystemClock.uptimeMillis();
        }
        return SystemClock.uptimeMillis() - this.f1374m >= this.f1373l;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1435c() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f1370i.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f1368g);
        }
        this.f1370i.clear();
    }

    /* renamed from: a */
    public void mo10509a() {
        synchronized (this.f1364c) {
            this.f1366e.removeMessages(0);
            m1435c();
            this.f1374m = Long.MIN_VALUE;
            this.f1371j.clear();
        }
    }

    /* renamed from: a */
    public void mo10510a(C0805e eVar) {
        WeakReference<View> weakReference;
        synchronized (this.f1364c) {
            this.f1363b.mo11372b("VisibilityTracker", "Tracking Visibility...");
            mo10509a();
            if (eVar instanceof C0802b) {
                weakReference = new WeakReference<>(((C0802b) eVar).mo9864x());
            } else if (eVar instanceof C0804d) {
                weakReference = new WeakReference<>(((C0804d) eVar).mo9885w());
            } else {
                return;
            }
            this.f1371j = weakReference;
            this.f1372k = eVar.mo9892G();
            this.f1373l = eVar.mo9894I();
            m1428a((View) this.f1371j.get());
        }
    }
}
