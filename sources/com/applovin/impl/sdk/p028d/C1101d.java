package com.applovin.impl.sdk.p028d;

import android.annotation.TargetApi;
import android.app.Activity;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.AppLovinAdImpl;
import com.applovin.impl.sdk.p028d.C1095c;
import com.applovin.impl.sdk.utils.C1263g;
import com.applovin.impl.sdk.utils.C1264h;

/* renamed from: com.applovin.impl.sdk.d.d */
public class C1101d {

    /* renamed from: a */
    public final C1188m f1908a;

    /* renamed from: b */
    public final C1104g f1909b;

    /* renamed from: c */
    public final C1095c.C1099b f1910c;

    /* renamed from: d */
    public final Object f1911d = new Object();

    /* renamed from: e */
    public final long f1912e;

    /* renamed from: f */
    public long f1913f;

    /* renamed from: g */
    public long f1914g;

    /* renamed from: h */
    public long f1915h;

    public C1101d(AppLovinAdImpl appLovinAdImpl, C1188m mVar) {
        if (appLovinAdImpl == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (mVar != null) {
            this.f1908a = mVar;
            this.f1909b = mVar.mo10939T();
            C1095c.C1099b a = mVar.mo10964ab().mo10717a((AppLovinAdBase) appLovinAdImpl);
            this.f1910c = a;
            a.mo10726a(C1094b.f1868a, (long) appLovinAdImpl.getSource().ordinal()).mo10728a();
            this.f1912e = appLovinAdImpl.getCreatedAtMillis();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    public static void m1736a(long j, AppLovinAdBase appLovinAdBase, C1188m mVar) {
        if (appLovinAdBase != null && mVar != null) {
            mVar.mo10964ab().mo10717a(appLovinAdBase).mo10726a(C1094b.f1869b, j).mo10728a();
        }
    }

    /* renamed from: a */
    public static void m1737a(AppLovinAdBase appLovinAdBase, C1188m mVar) {
        if (appLovinAdBase != null && mVar != null) {
            mVar.mo10964ab().mo10717a(appLovinAdBase).mo10726a(C1094b.f1870c, appLovinAdBase.getFetchLatencyMillis()).mo10726a(C1094b.f1871d, appLovinAdBase.getFetchResponseSize()).mo10728a();
        }
    }

    /* renamed from: a */
    private void m1738a(C1094b bVar) {
        synchronized (this.f1911d) {
            if (this.f1913f > 0) {
                this.f1910c.mo10726a(bVar, System.currentTimeMillis() - this.f1913f).mo10728a();
            }
        }
    }

    /* renamed from: a */
    public static void m1739a(C1102e eVar, AppLovinAdBase appLovinAdBase, C1188m mVar) {
        if (appLovinAdBase != null && mVar != null && eVar != null) {
            mVar.mo10964ab().mo10717a(appLovinAdBase).mo10726a(C1094b.f1872e, eVar.mo10747c()).mo10726a(C1094b.f1873f, eVar.mo10748d()).mo10726a(C1094b.f1888u, eVar.mo10751g()).mo10726a(C1094b.f1889v, eVar.mo10752h()).mo10726a(C1094b.f1890w, eVar.mo10746b() ? 1 : 0).mo10728a();
        }
    }

    @TargetApi(24)
    /* renamed from: a */
    public void mo10730a() {
        this.f1910c.mo10726a(C1094b.f1877j, this.f1909b.mo10757a(C1103f.f1924b)).mo10726a(C1094b.f1876i, this.f1909b.mo10757a(C1103f.f1926d));
        synchronized (this.f1911d) {
            long j = 0;
            if (this.f1912e > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f1913f = currentTimeMillis;
                long O = currentTimeMillis - this.f1908a.mo10934O();
                long j2 = this.f1913f - this.f1912e;
                long j3 = C1264h.m2521a(this.f1908a.mo10932L()) ? 1 : 0;
                Activity a = this.f1908a.mo10967ae().mo10434a();
                if (C1263g.m2510f() && a != null && a.isInMultiWindowMode()) {
                    j = 1;
                }
                this.f1910c.mo10726a(C1094b.f1875h, O).mo10726a(C1094b.f1874g, j2).mo10726a(C1094b.f1883p, j3).mo10726a(C1094b.f1891x, j);
            }
        }
        this.f1910c.mo10728a();
    }

    /* renamed from: a */
    public void mo10731a(long j) {
        this.f1910c.mo10726a(C1094b.f1885r, j).mo10728a();
    }

    /* renamed from: b */
    public void mo10732b() {
        synchronized (this.f1911d) {
            if (this.f1914g < 1) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f1914g = currentTimeMillis;
                if (this.f1913f > 0) {
                    this.f1910c.mo10726a(C1094b.f1880m, currentTimeMillis - this.f1913f).mo10728a();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo10733b(long j) {
        this.f1910c.mo10726a(C1094b.f1884q, j).mo10728a();
    }

    /* renamed from: c */
    public void mo10734c() {
        m1738a(C1094b.f1878k);
    }

    /* renamed from: c */
    public void mo10735c(long j) {
        this.f1910c.mo10726a(C1094b.f1886s, j).mo10728a();
    }

    /* renamed from: d */
    public void mo10736d() {
        m1738a(C1094b.f1881n);
    }

    /* renamed from: d */
    public void mo10737d(long j) {
        synchronized (this.f1911d) {
            if (this.f1915h < 1) {
                this.f1915h = j;
                this.f1910c.mo10726a(C1094b.f1887t, j).mo10728a();
            }
        }
    }

    /* renamed from: e */
    public void mo10738e() {
        m1738a(C1094b.f1882o);
    }

    /* renamed from: f */
    public void mo10739f() {
        m1738a(C1094b.f1879l);
    }

    /* renamed from: g */
    public void mo10740g() {
        this.f1910c.mo10725a(C1094b.f1892y).mo10728a();
    }
}
