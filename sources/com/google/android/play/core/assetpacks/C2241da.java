package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.C2317cm;
import com.google.android.play.core.internal.C2318co;
import java.io.File;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.da */
public final class C2241da implements C2318co<C2240cz> {

    /* renamed from: a */
    public final C2318co<String> f3110a;

    /* renamed from: b */
    public final C2318co<C2192aw> f3111b;

    /* renamed from: c */
    public final C2318co<C2218bz> f3112c;

    /* renamed from: d */
    public final C2318co<Context> f3113d;

    /* renamed from: e */
    public final C2318co<C2251dl> f3114e;

    /* renamed from: f */
    public final C2318co<Executor> f3115f;

    public C2241da(C2318co<String> coVar, C2318co<C2192aw> coVar2, C2318co<C2218bz> coVar3, C2318co<Context> coVar4, C2318co<C2251dl> coVar5, C2318co<Executor> coVar6) {
        this.f3110a = coVar;
        this.f3111b = coVar2;
        this.f3112c = coVar3;
        this.f3113d = coVar4;
        this.f3114e = coVar5;
        this.f3115f = coVar6;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33167a() {
        String a = this.f3110a.mo33167a();
        C2192aw a2 = this.f3111b.mo33167a();
        C2218bz a3 = this.f3112c.mo33167a();
        Context b = ((C2277s) this.f3113d).mo33167a();
        C2251dl a4 = this.f3114e.mo33167a();
        return new C2240cz(a != null ? new File(b.getExternalFilesDir((String) null), a) : b.getExternalFilesDir((String) null), a2, a3, b, a4, C2317cm.m3005b(this.f3115f));
    }
}
