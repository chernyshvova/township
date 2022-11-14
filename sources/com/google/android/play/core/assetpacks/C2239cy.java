package com.google.android.play.core.assetpacks;

import android.content.Intent;

/* renamed from: com.google.android.play.core.assetpacks.cy */
public final /* synthetic */ class C2239cy implements Runnable {

    /* renamed from: a */
    public final C2240cz f3101a;

    /* renamed from: b */
    public final Intent f3102b;

    public C2239cy(C2240cz czVar, Intent intent) {
        this.f3101a = czVar;
        this.f3102b = intent;
    }

    public final void run() {
        C2240cz czVar = this.f3101a;
        czVar.f3105c.mo33171a(czVar.f3106e, this.f3102b);
    }
}
