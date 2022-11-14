package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C2293ah;
import com.google.android.play.core.internal.C2324t;
import com.google.android.play.core.tasks.C2349i;

/* renamed from: com.google.android.play.core.assetpacks.ah */
public final class C2179ah extends C2293ah {

    /* renamed from: a */
    public final /* synthetic */ int f2887a;

    /* renamed from: b */
    public final /* synthetic */ C2349i f2888b;

    /* renamed from: c */
    public final /* synthetic */ C2187ar f2889c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2179ah(C2187ar arVar, C2349i iVar, int i, C2349i iVar2) {
        super(iVar);
        this.f2889c = arVar;
        this.f2887a = i;
        this.f2888b = iVar2;
    }

    /* renamed from: a */
    public final void mo33154a() {
        try {
            String str = this.f2889c.f2908c;
            int i = this.f2887a;
            Bundle bundle = new Bundle();
            bundle.putInt("session_id", i);
            ((C2324t) this.f2889c.f2910e.f3250l).mo33304c(str, bundle, C2187ar.m2840e(), new C2182ak(this.f2889c, this.f2888b, (int[]) null));
        } catch (RemoteException e) {
            C2187ar.f2906a.mo33279a((Throwable) e, "notifySessionFailed", new Object[0]);
        }
    }
}
