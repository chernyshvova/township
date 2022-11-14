package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C2293ah;
import com.google.android.play.core.internal.C2324t;
import com.google.android.play.core.tasks.C2349i;

/* renamed from: com.google.android.play.core.assetpacks.aj */
public final class C2181aj extends C2293ah {

    /* renamed from: a */
    public final /* synthetic */ C2349i f2896a;

    /* renamed from: b */
    public final /* synthetic */ C2187ar f2897b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2181aj(C2187ar arVar, C2349i iVar, C2349i iVar2) {
        super(iVar);
        this.f2897b = arVar;
        this.f2896a = iVar2;
    }

    /* renamed from: a */
    public final void mo33154a() {
        try {
            ((C2324t) this.f2897b.f2911f.f3250l).mo33302b(this.f2897b.f2908c, C2187ar.m2840e(), new C2185an(this.f2897b, this.f2896a));
        } catch (RemoteException e) {
            C2187ar.f2906a.mo33279a((Throwable) e, "keepAlive", new Object[0]);
        }
    }
}
