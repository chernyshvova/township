package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.ak */
public final class C2296ak extends C2293ah {

    /* renamed from: a */
    public final /* synthetic */ C2302aq f3234a;

    public C2296ak(C2302aq aqVar) {
        this.f3234a = aqVar;
    }

    /* renamed from: a */
    public final void mo33154a() {
        C2302aq aqVar = this.f3234a;
        if (aqVar.f3250l != null) {
            aqVar.f3241c.mo33278a(4, "Unbind from service.", new Object[0]);
            C2302aq aqVar2 = this.f3234a;
            aqVar2.f3240b.unbindService(aqVar2.f3249k);
            C2302aq aqVar3 = this.f3234a;
            aqVar3.f3244f = false;
            aqVar3.f3250l = null;
            aqVar3.f3249k = null;
        }
    }
}
