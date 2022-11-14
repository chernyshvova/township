package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2317cm;
import com.google.android.play.core.internal.C2318co;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.cq */
public final class C2233cq implements C2318co<C2232cp> {

    /* renamed from: a */
    public final C2318co<C2198bb> f3084a;

    /* renamed from: b */
    public final C2318co<C2281w> f3085b;

    /* renamed from: c */
    public final C2318co<C2218bz> f3086c;

    /* renamed from: d */
    public final C2318co<Executor> f3087d;

    public C2233cq(C2318co<C2198bb> coVar, C2318co<C2281w> coVar2, C2318co<C2218bz> coVar3, C2318co<Executor> coVar4) {
        this.f3084a = coVar;
        this.f3085b = coVar2;
        this.f3086c = coVar3;
        this.f3087d = coVar4;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33167a() {
        C2198bb a = this.f3084a.mo33167a();
        return new C2232cp(a, C2317cm.m3005b(this.f3085b), this.f3086c.mo33167a(), C2317cm.m3005b(this.f3087d));
    }
}
