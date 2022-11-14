package com.google.android.play.core.assetpacks;

import android.content.ComponentName;
import android.content.Context;
import com.android.billingclient.api.zzam;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.C2318co;

/* renamed from: com.google.android.play.core.assetpacks.q */
public final class C2275q implements C2318co<Object> {

    /* renamed from: a */
    public final C2318co<C2267j> f3215a;

    /* renamed from: b */
    public final C2318co<Context> f3216b;

    public C2275q(C2318co<C2267j> coVar, C2318co<Context> coVar2) {
        this.f3215a = coVar;
        this.f3216b = coVar2;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33167a() {
        C2267j a = this.f3215a.mo33167a();
        Context b = ((C2277s) this.f3216b).mo33167a();
        C2267j jVar = a;
        zzam.m23a(b.getPackageManager(), new ComponentName(b.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"), 4);
        PlayCoreDialogWrapperActivity.m2970a(b);
        zzam.m31b(jVar);
        return jVar;
    }
}
