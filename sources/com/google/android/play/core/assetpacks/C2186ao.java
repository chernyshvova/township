package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C2349i;

/* renamed from: com.google.android.play.core.assetpacks.ao */
public final class C2186ao extends C2182ak<Void> {

    /* renamed from: c */
    public final int f2902c;

    /* renamed from: d */
    public final String f2903d;

    /* renamed from: e */
    public final int f2904e;

    /* renamed from: f */
    public final /* synthetic */ C2187ar f2905f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2186ao(C2187ar arVar, C2349i<Void> iVar, int i, String str, int i2) {
        super(arVar, iVar);
        this.f2905f = arVar;
        this.f2902c = i;
        this.f2903d = str;
        this.f2904e = i2;
    }

    /* renamed from: a */
    public final void mo33155a(Bundle bundle) {
        this.f2905f.f2910e.mo33285a();
        int i = bundle.getInt("error_code");
        C2187ar.f2906a.mo33278a(6, "onError(%d), retrying notifyModuleCompleted...", new Object[]{Integer.valueOf(i)});
        int i2 = this.f2904e;
        if (i2 > 0) {
            this.f2905f.mo33163a(this.f2902c, this.f2903d, i2 - 1);
        }
    }
}
