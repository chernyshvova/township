package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C2349i;

/* renamed from: com.google.android.play.core.assetpacks.an */
public final class C2185an extends C2182ak<Void> {

    /* renamed from: c */
    public final /* synthetic */ C2187ar f2901c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2185an(C2187ar arVar, C2349i<Void> iVar) {
        super(arVar, iVar);
        this.f2901c = arVar;
    }

    /* renamed from: a */
    public final void mo33156a(Bundle bundle, Bundle bundle2) {
        super.mo33156a(bundle, bundle2);
        if (!this.f2901c.f2912g.compareAndSet(true, false)) {
            C2187ar.f2906a.mo33278a(5, "Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.f2901c.mo33160a();
        }
    }
}
