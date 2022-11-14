package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2315ck;
import com.google.android.play.core.internal.C2317cm;
import com.google.android.play.core.internal.C2318co;
import com.google.android.play.core.splitinstall.C2339p;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.k */
public final class C2268k implements C2318co<C2267j> {

    /* renamed from: a */
    public final C2318co<C2198bb> f3201a;

    /* renamed from: b */
    public final C2318co<C2281w> f3202b;

    /* renamed from: c */
    public final C2318co<C2192aw> f3203c;

    /* renamed from: d */
    public final C2318co<C2339p> f3204d;

    /* renamed from: e */
    public final C2318co<C2232cp> f3205e;

    /* renamed from: f */
    public final C2318co<C2218bz> f3206f;

    /* renamed from: g */
    public final C2318co<C2207bn> f3207g;

    /* renamed from: h */
    public final C2318co<Executor> f3208h;

    public C2268k(C2318co<C2198bb> coVar, C2318co<C2281w> coVar2, C2318co<C2192aw> coVar3, C2318co<C2339p> coVar4, C2318co<C2232cp> coVar5, C2318co<C2218bz> coVar6, C2318co<C2207bn> coVar7, C2318co<Executor> coVar8) {
        this.f3201a = coVar;
        this.f3202b = coVar2;
        this.f3203c = coVar3;
        this.f3204d = coVar4;
        this.f3205e = coVar5;
        this.f3206f = coVar6;
        this.f3207g = coVar7;
        this.f3208h = coVar8;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33167a() {
        C2198bb a = this.f3201a.mo33167a();
        C2315ck<C2281w> b = C2317cm.m3005b(this.f3202b);
        C2192aw a2 = this.f3203c.mo33167a();
        return new C2267j(a, b, a2, this.f3204d.mo33167a(), this.f3205e.mo33167a(), this.f3206f.mo33167a(), this.f3207g.mo33167a(), C2317cm.m3005b(this.f3208h));
    }
}
