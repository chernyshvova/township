package com.google.android.play.core.assetpacks;

import android.os.Bundle;

/* renamed from: com.google.android.play.core.assetpacks.au */
public final /* synthetic */ class C2190au implements Runnable {

    /* renamed from: a */
    public final C2192aw f2917a;

    /* renamed from: b */
    public final Bundle f2918b;

    /* renamed from: c */
    public final AssetPackState f2919c;

    public C2190au(C2192aw awVar, Bundle bundle, AssetPackState assetPackState) {
        this.f2917a = awVar;
        this.f2918b = bundle;
        this.f2919c = assetPackState;
    }

    public final void run() {
        C2192aw awVar = this.f2917a;
        Bundle bundle = this.f2918b;
        AssetPackState assetPackState = this.f2919c;
        C2232cp cpVar = awVar.f2924c;
        if (((Boolean) cpVar.mo33217a(new C2222cd(cpVar, bundle))).booleanValue()) {
            awVar.f2932k.post(new C2189at(awVar, assetPackState));
            awVar.f2926e.mo33293a().mo33160a();
        }
    }
}
