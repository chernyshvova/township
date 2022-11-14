package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.an */
public final class C2299an extends C2293ah {

    /* renamed from: a */
    public final /* synthetic */ IBinder f3235a;

    /* renamed from: b */
    public final /* synthetic */ C2301ap f3236b;

    public C2299an(C2301ap apVar, IBinder iBinder) {
        this.f3236b = apVar;
        this.f3235a = iBinder;
    }

    /* renamed from: a */
    public final void mo33154a() {
        C2302aq aqVar = this.f3236b.f3238a;
        aqVar.f3250l = (IInterface) aqVar.f3246h.mo33271a(this.f3235a);
        C2302aq aqVar2 = this.f3236b.f3238a;
        aqVar2.f3241c.mo33278a(4, "linkToDeath", new Object[0]);
        try {
            aqVar2.f3250l.asBinder().linkToDeath(aqVar2.f3248j, 0);
        } catch (RemoteException e) {
            aqVar2.f3241c.mo33279a((Throwable) e, "linkToDeath failed", new Object[0]);
        }
        C2302aq aqVar3 = this.f3236b.f3238a;
        aqVar3.f3244f = false;
        for (C2293ah run : aqVar3.f3243e) {
            run.run();
        }
        this.f3236b.f3238a.f3243e.clear();
    }
}
