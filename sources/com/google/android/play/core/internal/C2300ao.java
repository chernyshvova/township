package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.ao */
public final class C2300ao extends C2293ah {

    /* renamed from: a */
    public final /* synthetic */ C2301ap f3237a;

    public C2300ao(C2301ap apVar) {
        this.f3237a = apVar;
    }

    /* renamed from: a */
    public final void mo33154a() {
        C2302aq aqVar = this.f3237a.f3238a;
        aqVar.f3241c.mo33278a(4, "unlinkToDeath", new Object[0]);
        aqVar.f3250l.asBinder().unlinkToDeath(aqVar.f3248j, 0);
        C2302aq aqVar2 = this.f3237a.f3238a;
        aqVar2.f3250l = null;
        aqVar2.f3244f = false;
    }
}
