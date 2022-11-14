package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C2293ah;
import com.google.android.play.core.internal.C2324t;
import com.google.android.play.core.internal.C2326v;
import com.google.android.play.core.tasks.C2349i;

/* renamed from: com.google.android.play.core.assetpacks.ag */
public final class C2178ag extends C2293ah {

    /* renamed from: a */
    public final /* synthetic */ int f2882a;

    /* renamed from: b */
    public final /* synthetic */ String f2883b;

    /* renamed from: c */
    public final /* synthetic */ C2349i f2884c;

    /* renamed from: d */
    public final /* synthetic */ int f2885d;

    /* renamed from: e */
    public final /* synthetic */ C2187ar f2886e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2178ag(C2187ar arVar, C2349i iVar, int i, String str, C2349i iVar2, int i2) {
        super(iVar);
        this.f2886e = arVar;
        this.f2882a = i;
        this.f2883b = str;
        this.f2884c = iVar2;
        this.f2885d = i2;
    }

    /* renamed from: a */
    public final void mo33154a() {
        try {
            String str = this.f2886e.f2908c;
            int i = this.f2882a;
            String str2 = this.f2883b;
            Bundle bundle = new Bundle();
            bundle.putInt("session_id", i);
            bundle.putString("module_name", str2);
            ((C2324t) this.f2886e.f2910e.f3250l).mo33301b(str, bundle, C2187ar.m2840e(), (C2326v) new C2186ao(this.f2886e, this.f2884c, this.f2882a, this.f2883b, this.f2885d));
        } catch (RemoteException e) {
            C2187ar.f2906a.mo33279a((Throwable) e, "notifyModuleCompleted", new Object[0]);
        }
    }
}
