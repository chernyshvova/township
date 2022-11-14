package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2317cm;
import com.google.android.play.core.internal.C2318co;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.dk */
public final class C2250dk implements C2318co<C2249dj> {

    /* renamed from: a */
    public final C2318co<C2198bb> f3141a;

    /* renamed from: b */
    public final C2318co<C2281w> f3142b;

    /* renamed from: c */
    public final C2318co<C2232cp> f3143c;

    /* renamed from: d */
    public final C2318co<Executor> f3144d;

    /* renamed from: e */
    public final C2318co<C2218bz> f3145e;

    public C2250dk(C2318co<C2198bb> coVar, C2318co<C2281w> coVar2, C2318co<C2232cp> coVar3, C2318co<Executor> coVar4, C2318co<C2218bz> coVar5) {
        this.f3141a = coVar;
        this.f3142b = coVar2;
        this.f3143c = coVar3;
        this.f3144d = coVar4;
        this.f3145e = coVar5;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33167a() {
        C2198bb a = this.f3141a.mo33167a();
        return new C2249dj(a, C2317cm.m3005b(this.f3142b), this.f3143c.mo33167a(), C2317cm.m3005b(this.f3144d), this.f3145e.mo33167a());
    }
}
