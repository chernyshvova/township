package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C2293ah;
import com.google.android.play.core.internal.C2324t;
import com.google.android.play.core.tasks.C2349i;

/* renamed from: com.google.android.play.core.assetpacks.ai */
public final class C2180ai extends C2293ah {

    /* renamed from: a */
    public final /* synthetic */ int f2890a;

    /* renamed from: b */
    public final /* synthetic */ String f2891b;

    /* renamed from: c */
    public final /* synthetic */ String f2892c;

    /* renamed from: d */
    public final /* synthetic */ int f2893d;

    /* renamed from: e */
    public final /* synthetic */ C2349i f2894e;

    /* renamed from: f */
    public final /* synthetic */ C2187ar f2895f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2180ai(C2187ar arVar, C2349i iVar, int i, String str, String str2, int i2, C2349i iVar2) {
        super(iVar);
        this.f2895f = arVar;
        this.f2890a = i;
        this.f2891b = str;
        this.f2892c = str2;
        this.f2893d = i2;
        this.f2894e = iVar2;
    }

    /* renamed from: a */
    public final void mo33154a() {
        try {
            ((C2324t) this.f2895f.f2910e.f3250l).mo33305d(this.f2895f.f2908c, C2187ar.m2838c(this.f2890a, this.f2891b, this.f2892c, this.f2893d), C2187ar.m2840e(), new C2183al(this.f2895f, this.f2894e));
        } catch (RemoteException e) {
            C2187ar.f2906a.mo33278a(6, "getChunkFileDescriptor(%s, %s, %d, session=%d)", new Object[]{this.f2891b, this.f2892c, Integer.valueOf(this.f2893d), Integer.valueOf(this.f2890a)});
            this.f2894e.mo33330b((Exception) new RuntimeException(e));
        }
    }
}
