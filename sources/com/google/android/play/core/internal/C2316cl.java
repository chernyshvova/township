package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cl */
public final class C2316cl<T> implements C2318co<T> {

    /* renamed from: a */
    public C2318co<T> f3260a;

    /* renamed from: a */
    public static <T> void m3002a(C2318co<T> coVar, C2318co<T> coVar2) {
        C2316cl clVar = (C2316cl) coVar;
        if (clVar.f3260a == null) {
            clVar.f3260a = coVar2;
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public final T mo33167a() {
        C2318co<T> coVar = this.f3260a;
        if (coVar != null) {
            return coVar.mo33167a();
        }
        throw new IllegalStateException();
    }
}
