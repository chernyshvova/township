package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C2293ah;
import com.google.android.play.core.internal.C2324t;
import com.google.android.play.core.tasks.C2349i;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.ad */
public final class C2176ad extends C2293ah {

    /* renamed from: a */
    public final /* synthetic */ Map f2873a;

    /* renamed from: b */
    public final /* synthetic */ C2349i f2874b;

    /* renamed from: c */
    public final /* synthetic */ C2187ar f2875c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2176ad(C2187ar arVar, C2349i iVar, Map map, C2349i iVar2) {
        super(iVar);
        this.f2875c = arVar;
        this.f2873a = map;
        this.f2874b = iVar2;
    }

    /* renamed from: a */
    public final void mo33154a() {
        try {
            ((C2324t) this.f2875c.f2910e.f3250l).mo33300a(this.f2875c.f2908c, C2187ar.m2837b(this.f2873a), new C2184am(this.f2875c, this.f2874b));
        } catch (RemoteException e) {
            C2187ar.f2906a.mo33279a((Throwable) e, "syncPacks", new Object[0]);
            this.f2874b.mo33330b((Exception) new RuntimeException(e));
        }
    }
}
