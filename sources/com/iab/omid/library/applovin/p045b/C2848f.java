package com.iab.omid.library.applovin.p045b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.applovin.adsession.C2839a;
import com.iab.omid.library.applovin.p044a.C2835b;
import com.iab.omid.library.applovin.p044a.C2836c;
import com.iab.omid.library.applovin.p044a.C2837d;
import com.iab.omid.library.applovin.p044a.C2838e;
import com.iab.omid.library.applovin.p045b.C2842b;
import com.iab.omid.library.applovin.walking.TreeWalker;

/* renamed from: com.iab.omid.library.applovin.b.f */
public class C2848f implements C2836c, C2842b.C2843a {

    /* renamed from: a */
    public static C2848f f3410a;

    /* renamed from: b */
    public float f3411b = 0.0f;

    /* renamed from: c */
    public final C2838e f3412c;

    /* renamed from: d */
    public final C2835b f3413d;

    /* renamed from: e */
    public C2837d f3414e;

    /* renamed from: f */
    public C2841a f3415f;

    public C2848f(C2838e eVar, C2835b bVar) {
        this.f3412c = eVar;
        this.f3413d = bVar;
    }

    /* renamed from: a */
    public static C2848f m3325a() {
        if (f3410a == null) {
            f3410a = new C2848f(new C2838e(), new C2835b());
        }
        return f3410a;
    }

    /* renamed from: e */
    private C2841a m3326e() {
        if (this.f3415f == null) {
            this.f3415f = C2841a.m3285a();
        }
        return this.f3415f;
    }

    /* renamed from: a */
    public void mo36632a(float f) {
        this.f3411b = f;
        for (C2839a adSessionStatePublisher : m3326e().mo36712c()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo36762a(f);
        }
    }

    /* renamed from: a */
    public void mo36751a(Context context) {
        this.f3414e = this.f3412c.mo36636a(new Handler(), context, this.f3413d.mo36631a(), this);
    }

    /* renamed from: a */
    public void mo36727a(boolean z) {
        if (z) {
            TreeWalker.getInstance().mo36787a();
        } else {
            TreeWalker.getInstance().mo36790c();
        }
    }

    /* renamed from: b */
    public void mo36752b() {
        C2842b.m3292a().mo36716a((C2842b.C2843a) this);
        C2842b.m3292a().mo36717b();
        TreeWalker.getInstance().mo36787a();
        this.f3414e.mo36633a();
    }

    /* renamed from: c */
    public void mo36753c() {
        TreeWalker.getInstance().mo36789b();
        C2842b.m3292a().mo36718c();
        this.f3414e.mo36634b();
    }

    /* renamed from: d */
    public float mo36754d() {
        return this.f3411b;
    }
}
