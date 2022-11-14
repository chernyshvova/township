package com.google.android.play.core.review;

import android.os.RemoteException;
import com.google.android.play.core.common.PlayCoreVersion;
import com.google.android.play.core.internal.C2293ah;
import com.google.android.play.core.tasks.C2349i;

/* renamed from: com.google.android.play.core.review.e */
public final class C2335e extends C2293ah {

    /* renamed from: a */
    public final /* synthetic */ C2349i f3272a;

    /* renamed from: b */
    public final /* synthetic */ C2337h f3273b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2335e(C2337h hVar, C2349i iVar, C2349i iVar2) {
        super(iVar);
        this.f3273b = hVar;
        this.f3272a = iVar2;
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [com.google.android.play.core.internal.ae, com.google.android.play.core.review.g] */
    /* renamed from: a */
    public final void mo33154a() {
        try {
            this.f3273b.f3278a.f3250l.mo33276a(this.f3273b.f3279c, PlayCoreVersion.m2971a(), new C2336g(this.f3273b, this.f3272a));
        } catch (RemoteException e) {
            C2337h.f3277b.mo33279a((Throwable) e, "error requesting in-app review for %s", this.f3273b.f3279c);
            this.f3272a.mo33330b((Exception) new RuntimeException(e));
        }
    }
}
