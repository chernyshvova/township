package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.common.C2284a;
import com.google.android.play.core.internal.C2315ck;
import com.google.android.play.core.internal.C2317cm;
import com.google.android.play.core.internal.C2318co;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.ax */
public final class C2193ax implements C2318co<C2192aw> {

    /* renamed from: a */
    public final C2318co<Context> f2933a;

    /* renamed from: b */
    public final C2318co<C2232cp> f2934b;

    /* renamed from: c */
    public final C2318co<C2215bw> f2935c;

    /* renamed from: d */
    public final C2318co<C2281w> f2936d;

    /* renamed from: e */
    public final C2318co<C2218bz> f2937e;

    /* renamed from: f */
    public final C2318co<C2207bn> f2938f;

    /* renamed from: g */
    public final C2318co<C2284a> f2939g;

    /* renamed from: h */
    public final C2318co<Executor> f2940h;

    /* renamed from: i */
    public final C2318co<Executor> f2941i;

    public C2193ax(C2318co<Context> coVar, C2318co<C2232cp> coVar2, C2318co<C2215bw> coVar3, C2318co<C2281w> coVar4, C2318co<C2218bz> coVar5, C2318co<C2207bn> coVar6, C2318co<C2284a> coVar7, C2318co<Executor> coVar8, C2318co<Executor> coVar9) {
        this.f2933a = coVar;
        this.f2934b = coVar2;
        this.f2935c = coVar3;
        this.f2936d = coVar4;
        this.f2937e = coVar5;
        this.f2938f = coVar6;
        this.f2939g = coVar7;
        this.f2940h = coVar8;
        this.f2941i = coVar9;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33167a() {
        Context b = ((C2277s) this.f2933a).mo33167a();
        C2232cp a = this.f2934b.mo33167a();
        C2215bw a2 = this.f2935c.mo33167a();
        C2315ck<C2281w> b2 = C2317cm.m3005b(this.f2936d);
        C2218bz a3 = this.f2937e.mo33167a();
        C2207bn a4 = this.f2938f.mo33167a();
        return new C2192aw(b, a, a2, b2, a3, a4, this.f2939g.mo33167a(), C2317cm.m3005b(this.f2940h), C2317cm.m3005b(this.f2941i));
    }
}
