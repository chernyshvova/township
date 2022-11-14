package com.applovin.impl.sdk.p028d;

import com.android.tools.p006r8.GeneratedOutlineSupport;

/* renamed from: com.applovin.impl.sdk.d.e */
public final class C1102e {

    /* renamed from: a */
    public long f1916a;

    /* renamed from: b */
    public long f1917b;

    /* renamed from: c */
    public boolean f1918c;

    /* renamed from: d */
    public long f1919d;

    /* renamed from: e */
    public long f1920e;

    /* renamed from: f */
    public int f1921f;

    /* renamed from: g */
    public Exception f1922g;

    /* renamed from: a */
    public void mo10741a() {
        this.f1918c = true;
    }

    /* renamed from: a */
    public void mo10742a(int i) {
        this.f1921f = i;
    }

    /* renamed from: a */
    public void mo10743a(long j) {
        this.f1916a += j;
    }

    /* renamed from: a */
    public void mo10744a(Exception exc) {
        this.f1922g = exc;
    }

    /* renamed from: b */
    public void mo10745b(long j) {
        this.f1917b += j;
    }

    /* renamed from: b */
    public boolean mo10746b() {
        return this.f1918c;
    }

    /* renamed from: c */
    public long mo10747c() {
        return this.f1916a;
    }

    /* renamed from: d */
    public long mo10748d() {
        return this.f1917b;
    }

    /* renamed from: e */
    public void mo10749e() {
        this.f1919d++;
    }

    /* renamed from: f */
    public void mo10750f() {
        this.f1920e++;
    }

    /* renamed from: g */
    public long mo10751g() {
        return this.f1919d;
    }

    /* renamed from: h */
    public long mo10752h() {
        return this.f1920e;
    }

    /* renamed from: i */
    public Exception mo10753i() {
        return this.f1922g;
    }

    /* renamed from: j */
    public int mo10754j() {
        return this.f1921f;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("CacheStatsTracker{totalDownloadedBytes=");
        outline24.append(this.f1916a);
        outline24.append(", totalCachedBytes=");
        outline24.append(this.f1917b);
        outline24.append(", isHTMLCachingCancelled=");
        outline24.append(this.f1918c);
        outline24.append(", htmlResourceCacheSuccessCount=");
        outline24.append(this.f1919d);
        outline24.append(", htmlResourceCacheFailureCount=");
        outline24.append(this.f1920e);
        outline24.append('}');
        return outline24.toString();
    }
}
