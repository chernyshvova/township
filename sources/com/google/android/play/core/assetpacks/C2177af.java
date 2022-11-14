package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C2293ah;
import com.google.android.play.core.internal.C2324t;
import com.google.android.play.core.tasks.C2349i;

/* renamed from: com.google.android.play.core.assetpacks.af */
public final class C2177af extends C2293ah {

    /* renamed from: a */
    public final /* synthetic */ int f2876a;

    /* renamed from: b */
    public final /* synthetic */ String f2877b;

    /* renamed from: c */
    public final /* synthetic */ String f2878c;

    /* renamed from: d */
    public final /* synthetic */ int f2879d;

    /* renamed from: e */
    public final /* synthetic */ C2349i f2880e;

    /* renamed from: f */
    public final /* synthetic */ C2187ar f2881f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2177af(C2187ar arVar, C2349i iVar, int i, String str, String str2, int i2, C2349i iVar2) {
        super(iVar);
        this.f2881f = arVar;
        this.f2876a = i;
        this.f2877b = str;
        this.f2878c = str2;
        this.f2879d = i2;
        this.f2880e = iVar2;
    }

    /* renamed from: a */
    public final void mo33154a() {
        try {
            ((C2324t) this.f2881f.f2910e.f3250l).mo33299a(this.f2881f.f2908c, C2187ar.m2838c(this.f2876a, this.f2877b, this.f2878c, this.f2879d), C2187ar.m2840e(), new C2182ak(this.f2881f, this.f2880e, (char[]) null));
        } catch (RemoteException e) {
            C2187ar.f2906a.mo33279a((Throwable) e, "notifyChunkTransferred", new Object[0]);
        }
    }
}
