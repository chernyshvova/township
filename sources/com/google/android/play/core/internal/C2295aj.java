package com.google.android.play.core.internal;

import com.google.android.play.core.tasks.C2349i;

/* renamed from: com.google.android.play.core.internal.aj */
public final class C2295aj extends C2293ah {

    /* renamed from: a */
    public final /* synthetic */ C2293ah f3232a;

    /* renamed from: b */
    public final /* synthetic */ C2302aq f3233b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2295aj(C2302aq aqVar, C2349i iVar, C2293ah ahVar) {
        super(iVar);
        this.f3233b = aqVar;
        this.f3232a = ahVar;
    }

    /* renamed from: a */
    public final void mo33154a() {
        C2302aq aqVar = this.f3233b;
        C2293ah ahVar = this.f3232a;
        if (aqVar.f3250l == null && !aqVar.f3244f) {
            aqVar.f3241c.mo33278a(4, "Initiate binding to the service.", new Object[0]);
            aqVar.f3243e.add(ahVar);
            C2301ap apVar = new C2301ap(aqVar);
            aqVar.f3249k = apVar;
            aqVar.f3244f = true;
            if (!aqVar.f3240b.bindService(aqVar.f3245g, apVar, 1)) {
                aqVar.f3241c.mo33278a(4, "Failed to bind to the service.", new Object[0]);
                aqVar.f3244f = false;
                for (C2293ah ahVar2 : aqVar.f3243e) {
                    C2349i<?> iVar = ahVar2.f3230a;
                    if (iVar != null) {
                        iVar.mo33330b((Exception) new C2303ar());
                    }
                }
                aqVar.f3243e.clear();
            }
        } else if (aqVar.f3244f) {
            aqVar.f3241c.mo33278a(4, "Waiting to bind to the service.", new Object[0]);
            aqVar.f3243e.add(ahVar);
        } else {
            ahVar.run();
        }
    }
}
