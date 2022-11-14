package com.applovin.impl.sdk;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.p012c.C0867c;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.s */
public class C1248s {

    /* renamed from: a */
    public final C1188m f2408a;

    /* renamed from: b */
    public final AtomicBoolean f2409b = new AtomicBoolean();

    /* renamed from: c */
    public long f2410c;

    /* renamed from: d */
    public final Object f2411d = new Object();

    /* renamed from: e */
    public final AtomicBoolean f2412e = new AtomicBoolean();

    /* renamed from: f */
    public long f2413f;

    /* renamed from: g */
    public Object f2414g;

    public C1248s(C1188m mVar) {
        this.f2408a = mVar;
    }

    /* renamed from: a */
    public void mo11248a(final Object obj) {
        this.f2408a.mo10973ak().mo11226a(obj);
        if (!C0867c.m939a(obj) && this.f2409b.compareAndSet(false, true)) {
            this.f2414g = obj;
            this.f2410c = System.currentTimeMillis();
            C1314v B = this.f2408a.mo10922B();
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Setting fullscreen ad displayed: ");
            outline24.append(this.f2410c);
            B.mo11372b("FullScreenAdTracker", outline24.toString());
            this.f2408a.mo10972aj().sendBroadcastWithAdObject("com.applovin.fullscreen_ad_displayed", obj);
            final long longValue = ((Long) this.f2408a.mo10946a(C1085b.f1685cl)).longValue();
            if (longValue >= 0) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        if (C1248s.this.f2409b.get() && System.currentTimeMillis() - C1248s.this.f2410c >= longValue) {
                            C1248s.this.f2408a.mo10922B().mo11372b("FullScreenAdTracker", "Resetting \"display\" state...");
                            C1248s.this.mo11251b(obj);
                        }
                    }
                }, longValue);
            }
        }
    }

    /* renamed from: a */
    public void mo11249a(boolean z) {
        synchronized (this.f2411d) {
            this.f2412e.set(z);
            if (z) {
                this.f2413f = System.currentTimeMillis();
                C1314v B = this.f2408a.mo10922B();
                B.mo11372b("FullScreenAdTracker", "Setting fullscreen ad pending display: " + this.f2413f);
                final long longValue = ((Long) this.f2408a.mo10946a(C1085b.f1684ck)).longValue();
                if (longValue >= 0) {
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                        public void run() {
                            if (C1248s.this.mo11250a() && System.currentTimeMillis() - C1248s.this.f2413f >= longValue) {
                                C1248s.this.f2408a.mo10922B().mo11372b("FullScreenAdTracker", "Resetting \"pending display\" state...");
                                C1248s.this.f2412e.set(false);
                            }
                        }
                    }, longValue);
                }
            } else {
                this.f2413f = 0;
                C1314v B2 = this.f2408a.mo10922B();
                B2.mo11372b("FullScreenAdTracker", "Setting fullscreen ad not pending display: " + System.currentTimeMillis());
            }
        }
    }

    /* renamed from: a */
    public boolean mo11250a() {
        return this.f2412e.get();
    }

    /* renamed from: b */
    public void mo11251b(Object obj) {
        this.f2408a.mo10973ak().mo11228b(obj);
        if (!C0867c.m939a(obj) && this.f2409b.compareAndSet(true, false)) {
            this.f2414g = null;
            C1314v B = this.f2408a.mo10922B();
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Setting fullscreen ad hidden: ");
            outline24.append(System.currentTimeMillis());
            B.mo11372b("FullScreenAdTracker", outline24.toString());
            this.f2408a.mo10972aj().sendBroadcastWithAdObject("com.applovin.fullscreen_ad_hidden", obj);
        }
    }

    /* renamed from: b */
    public boolean mo11252b() {
        return this.f2409b.get();
    }

    @Nullable
    /* renamed from: c */
    public Object mo11253c() {
        return this.f2414g;
    }
}
